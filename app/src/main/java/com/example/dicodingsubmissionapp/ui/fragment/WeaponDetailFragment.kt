package com.example.dicodingsubmissionapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dicodingsubmissionapp.R
import com.example.dicodingsubmissionapp.model.Weapon
import kotlinx.android.synthetic.main.fragment_weapon_detail.*

private const val SELECTED_WEAPON = "selected_weapon"

class WeaponDetailFragment : Fragment(){

    private var selected_weapon: Weapon? = null

    companion object {
        fun newInstance(weapon: Weapon) =
            WeaponDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(SELECTED_WEAPON, weapon)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selected_weapon = it.getParcelable(SELECTED_WEAPON)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weapon_detail,container,false)
    }

    override fun onStart() {
        super.onStart()
        selected_weapon?.photo?.let { iv_weapon.setImageResource(it) }
        tv_weapon_description.text = selected_weapon?.description
        tv_weapon_ammo.text = selected_weapon?.ammo
        tv_weapon_type.text = selected_weapon?.type
        tv_weapon_range.text = selected_weapon?.range
        tv_weapon_power.text = selected_weapon?.power
        tv_weapon_stability.text = selected_weapon?.stability
        tv_weapon_firing.text = selected_weapon?.firingrate

    }

    private fun getWeapon(){

    }

}