package com.example.myapplication09

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //다른 곳에서 쓰니까 바인딩을 이 위치(레벨)에서
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        //view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //코드로 액션바 메뉴 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //add(그룹, 아이디, 시퀀스(순서), 출력문)
        val menuItem1 : MenuItem? = menu?.add(0, 0, 0, "빨강")
        val menuItem2 : MenuItem? = menu?.add(0, 1, 0, "노랑")
        val menuItem3 : MenuItem? = menu?.add(0, 2, 0, "파랑")
        return super.onCreateOptionsMenu(menu)
    }
    //일을 처리해주는 함수
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
        //어떤 menuItem을 선택했느냐에 따라 작업을 하겠다.
            0 -> {
                binding.textView.setTextColor(Color.RED)
                true
            }
            1 -> {
                binding.textView.setTextColor(Color.YELLOW)
                true
            }
            2 -> {
                binding.textView.setTextColor(Color.BLUE)
                true
            }
        else -> super.onOptionsItemSelected(item)

    }

}