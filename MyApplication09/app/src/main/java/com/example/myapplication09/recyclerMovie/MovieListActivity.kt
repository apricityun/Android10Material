package com.example.myapplication09.recyclerMovie

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.*
import com.example.myapplication09.R
import com.example.myapplication09.databinding.ActivityMovieListBinding
import com.example.myapplication09.databinding.ItemBinding
import com.example.myapplication09.databinding.MovielistBinding

class MovieListActivity : AppCompatActivity() {
    lateinit var binding:ActivityMovieListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_movie_list)

        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //img, title, rate //가장 찬란한 순간, 우리는 하나였다. 써니
        val arrImg = arrayOf(R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07,R.drawable.mov08, R.drawable.mov09, R.drawable.mov10)
        val arrTitle = arrayOf("가장 찬란한 순간, 우리는 하나였다. 써니", "완득이", "괴물", "라디오스타", "비열한 거리", "왕의남자", "아일랜드",
            "웰컴투동막골", "헬보이", "Back To the Future")
        val arrRating = arrayOf(5.0F, 4.5F, 5.0F, 4.8F, 4.5F, 4.0F, 4.5F, 4.6F, 3.9F, 4.5F)

        //리스트 가로 배열 - 가로 스와핑
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        binding.movieList.layoutManager = layoutManager

        //리스트 그리드 배열 -
//        val layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
//        val layoutManager = GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false)
//        binding.movieList.layoutManager = layoutManager

        //StaggeredGrid
//        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.movieList.layoutManager = layoutManager

        //생성한 layout resource : movielist.xml
//        binding.movieList.layoutManager = LinearLayoutManager(this)
        binding.movieList.adapter = MyAdapter(arrImg, arrTitle, arrRating)
//        binding.movieList.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        //Item Decoration Setting
        binding.movieList.addItemDecoration(MyDecoration(this))

    }
}
//Item Decoration
class MyDecoration(val context: Context): RecyclerView.ItemDecoration(){
    //함수 구현이 필수가 아니라서 자동완성 안 됨. 직접 입력할 것.

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(BitmapFactory.decodeResource(context.resources, R.drawable.stadium), 0f, 0f, null)
        //가져올 위치 / 배치 위치 : 0f, 0f / null
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view)+1
        if(index % 3 == 0){
            outRect.set(10,10,10,60)
        }else{
            outRect.set(10,10,10,0)
        }
        view.setBackgroundColor(Color.LTGRAY)
        ViewCompat.setElevation(view, 30.0f) //setElevation 경사지는 것
    }

}
//movielist.xml로 만든 것 바인딩 ↓
class MyViewHolder(val binding:MovielistBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter(val arrImg: Array<Int>, val arrTitle:Array<String>, val arrRating:Array<Float>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(MovielistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.ivPoster.setImageResource(arrImg[position])
        binding.tvTitle.text = "제목 : ${arrTitle[position]}"
        binding.tvRating.text = "평점 : ${arrRating[position]}"
    }

    override fun getItemCount(): Int {
        return arrTitle.size
    }

}