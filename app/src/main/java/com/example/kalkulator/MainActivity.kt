package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //deklarasi
    private lateinit var panjang : EditText
    private lateinit var lebar: EditText
    private lateinit var tinggi : EditText
    private lateinit var btn: Button
    private lateinit var hasil: TextView
    companion object{
        private const val State_Result = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(State_Result, hasil.text.toString())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inisialisai variabel
        panjang = findViewById(R.id.edt_length)
        lebar = findViewById(R.id.edt_width)
        tinggi = findViewById(R.id.edt_height)
        btn = findViewById(R.id.btn_result)
        hasil = findViewById(R.id.result)

        btn.setOnClickListener(this)
        if (savedInstanceState != null){
            val result = savedInstanceState.getString(State_Result)
            hasil.text = result
        }
    }

    override fun onClick(v : View?) {
        if (v?.id==R.id.btn_result){
            val input_panjang = panjang.text.toString().trim()
            val input_lebar = lebar.text.toString().trim()
            val input_tinggi = tinggi.text.toString().trim()
            val volume = input_panjang.toDouble()*input_lebar.toDouble()*input_tinggi.toDouble()
            hasil.text = volume.toString()
        }
    }
}