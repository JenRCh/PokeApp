package com.example.pokeapp.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pokeapp.R
import com.example.pokeapp.models.User
import com.jakewharton.rxbinding4.view.clicks
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable.combineLatest
import io.reactivex.rxjava3.core.Observable.combineLatest
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.Flowables.combineLatest
import io.reactivex.rxjava3.kotlin.Observables.combineLatest
import kotlinx.android.synthetic.main.fragment_logeo.*
import java.util.*
import java.util.concurrent.TimeUnit

class LogeoFragment : Fragment() {

    private val disposables = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logeo, container, false)
    }

    override fun onDestroyView() {
        disposables.clear()
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       btnLogin.setOnClickListener{

           if(radioGroup.checkedRadioButtonId == R.id.rFemenino){
               val action = LogeoFragmentDirections.actionLogeoFragment2ToHomeFragment2(
                       User(entrenador.text.toString(),"Femenino"))
               findNavController().navigate(action)
           }
           else{
               val action = LogeoFragmentDirections.actionLogeoFragment2ToHomeFragment2(
                       User(entrenador.text.toString(),"Masculino"))
               findNavController().navigate(action)
           }
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