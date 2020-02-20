package com.example.dicodingsubmissionapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.dicodingsubmissionapp.R
import com.example.dicodingsubmissionapp.ui.fragment.WeaponListFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragmentWeaponList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.action_about ->{
                showAbout()
            }
        }
    }
    private fun showAbout() {
        val open = Intent(this@MainActivity,
            AboutActivity::class.java)
        startActivity(open)
    }

    private fun showFragmentWeaponList(){
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = WeaponListFragment()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.commit()
    }
}
