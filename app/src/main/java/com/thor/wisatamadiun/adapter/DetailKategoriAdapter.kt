package com.thor.wisatamadiun.adapter

import com.thor.wisatamadiun.activty.DetailItem
import com.thor.wisatamadiun.databinding.ListItemBinding


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thor.wisatamadiun.model.DataItem

class DetailKategoriAdapter(val data: List<DataItem?>?, val c:Context): RecyclerView .Adapter<DetailKategoriAdapter.DetailKategoriHolder>(){
    class DetailKategoriHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataItem?, c: Context){
            binding.txtNamaItemBuah.text = data?.namaWisata
            binding.txtLokasi.text = data?.lokasi
            Glide.with(c).load(data?.imgWisata).into(binding.imgItemWisata)

            binding.root.setOnClickListener {
                val intent = Intent(c, DetailItem::class.java)
                intent.putExtra("detailItem", data)

                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailKategoriHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return DetailKategoriHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailKategoriHolder, position: Int) {
        holder.bind(data?.get(position), c)
    }

    override fun getItemCount() = data?.size ?: 0
}