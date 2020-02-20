package com.example.dicodingsubmissionapp.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingsubmissionapp.R
import com.example.dicodingsubmissionapp.adapter.ListWeaponAdapter
import com.example.dicodingsubmissionapp.data.WeaponData
import com.example.dicodingsubmissionapp.model.Weapon
import kotlinx.android.synthetic.main.fragment_weapon_list.*

class WeaponListFragment : Fragment(){

    private lateinit var adapter: ListWeaponAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weapon_list,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_weapon?.setHasFixedSize(true)
        rv_weapon?.layoutManager = LinearLayoutManager(context)
        adapter = ListWeaponAdapter(WeaponData.listData)
        rv_weapon.adapter = adapter
        showWeapon(" ")
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMenuMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMenuMode (selectedMode : Int){
        when(selectedMode){
            R.id.action_show_all ->{
                showWeapon(" ")
            }
            R.id.action_ar_weapon ->{
                showWeapon("Assault Rifle")
            }
            R.id.action_sniper_weapon ->{
                showWeapon("Sniper Rifle")
            }
            R.id.action_lmg_weapon ->{
                showWeapon("Light Machine Gun")
            }
            R.id.action_smp_weapon ->{
                showWeapon("Submachine Gun")
            }
            R.id.action_shotgun_weapon ->{
                showWeapon("Shotgun")
            }
            R.id.action_pistol_weapon ->{
                showWeapon("Pistol")
            }
        }
    }
    private fun showWeapon(a: String?){
        adapter.filter.filter(a)
        adapter.setOnItemClickCallback(object : ListWeaponAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Weapon) {
                showSelectedWeapon(data)
            }
        })
    }
    private fun showSelectedWeapon(weapon :Weapon) {
        Toast.makeText(context, "Kamu memilih " + weapon.name, Toast.LENGTH_SHORT).show()
        val detailFragment = WeaponDetailFragment.newInstance(weapon)
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_holder,detailFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}