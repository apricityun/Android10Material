package com.example.lab10material.t4Nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab10material.R
import com.example.lab10material.databinding.ActivityNavigationViewBinding
import com.example.lab10material.databinding.ActivityViewPagerLinkBinding

class NavigationViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_navigation_view)

        val binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //확장된 플로팅 액션 버튼
        binding.extendFab.setOnClickListener {
            when(binding.extendFab.isExtended){
                true -> binding.extendFab.shrink() //
                false -> binding.extendFab.extend() //확장 형태
            }
            binding.tvResult.text = "HELLO"
        }

        binding.navBar.setNavigationItemSelectedListener {
            when(it.title){
                //res/menu/menu_navigation.xml의 item id
                "item1" -> {
                    binding.tvResult.text = "item1"
                    true
                }
                "item2" -> {
                    binding.tvResult.text = "item2"
                    true
                }
                "item3" -> {
                    binding.tvResult.text = "item3"
                    true
                }
                "item4" -> {
                    binding.tvResult.text = "item4"
                    true
                }

            }
            binding.tvResult.text = "${it.title}"
            binding.drawer.closeDrawer(binding.navBar) // 메뉴 선택하면 자동으로 drawerlayout menu가 닫힘
            true
        }
    }
}