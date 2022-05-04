package com.example.myapplication09.test1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import com.example.myapplication09.R
import com.example.myapplication09.databinding.ActivityTest1Binding

class Test1Activity : AppCompatActivity() {
    //binding
    lateinit var binding: ActivityTest1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_test1)

        //view Binding
        binding = ActivityTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //toolbar
        setSupportActionBar(binding.toolbar)

        //♣ (4-2)
        registerForContextMenu(binding.button)
    }
    //♣ (4-2) 버튼 눌렀을 때 메뉴 뜨도록 하는 것
    override fun onCreateContextMenu(
        //매개변수들
        menu: ContextMenu?,
        v: View?, //registerForContextMenu
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
       var inflater = this.menuInflater //main activity에 있는 menu
       if(v == binding.button){
           inflater.inflate(R.menu.context_menu, menu)
       }
    }
    //♣(4-2) 버튼 눌렀을 때 뜬 메뉴의 각각에 실행문 부여
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemTextRed -> {
                binding.textView2.setTextColor(Color.RED)
                return true
            }
            R.id.itemTextGreen -> {
                binding.textView2.setTextColor(Color.GREEN)
                return true
            }
            R.id.itemTextBlue -> {
                binding.textView2.setTextColor(Color.BLUE)
                return true
            }
            //글자 크기 확대/축소 설정
            R.id.sizeEx -> {
                binding.textView2.setTextSize(binding.textView2.textSize*2)
                return true
            }
            R.id.sizeSub -> {
                //*0.5F했을 때 오히려 커졌음. 왜?
                binding.textView2.setTextSize((binding.textView2.textSize*0.1F))
                return true
            }
        }
        return false
    }

    //메뉴 만들기
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        //inflater 레이아웃에 그려진 걸 펼쳐준다는 뜻.
        var inflater = menuInflater
        inflater.inflate(R.menu.menu1, menu)

        //★ searchView 기능 부여
        var menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView //androidx
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            //검색 창에 텍스트를 입력하고 있을 때, 실행할 내용
            override fun onQueryTextChange(newText: String?): Boolean {
                //원래는 디비랑 연동해서 쓰지만, 간단실습이므로 텍스트뷰에서 확인
                binding.textView2.setText("onQueryTextChange: ${newText}") //검색 버튼 누르기 전까지
                return true
            }
            //검색 버튼을 눌렀을 때, 실행할 내용
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.textView2.setText("onQueryTextSubmit: ${query}") //검색 버튼 눌렀을 때,
                return true
            }
        })
        return true
    }

    //메뉴 선택했을 때 처리
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemRed -> {
                binding.textView2.setBackgroundColor(Color.RED)
                return true
            }
            R.id.itemGreen -> {
                binding.textView2.setBackgroundColor(Color.GREEN)
                return true
            }
            R.id.itemBlue -> {
                binding.textView2.setBackgroundColor(Color.BLUE)
                return true
            }
            //글자 크기 확대/축소 설정
            R.id.sizeEx -> {
                binding.textView2.setTextSize(binding.textView2.textSize*2)
                return true
            }
            R.id.sizeSub -> {
                //*0.5F했을 때 오히려 커졌음. 왜?
                binding.textView2.setTextSize((binding.textView2.textSize*0.1F))
                return true
            }
        }
        return false
    }
}