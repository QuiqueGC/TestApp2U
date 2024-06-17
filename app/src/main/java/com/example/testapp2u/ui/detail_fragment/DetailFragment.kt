package com.example.testapp2u.ui.detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testapp2u.R
import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var mBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    private val mViewModel: DetailFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(
            layoutInflater, container, false
        )
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()

        observeViewModel()

        mViewModel.getArtistById(args.idPhotographer)
    }

    private fun setupListeners() {
        mBinding.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            mViewModel.uiState.collect {
                when (it) {
                    is DetailFragmentUiState.Loading -> {
                        mBinding.progressBar.visibility = View.VISIBLE
                    }

                    is DetailFragmentUiState.Success -> {
                        mBinding.progressBar.visibility = View.GONE
                        setupData(it.artist)
                    }
                }
            }
        }
    }

    private fun setupData(artist: ArtistModel) {
        with(mBinding) {
            tvNameArtist.text =
                getString(R.string.artistFullName, artist.firstName, artist.lastName)
            tvArtistDescription.text = artist.description
            Glide.with(requireContext())
                .load(artist.image)
                .apply(RequestOptions().centerCrop())
                .error(R.drawable.artist_placeholder)
                .into(imgArtist)
        }
    }
}