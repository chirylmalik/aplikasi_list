package com.example.proyekakhirbeginnerandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvKpop: RecyclerView
    private lateinit var btnProfile: ImageView
    private val list = ArrayList<Kpop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKpop = findViewById(R.id.rv_kpop)
        btnProfile = findViewById(R.id.about_page)

        rvKpop.setHasFixedSize(true)
        list.addAll(getListKpop())
        showRecyclerList()
        btnProfile.setOnClickListener(this)
    }

    private fun getListKpop(): ArrayList<Kpop> {
        val dataName = resources.getStringArray(R.array.data_kpop)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listKpop = ArrayList<Kpop>()
        for (i in dataName.indices) {
            val kpop = Kpop(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listKpop.add(kpop)
        }
        return listKpop
    }

    private fun showRecyclerList() {
        rvKpop.layoutManager = LinearLayoutManager(this)
        val listKpopAdapter = ListKpopAdapter(list)
        rvKpop.adapter = listKpopAdapter
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.about_page -> {
                val intent = Intent(this, AboutPageActivity::class.java)
                startActivity(intent)
            }
        }
    }
}