package com.example.datawarehouseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.datawarehouseproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding()
        whenPushNextButton()
    }

    private fun whenPushNextButton()
    {
        binding.button1.setOnClickListener()
        {
            val intent = Intent(this, SelectionScreenActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
        }
    }
    private fun ActivityMainBinding()
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}