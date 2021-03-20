package com.thor.wisatamadiun.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thor.wisatamadiun.activty.DetailKategori
import com.thor.wisatamadiun.databinding.ListKategoriBinding
import com.thor.wisatamadiun.model.DataItem
import com.thor.wisatamadiun.model.DataKategori

class KategoriAdapter(val data: List<DataKategori?>?, val c:Context): RecyclerView .Adapter<KategoriAdapter.KategoriHolder>(){
    class KategoriHolder(val binding: ListKategoriBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataKategori?, c: Context){
            binding.txtNamaKategori.text = data?.namaKategoriWisata

            binding.root.setOnClickListener {
                val intent = Intent(c, DetailKategori::class.java)
                intent.putExtra("current kategori", data)

                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriHolder {
        val binding = ListKategoriBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return KategoriHolder(binding)
    }

    override fun onBindViewHolder(holder: KategoriHolder, position: Int) {
        holder.bind(data?.get(position), c)
    }

    override fun getItemCount() = data?.size ?: 0
}