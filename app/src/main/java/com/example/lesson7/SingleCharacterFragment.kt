package com.example.lesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson7.databinding.FragmentSingleCharacterBinding


class SingleCharacterFragment : Fragment() {

    private lateinit var binding:FragmentSingleCharacterBinding

    private lateinit var navArgs: SingleCharacterFragmentArgs
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSingleCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            navArgs = SingleCharacterFragmentArgs.fromBundle(it)
        }
        binding.apply {

            tvCharacterName.text = navArgs.character.name
            tvCharacterStatus.text = navArgs.character.status
            ivSingleCharacter.setImageResource(navArgs.character.image)
        }

    }

}