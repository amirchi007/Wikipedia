package com.amir.wikipedia.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.amir.wikipedia.databinding.ActivityMain2Binding
import com.amir.wikipedia.dataclasses.ItemPost
import com.amir.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarAsli)


        binding.collapasingMain.setExpandedTitleColor(
            ContextCompat.getColor(this,android.R.color.transparent)
        )

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        // receive data from fragment into activity and show it in activity
        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
        if (dataPost != null){
            showData(dataPost)
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home ){
         onBackPressed()
        }
        return true
    }

    private fun showData(itempost: ItemPost) {
       Glide
           .with(this)
           .load(itempost.imgUrl)
           .into(binding.imgDetail)

        binding.txtDetailTitle.text = itempost.txtTitle
        binding.txtDetailSubtitle.text = itempost.txtSubtitle
        binding.txtDetailText.text = itempost.txtDetails


        binding.fabDetailOpenWikipedia.setOnClickListener {
            //open wikipedia with intent
            val url = "https://en.wikipedia.org/wiki/Main_Page"
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse(url))
            startActivity(intent)
        }
    }
}