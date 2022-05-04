package com.example.lab10material

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab10material.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    //binding
    lateinit var binding : FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //binding
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

}