package com.thor.wisatamadiun.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataKategori(

    @field:SerializedName("id_kategori")
    val idKategori: Int? = null,

    @field:SerializedName("nama_kategori_wisata")
    val namaKategoriWisata: String? = null
) : Parcelable