package com.example.testapp2u.ui.list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapp2u.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var mBinding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentListBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

}