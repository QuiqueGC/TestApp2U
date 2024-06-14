package com.example.testapp2u.ui.list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp2u.databinding.FragmentListBinding
import com.example.testapp2u.ui.list_fragment.adapter.ArtistsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(), ArtistsAdapter.ItemArtistListener {

    private lateinit var mBinding: FragmentListBinding
    private lateinit var mAdapter: ArtistsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentListBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
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