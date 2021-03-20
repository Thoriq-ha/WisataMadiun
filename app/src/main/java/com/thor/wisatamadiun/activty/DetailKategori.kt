package com.thor.wisatamadiun.activty

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.thor.wisatamadiun.adapter.DetailKategoriAdapter
import com.thor.wisatamadiun.databinding.ActivityDetailKategoriBinding
import com.thor.wisatamadiun.model.DataKategori
import com.thor.wisatamadiun.model.ResponseGetData
import com.thor.wisatamadiun.network.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailKategori : AppCompatActivity() {
    lateinit var binding: ActivityDetailKategoriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKategoriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getDataKategori = intent.getParcelableExtra<DataKategori>("current kategori")
        getDetailKategori(NetworkModule.service().getItemById(getDataKategori?.idKategori ?: 0))
    }

    private fun getDetailKategori(res: Call<ResponseGetData>) {
        res.enqueue(object : Callback<ResponseGetData> {
            override fun onResponse(
                call: Call<ResponseGetData>,
                response: Response<ResponseGetData>
            ) {
                if (response.isSuccessful) {
                    binding.progressBar.visibility = View.GONE
                    Log.d("response succes", response.message())
                    val data = response.body()?.data
                    Log.d("datadetail", data?.size?.toString()!!)
                    if (data?.size ?: 0 > 0) {
                        binding.rvItem.adapter = DetailKategoriAdapter(data, this@DetailKategori)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseGetData>, t: Throwable) {
                Log.d("koneksi on failure", t.message.toString())
                binding.progressBar.visibility = View.GONE
            }

        })


    }


}