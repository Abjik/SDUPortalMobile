package com.example.sdu_portal_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.sdu_portal_mobile.databinding.FragmentBookBinding

class BookFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBookBinding>(inflater,
            R.layout.fragment_book,container,false)
        return binding.root
    }
}