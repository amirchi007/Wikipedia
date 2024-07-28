package com.amir.wikipedia.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amir.wikipedia.R
import com.amir.wikipedia.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.chipAndroid.setOnClickListener {
//            Toast.makeText(this, "android", Toast.LENGTH_SHORT).show()
//        }


//        binding.chipAndroid.setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked) {
//                Toast.makeText(this, "chip is checked", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "chip is not checked", Toast.LENGTH_SHORT).show()
//            }
//        }
        binding.chipAndroid.setOnCloseIconClickListener {

        }
        binding.chipGroupMain.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.chip_android -> {
                    Toast.makeText(this, "group checked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}