package com.thor.wisatamadiun.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

    @field:SerializedName("img_wisata")
    val imgWisata: String? = null,

    @field:SerializedName("id_wisata")
    val idWisata: String? = null,

    @field:SerializedName("id_kategori")
    val idKategori: String? = null,

    @field:SerializedName("lokasi")
    val lokasi: String? = null,

    @field:SerializedName("nama_wisata")
    val namaWisata: String? = null,

    @field:SerializedName("deskripsi")
    val deskripsi: String? = null
) : Parcelable