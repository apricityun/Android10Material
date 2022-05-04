package com.example.lab10material.t2Tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab10material.OneFragment
import com.example.lab10material.R
import com.example.lab10material.ThreeFragment
import com.example.lab10material.TwoFragment
import com.example.lab10material.databinding.ActivityT2tabBinding
import com.google.android.material.tabs.TabLayout

class T2tabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_t2tab)
        //view binding
        val binding = ActivityT2tabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //메서드 체인으로 바로 붙였음.
        supportFragmentManager.beginTransaction().add(R.id.tabContent, OneFragment()).commit()

        //추상 메서드 구현 필수 ↓
        binding.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //트랜잭션으로 프래그먼트 붙이기
                val transaction = supportFragmentManager.beginTransaction()
                when(tab?.text){
                    "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
                    "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
                    "Tab3" -> transaction.replace(R.id.tabContent, ThreeFragment())
                }
                transaction.addToBackStack(null) //화면에서 사라진 Fragment를 메모리에서 삭제하지 않고 모아두는 것. pause 상태로 유지.
                transaction.commit()
/*
* 기존에 replace만 사용했을 때는 Fragment가 Destory 되었지만 BackStack에 들어가면 Pause 상태에서 멈춘다.*/
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}