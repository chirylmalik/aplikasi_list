package com.example.proyekakhirbeginnerandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvHistory: TextView = findViewById(R.id.tv_history)
        val tvMember: TextView = findViewById(R.id.tv_member)
        val btnProfile: ImageView = findViewById(R.id.about_page)

        val name = intent.getStringExtra("EXTRA_NAME")
        val description = intent.getStringExtra("EXTRA_DESCRIPTION")
        val photo = intent.getIntExtra("EXTRA_PHOTO", 0)
        val groupPosition = intent.getIntExtra("GROUP_POSITION", 0)

        val histories = resources.getStringArray(R.array.data_history)
        val members = resources.getStringArray(R.array.data_member)

        tvName.text = name
        tvDescription.text = description
        imgPhoto.setImageResource(photo)
        tvHistory.text = histories[groupPosition]
        tvMember.text = members[groupPosition]

        btnProfile.setOnClickListener(this)
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