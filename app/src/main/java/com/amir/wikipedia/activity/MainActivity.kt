package com.amir.wikipedia.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.amir.wikipedia.R
import com.amir.wikipedia.databinding.ActivityMainBinding
import com.amir.wikipedia.fragments.FragmentExplore
import com.amir.wikipedia.fragments.FragmentPhotographer
import com.amir.wikipedia.fragments.FragmentProfile
import com.amir.wikipedia.fragments.FragmentTrend
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolBarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolBarMain,
            R.string.openDrawer,
            R.string.closeDrawer,
        )

        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {
                    val dialog = SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    dialog.titleText = "Alert"
                    dialog.confirmText = "Confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "Want to be a writer?"
                    dialog.setCancelClickListener {
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        Toast.makeText(this, "www", Toast.LENGTH_SHORT).show()
                    }
                    dialog.show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_photographer -> {
                    // Load fragment
                    replaceFragment(FragmentPhotographer())

                    // Make menu item checkable and checked
                    it.isCheckable = true
                    it.isChecked = true

                    // Close drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_video_maker -> {
                    Snackbar
                        .make(binding.root, "no internet", Snackbar.LENGTH_LONG)
                        .setAction("Retry") {

                            Toast.makeText(this, "checkingNetwork", Toast.LENGTH_SHORT).show()
                        }
                        .setActionTextColor(ContextCompat.getColor(this, R.color.orange))
                        .setBackgroundTint(ContextCompat.getColor(this, R.color.gray))
                        .show()

                    // Close Drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_translator -> {
                    // Open Activity
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)

                    // Close Drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_open_wikipedia -> {
                    // open wikipedia
                    openWebsite("https://www.wikipedia.org/")

                    // Close Drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_visit_wikimedia -> {
                    // open wikipedia
                    openWebsite("https://www.wikimedia.org/")

                    // Close Drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

        firstRun()

        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_explore -> {
                    replaceFragment(FragmentExplore())
                }

                R.id.menu_trend -> {
                    replaceFragment(FragmentTrend())
                }

                R.id.menu_profile -> {
                    replaceFragment(FragmentProfile())
                }
            }
            // Uncheck the photographer menu item in the navigation drawer
            binding.navigationViewMain.menu.findItem(R.id.menu_photographer).isChecked = false

            true
        }
    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    private fun firstRun() {
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Uncheck the photographer menu item in the navigation drawer
        binding.navigationViewMain.menu.findItem(R.id.menu_photographer).isChecked = false
    }


    // for menu override this 2 function
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_Exit ->{
                // what this menu do
                onBackPressed()
                finish()
            }

        }

        return true
    }
}
