package com.example.lab10task_material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab10task_material.databinding.ActivityMainBinding
import com.example.lab10task_material.databinding.ItemBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //extend Floating button
        binding.btnFloating.setOnClickListener {
            when(binding.btnFloating.isExtended){
                true -> binding.btnFloating.shrink()
                false -> binding.btnFloating.extend()
            }
        }

        //toolbar
        setSupportActionBar(binding.toolbar)

        //view list
        val arrName = arrayOf("강기동", "구주용", "김경래", "김승현", "김은진", "박정현", "신재경", "안영륜", "안혜민", "우소윤",
            "강기동01", "구주용01", "김경래01", "김승현01", "김은진01", "박정현01", "신재경01", "안영륜01", "안혜민01", "우소윤01")
        val arrPhone = arrayOf("010-1111-1234", "010-1112-1234", "010-1113-1234", "010-1114-1234", "010-1115-1234",
            "010-1116-1234", "010-1117-1234", "010-1118-1234", "010-1119-1234", "010-1120-1234",
            "010-2111-1234", "010-2112-1234", "010-2113-1234", "010-2114-1234", "010-2115-1234",
            "010-2116-1234", "010-2117-1234", "010-2118-1234", "010-2119-1234", "010-2120-1234")

        //recyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(arrName, arrPhone)

        //navBar binding
        binding.navBar.setNavigationItemSelectedListener {
            when(it.title){
                "item1" -> {
//                    binding.tvResult.text = "item1"
                    true
                }
                "item2" -> {
//                    binding.tvResult.text = "item2"
                    true
                }
                "item3" -> {
//                    binding.tvResult.text = "item3"
                    true
                }
                "item4" -> {
//                    binding.tvResult.text = "item4"
                    true
                }
            }
            binding.drawer.closeDrawer(binding.navBar)
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_appbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

class MyViewholder(val binding:ItemBinding): RecyclerView.ViewHolder(binding.root)

class MyAdapter(val arrName: Array<String>, val arrPhone:Array<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewholder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewholder).binding
        binding.tvName.text = arrName[position]
        binding.tvPhone.text = arrPhone[position]
    }

    override fun getItemCount(): Int {
        return arrName.size
    }

}