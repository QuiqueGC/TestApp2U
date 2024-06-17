package com.example.testapp2u.ui.list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp2u.databinding.FragmentListBinding
import com.example.testapp2u.ui.list_fragment.adapter.ArtistsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment(), ArtistsAdapter.ItemArtistListener {

    private lateinit var mBinding: FragmentListBinding
    private lateinit var mAdapter: ArtistsAdapter
    private val mViewModel: ListFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentListBinding.inflate(
            layoutInflater, container, false
        )
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.getArtistsList()
        setupAdapter()
        observeViewModel()

    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            mViewModel.uiState.collect {
                when (it) {
                    is ListFragmentUiState.Loading -> {
                        mBinding.progressBar.visibility = View.VISIBLE
                    }

                    is ListFragmentUiState.Success -> {
                        mBinding.progressBar.visibility = View.GONE
                        mAdapter.refreshData(it.artists)
                    }
                }
            }
        }
    }

    private fun setupAdapter() {
        mAdapter = ArtistsAdapter(requireContext(), this, listOf())
        with(mBinding) {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = mAdapter
        }
    }

    override fun onClick(idArtist: Int) {
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToDetailFragment(
                idArtist
            )
        )
    }
}