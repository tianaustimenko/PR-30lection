package com.example.pr_lection30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val button: Button = findViewById(R.id.buttonLaunch)
        val mainViewModel: MainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getValue()?.observe(this) { value ->
            progressBar.progress = value
            textViewStatus.setText("Статус: $value")
        }
        button.setOnClickListener { mainViewModel.execute() }
    }
}