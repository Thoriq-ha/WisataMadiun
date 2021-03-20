package com.thor.wisatamadiun.activty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.thor.wisatamadiun.databinding.ActivityDetailItemBinding
import com.thor.wisatamadiun.model.DataItem
import com.thor.wisatamadiun.model.DataKategori

class DetailItem : AppCompatActivity() {
    lateinit var binding: ActivityDetailItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getDataItem = intent.getParcelableExtra<DataItem>("detailItem")

        binding.txtNamaItemDetail.text = getDataItem?.namaWisata
        binding.txtLokasi.text = getDataItem?.lokasi
        binding.txtDeskripsiItem.text = getDataItem?.deskripsi

        Glide.with(this).load(getDataItem?.imgWisata).into(binding.imgItemDetail)

    }
}