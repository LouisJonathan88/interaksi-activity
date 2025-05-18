package com.example.intenprojects

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class TambahActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnChoose : Button
    private lateinit var rgGender : RadioGroup

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_gender"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tambah)
        btnChoose = findViewById(R.id.btn_tambah_data)
        rgGender = findViewById(R.id.rg_gender)
        btnChoose.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_tambah_data){
            if (rgGender.checkedRadioButtonId != 0){
                var value = ""
                    when(rgGender.checkedRadioButtonId){
                        R.id.radio_perempuan -> value = "Perempuan"
                        R.id.radio_laki_laki -> value = "Laki-Laki"
                    }
                val resulIntent = Intent()
                resulIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resulIntent)
                finish()
            }
        }
    }
}