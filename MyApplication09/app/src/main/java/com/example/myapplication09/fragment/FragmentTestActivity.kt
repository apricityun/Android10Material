package com.example.myapplication09.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication09.OneFragment
import com.example.myapplication09.R
import com.example.myapplication09.TwoFragment
import com.example.myapplication09.databinding.ActivityFragmentTestBinding

class FragmentTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_fragment_test)

        //binding
        var binding= ActivityFragmentTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            val fragmentManger: FragmentManager = supportFragmentManager
            val transaction: FragmentTransaction = fragmentManger.beginTransaction()
            var fragment = OneFragment()
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.button5.setOnClickListener {
            val fragmentManger: FragmentManager = supportFragmentManager
            val transaction: FragmentTransaction = fragmentManger.beginTransaction()
            var fragment = TwoFragment()
            transaction.replace(R.id.container, fragment)
            //
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}