package com.example.pokeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pokeapp.R
import kotlinx.android.synthetic.main.fragment_logeo.*

class LogeoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logeo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener{
            val action = LogeoFragmentDirections.actionLogeoFragment2ToHomeFragment2(entrenador.text.toString())
            findNavController().navigate(action)
           // findNavController().navigate(R.id.action_logeoFragment2_to_homeFragment2)
        }
    }

}