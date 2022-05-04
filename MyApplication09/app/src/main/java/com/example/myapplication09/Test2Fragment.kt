package com.example.myapplication09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication09.databinding.FragmentTest1Binding
import com.example.myapplication09.databinding.FragmentTest2Binding

class Test2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentTest2Binding.inflate(inflater, container, false)
        return binding.root
    }
}