package com.thor.wisatamadiun.activty

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.thor.wisatamadiun.adapter.KategoriAdapter
import com.thor.wisatamadiun.databinding.ActivityHomeBinding
import com.thor.wisatamadiun.model.ResponseGetKategori
import com.thor.wisatamadiun.network.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showKategori()

        binding.txtAllWisata.setOnClickListener {
            val intent = Intent(this, DetailKategori::class.java)
            startActivity(intent)
        }
    }

    private fun showKategori() {
        NetworkModule.service().getKategori().enqueue(object : Callback<ResponseGetKategori> {
            override fun onResponse(
                call: Call<ResponseGetKategori>,
                response: Response<ResponseGetKategori>
            ) {
                if (response.isSuccessful) {
                    binding.progressBarDetail.visibility = View.GONE
                    Log.d("response succes", response.message())
                    val data = response.body()?.data
                    if (data?.size ?: 0 > 0) {
                        binding.rvKategori.adapter = KategoriAdapter(data, this@Home)
                    }

                }
            }

            override fun onFailure(call: Call<ResponseGetKategori>, t: Throwable) {
                Log.d("koneksi on failure", t.message.toString())
                binding.progressBarDetail.visibility = View.GONE
            }
        })
    }
}