package com.example.dicodingsubmissionapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicodingsubmissionapp.adapter.ListWeaponAdapter
import com.example.dicodingsubmissionapp.R
import com.example.dicodingsubmissionapp.data.WeaponData
import com.example.dicodingsubmissionapp.model.Weapon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rVWeapon: RecyclerView
    lateinit var adapter: ListWeaponAdapter
    private var dataList= ArrayList<Weapon>()
    var weaponTypeSelected: String =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rVWeapon = findViewById(R.id.rv_weapon)
        rVWeapon.setHasFixedSize(true)
        rv_weapon.layoutManager = LinearLayoutManager(this)

        adapter = ListWeaponAdapter(WeaponData.listData)
        rv_weapon.adapter = adapter

        showWeapon()
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
            R.id.action_show_all ->{
                weaponTypeSelected = ""
                showWeapon()
            }
            R.id.action_about ->{
                showAbout()
            }
            R.id.action_ar_weapon ->{
                weaponTypeSelected = "Assault Rifle"
                showWeapon()
            }
            R.id.action_sniper_weapon ->{
                weaponTypeSelected = "Sniper Rifle"
                showWeapon()
            }
            R.id.action_lmg_weapon ->{
                weaponTypeSelected = "Light Machine Gun"
                showWeapon()
            }
            R.id.action_smp_weapon ->{
                weaponTypeSelected = "Submachine Gun"
                showWeapon()
            }
            R.id.action_shotgun_weapon ->{
                weaponTypeSelected = "Shotgun"
                showWeapon()
            }
            R.id.action_pistol_weapon ->{
                weaponTypeSelected = "Pistol"
                showWeapon()
            }
        }
    }

    private fun showSelectedWeapon(weapon :Weapon) {
        Toast.makeText(this, "Kamu memilih " + weapon.name, Toast.LENGTH_SHORT).show()
    }

    private fun showWeapon(){
        dataList.clear()
        adapter.filter.filter(weaponTypeSelected)
        dataList.addAll(WeaponData.listData)
        adapter.setOnItemClickCallback(object : ListWeaponAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Weapon) {
                showSelectedWeapon(data)
            }

        })




    }

    private fun showAbout() {
        val open = Intent(this@MainActivity,
            AboutActivity::class.java)
        startActivity(open)
    }


}
