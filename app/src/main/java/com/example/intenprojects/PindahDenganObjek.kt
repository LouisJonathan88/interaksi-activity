package com.example.intenprojects

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PindahDenganObjek : AppCompatActivity() {

    companion object{
        val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_pindah_dengan_objek)
        val txtObjek : TextView = findViewById(R.id.txt_objek)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Nama: ${person.name.toString()}" +
                "\nEmail: ${person.email.toString()}" +
                "\nUmur: ${person.age.toString()}" +
                "\nKota: ${person.city.toString()}"
        txtObjek.text = text
    }
}