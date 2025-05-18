// Terakhir dikerjakan: Selasa, 13 Mei 2025
// NIM: 10122362
// Nama: Louis Jonathan Susanto Putra
// Kelas: Pemrograman Android 4

package com.example.intenprojects
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtResultValue: TextView

    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == TambahActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getStringExtra(TambahActivity.EXTRA_SELECTED_VALUE)
            txtResultValue.text = "Jenis Kelamin yang Anda Pilih Adalah: $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val btnSubmit: Button = findViewById(R.id.btn_pindah)
        btnSubmit.setOnClickListener(this)

        val btnData: Button = findViewById(R.id.btn_pindah_dengandata)
        btnData.setOnClickListener(this)

        val btnObjek: Button = findViewById(R.id.btn_pindah_denganobjek)
        btnObjek.setOnClickListener(this)

        val btnDial: Button = findViewById(R.id.btn_dial)
        btnDial.setOnClickListener(this)

        val btnOpenAnotherApps: Button = findViewById(R.id.btn_open_anotherapps)
        btnOpenAnotherApps.setOnClickListener(this)

        val btnForResult: Button = findViewById(R.id.btn_for_result)
        btnForResult.setOnClickListener(this)

        txtResultValue = findViewById(R.id.txt_result)
    }

    override fun onClick (v: View){
        when(v.id){
            R.id.btn_pindah -> {
                val pindahIntent = Intent (this@MainActivity, SecondActivity::class.java)
                startActivity(pindahIntent)
            }
            R.id.btn_pindah_dengandata -> {
                val pindahDataIntent = Intent (this@MainActivity, PindahDenganData::class.java)
                pindahDataIntent.putExtra(PindahDenganData.EXTRA_NAME, "Louis Jonathan Susanto Puta")
                pindahDataIntent.putExtra(PindahDenganData.EXTRA_AGE, 21)
                startActivity(pindahDataIntent)
            }
            R.id.btn_pindah_denganobjek -> {
                val person = Person(
                    "Louis Jonathan Susanto Puta",
                    21,
                    "jonathanlouis568@gmail.com",
                    "Bandung"
                )
                val pindahObjekIntent = Intent(this@MainActivity, PindahDenganObjek::class.java)
                pindahObjekIntent.putExtra(PindahDenganObjek.EXTRA_PERSON, person)
                startActivity(pindahObjekIntent)
            }

            R.id.btn_dial -> {
                val phoneNumber = "08963312321"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_open_anotherapps -> {
                val openAnotherApps = Intent(Intent.ACTION_MAIN)
                openAnotherApps.setPackage("com.google.android.youtube")
                startActivity(openAnotherApps)
            }

            R.id.btn_for_result -> {
                val forResultIntent = Intent(this@MainActivity, TambahActivity::class.java)
                resultLauncher.launch(forResultIntent)
            }
        }
    }
}