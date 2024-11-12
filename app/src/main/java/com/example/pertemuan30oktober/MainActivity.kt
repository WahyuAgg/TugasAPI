package com.example.tugasapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapiapplication.network.ApiClient
import com.example.tugasapi.databinding.ActivityMainBinding
import retrofit2.Call
import com.example.tugasapi.model.Surat

import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetch data dari API
        val client = ApiClient.getInstance()
        val responseSurat = client.getSurat()

        responseSurat.enqueue(object : Callback<List<Surat>> {
            override fun onResponse(call: Call<List<Surat>>, response: Response<List<Surat>>) {
                if (response.isSuccessful && response.body() != null) {
                    val suratList = response.body()!!

                    // Set up  RecyclerView dengan Surat adapter
                    val suratAdapter = SuratAdapter(suratList) { surat ->
                        // Handle item click
                        Toast.makeText(this@MainActivity, "Surat: ${surat.nama}", Toast.LENGTH_SHORT).show()
                    }

                    with(binding.recyclerView) {
                        layoutManager = LinearLayoutManager(this@MainActivity) // Linear layout
                        adapter = suratAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Surat>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Connection error", Toast.LENGTH_SHORT).show()
            }
        })


    }
}
