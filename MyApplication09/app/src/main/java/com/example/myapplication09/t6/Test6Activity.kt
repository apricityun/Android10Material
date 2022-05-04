package com.example.myapplication09.t6

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication09.Test1Fragment
import com.example.myapplication09.Test2Fragment
import com.example.myapplication09.Test3Fragment
import com.example.myapplication09.databinding.ActivityT6FragmentBinding

class Test6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_t6_fragment)
        val binding = ActivityT6FragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager2f.adapter = MyFragmentAdapter(this) //activity:this
    }
}

class MyFragmentAdapter(activity: Test6Activity): FragmentStateAdapter(activity){
    val fragment: List<Fragment>
    init{
        fragment = listOf(Test1Fragment(), Test2Fragment(), Test3Fragment())
    }

    override fun getItemCount(): Int {
        return fragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragment[position]
    }

}