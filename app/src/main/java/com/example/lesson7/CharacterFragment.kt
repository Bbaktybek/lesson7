package com.example.lesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson7.databinding.FragmentCharacterBinding


class CharacterFragment : Fragment() {

    private lateinit var binding:FragmentCharacterBinding

    private lateinit var characterList: ArrayList<Character>

    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = CharacterAdapter(characterList, this::onClick)
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {
        characterList = ArrayList<Character>()


        characterList.apply {
            add(Character("Rick Sanchez", "Alive", R.drawable.rick))
            add(Character("Morty Smith", "Alive", R.drawable.morty))
            add(Character("Albert Einstein", "Dead", R.drawable.albert))
            add(Character("Jerry Smith", "Alive", R.drawable.jerry))
        }
    }

    private fun onClick(character: Character){
        findNavController().navigate(CharacterFragmentDirections.actionCharacterFragmentToSingleCharacterFragment(character))
    }

}
