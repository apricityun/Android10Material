package com.example.myapplication09.t7Drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.myapplication09.R
import com.example.myapplication09.databinding.ActivityT7DrawerBinding

class T7DrawerActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_t7_drawer)

        //view binding
        val binding = ActivityT7DrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //drawer toggle
        //binding.drawer의 drawer는 activity_t7_drawer.xml에 지정한 drawerLayout의 이름(id)
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_open, R.string.drawer_close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //액션바에 토글 표시 여부(true/false)
//        supportActionBar?.setDisplayHomeAsUpEnabled(false) //액션바 메뉴 탭 안 보임. 스와이핑으로만 이끌어낼 수 있음.
        toggle.syncState()
    }

    //액션바의 메뉴(토글) 눌렀을 때, 드로어레이아웃 나오도록 하는 설정
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}