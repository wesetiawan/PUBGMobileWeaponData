package com.example.dicodingsubmissionapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dicodingsubmissionapp.R
import com.example.dicodingsubmissionapp.model.Weapon

class ListWeaponAdapter(private val listWeapon: ArrayList<Weapon>) : RecyclerView.Adapter<ListWeaponAdapter.ListViewHolder>(),Filterable {

    private lateinit var onItemClickCallback: OnItemClickCallback
    internal var filterListResult: List<Weapon>
    init {
        this.filterListResult = listWeapon
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_weapon, parent, false)
        return ListViewHolder(view)
    }
    override fun getItemCount(): Int {
        return filterListResult.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val weapon = filterListResult[position]

        Glide.with(holder.itemView.context)
            .load(weapon.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvName.text = filterListResult[position].name
        holder.tvDetail.text = filterListResult[position].detail
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(filterListResult[holder.adapterPosition]) }
    }
    override fun getFilter(): Filter {
       return object:Filter(){
           override fun performFiltering(charString: CharSequence?): FilterResults {
               val charSearch = charString.toString()
               if (charSearch.isEmpty()||charSearch.equals("")||charSearch.equals(" "))
                   filterListResult = listWeapon
               else{
                   val resultList = ArrayList<Weapon>()
                   for (row in listWeapon){
                       if (row.type.contentEquals(charSearch))
                           resultList.add(row)
                   }
                   filterListResult = resultList
               }
               val filterResults = FilterResults()
               filterResults.values = filterListResult
               return filterResults
           }
           override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
               filterListResult = filterResults!!.values as List<Weapon>
               notifyDataSetChanged()
           }
       }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Weapon)
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)

    }

}

