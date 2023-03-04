package com.example.lesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson7.databinding.FragmentSingleCharacterBinding


class SingleCharacterFragment : Fragment() {

    private lateinit var binding:FragmentSingleCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSingleCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result:Character = arguments?.getSerializable("key")as Character
        binding.tvCharacterName.text = result.name
        binding.tvCharacterStatus.text = result.status
        binding.ivSingleCharacter.setImageResource(result.image)
    }

}