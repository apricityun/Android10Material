package com.example.myapplication09.recyclerView

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication09.databinding.ActivityRecyclerBinding
import com.example.myapplication09.databinding.ItemBinding

class RecyclerActivity : AppCompatActivity() {
    lateinit var binding:ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_recycler)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //뷰 항목목
       val arrName = arrayOf("강기동", "구주용", "김경래", "김승현", "김은진", "박정현", "신재경", "안영륜", "안혜민", "우소윤")
        val arrPhone = arrayOf("010-1111-1234", "010-1112-1234", "010-1113-1234", "010-1114-1234", "010-1115-1234",
            "010-1116-1234", "010-1117-1234", "010-1118-1234", "010-1119-1234", "010-1120-1234")

        //리사이클러뷰 적용
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdaptor(arrName, arrPhone) //반드시 해줘야 하는 작업
        //추가적으로 설정 가능
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}
//뷰 홀더 생성 - recyclerView를 잡아줌
class MyViewHolder(val binding:ItemBinding): RecyclerView.ViewHolder(binding.root)

//어댑터 생성 - arrName, arrPhone
class MyAdaptor(val arrName:Array<String>, val arrPhone:Array<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //상속받은 RecyclerView.Adapter<RecyclerView.ViewHolder>()의 추상메소드 구현 ↓
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)) //부모 컨텍스트 가져와 쓰겠다. 펼치겠다? / 당장 붙일 것인지 true/false
        //뷰 홀더
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //이름, 전화번호 연결하는 작업
        val binding = (holder as MyViewHolder).binding //생성한 뷰 홀더에서 가져옴.
        binding.tvName.text = arrName[position]
        binding.tvPhone.text = arrPhone[position]
    }

    override fun getItemCount(): Int {
        //항목 개수
        return arrName.size
    }
//리사이클러뷰에 적용하러 Go!
}

