package com.example.dicodingsubmissionapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dicodingsubmissionapp.R
import com.example.dicodingsubmissionapp.adapter.ListWeaponAdapter
import com.example.dicodingsubmissionapp.model.Weapon

class WeaponDetailFragment : Fragment(){

    private lateinit var adapter: ListWeaponAdapter
    private var dataList = ArrayList<Weapon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weapon_detail,container,false)
    }


}