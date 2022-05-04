package com.example.myapplication09.t5ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication09.R
import com.example.myapplication09.databinding.ActivityViewPager1reBinding
import com.example.myapplication09.databinding.ItemPagerBinding

class ViewPager1reActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_pager1re)
        val binding = ActivityViewPager1reBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datas = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10)
        binding.viewPager1.adapter = MyPagerAdapter(datas)
    }
}
//방금 만들었던. item_pager.xml을 바인딩
class MyPagerViewHolder(val binding:ItemPagerBinding): RecyclerView.ViewHolder(binding.root)
//ViewPager는 Adapter가 필요
class MyPagerAdapter(val datas: Array<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            //원래 RecyclerView.ViewHolder(){ ... }이거 였는데, {}없애고 바로 붙임. 안에 내용이 별로 없어서.
            RecyclerView.ViewHolder = MyPagerViewHolder(ItemPagerBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyPagerViewHolder).binding
        binding.imageView2.setImageResource(datas[position]) //item_pager.xml의 imageView에 사진 넣음
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}