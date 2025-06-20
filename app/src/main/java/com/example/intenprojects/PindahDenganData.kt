package com.example.intenprojects

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class PindahDenganData : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pindah_dengan_data)
        val txtData: TextView = findViewById(R.id.txt_data)
        
        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val text = "Nama: $name, Umur: $age"
        txtData.text = text
    }
}