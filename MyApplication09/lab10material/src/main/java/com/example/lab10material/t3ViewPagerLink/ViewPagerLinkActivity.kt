package com.example.lab10material.t3ViewPagerLink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab10material.Test1Fragment
import com.example.lab10material.Test2Fragment
import com.example.lab10material.Test3Fragment
import com.example.lab10material.databinding.ActivityViewPagerLinkBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_pager_link)

        //binding
        val binding = ActivityViewPagerLinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter1 = MyFragmentAdapter(this) //어댑터 생성
        binding.viewPager.adapter = adapter1 //뷰페이즈에 어댑터 붙이기

        //탭(TabLayout)과 뷰페이즈(ViewPager) 붙이기
        TabLayoutMediator(binding.tabs, binding.viewPager){
            tab, position -> tab.text = "Tab${(position + 1)}"
        }.attach()
    }
}
class MyFragmentAdapter(activity: ViewPagerLinkActivity): FragmentStateAdapter(activity){
    val fragments: List<Fragment>
    init{
        fragments = listOf(Test1Fragment(), Test2Fragment(), Test3Fragment())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}