package com.example.testapp2u.ui.detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapp2u.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var mBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

}