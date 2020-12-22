package com.example.pokeapp.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pokeapp.R
import com.example.pokeapp.models.User
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
            val action = LogeoFragmentDirections.actionLogeoFragment2ToHomeFragment2(User(entrenador.text.toString(),rMasculino.isChecked,rFemenino.isChecked))
            findNavController().navigate(action)
           // findNavController().navigate(R.id.action_logeoFragment2_to_homeFragment2)
        }

        entrenador.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
               val areValidFields : Boolean = !TextUtils.isEmpty(entrenador.text.toString())
                btnLogin.isEnabled = areValidFields

                entrenador.error = if(TextUtils.isEmpty(entrenador.text.toString())) "Campo requerido" else null
            }

        })

    }

}