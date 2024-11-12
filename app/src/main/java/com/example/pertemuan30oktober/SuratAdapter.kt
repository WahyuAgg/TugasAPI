package com.example.tugasapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasapi.databinding.ItemSuratBinding
import com.example.tugasapi.model.Surat

class SuratAdapter(
    private val suratList: List<Surat>,
    private val onClickSurat: (Surat) -> Unit
) : RecyclerView.Adapter<SuratAdapter.SuratViewHolder>() {

    inner class SuratViewHolder(private val binding: ItemSuratBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(surat: Surat) {
            binding.txtArti.text = "Arti: ${surat.arti}"
            binding.txtAsma.text = surat.asma
            binding.txtAyat.text = "Ayat: ${surat.ayat}"  // Menambahkan "Ayat: " sebelum angka ayat

            binding.root.setOnClickListener {
                onClickSurat(surat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuratViewHolder {
        val binding = ItemSuratBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuratViewHolder(binding)
    }

    override fun getItemCount(): Int = suratList.size

    override fun onBindViewHolder(holder: SuratViewHolder, position: Int) {
        holder.bind(suratList[position])
    }
}



