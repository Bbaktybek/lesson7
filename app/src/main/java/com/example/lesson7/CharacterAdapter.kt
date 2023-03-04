package com.example.lesson7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson7.databinding.ItemCharacterBinding

class CharacterAdapter(private val characterList: ArrayList<Character>,
private val onClick:(character:Character)->Unit):
    Adapter<CharacterAdapter.CharacterViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind()
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) : ViewHolder(binding.root){

        fun bind() {
            val item = characterList[adapterPosition]
            binding.apply {
                tvName.text = item.name
                tvStatus.text = item.status
                ivCharacter.setImageResource(item.image)
            }
            itemView.setOnClickListener { onClick.invoke(item) }
        }
    }
}