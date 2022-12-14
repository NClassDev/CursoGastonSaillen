package com.example.cursogastonsaillen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

class PrimerFragment : Fragment(R.layout.fragment_primer) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_primer_fragment_ir_segundo_fragment)

        val text = view.findViewById<TextView>(R.id.txt_mensaje_primer_fragment)

        setFragmentResultListener("requestKey") { key, bundle ->
            val result = bundle.getString("bundleKey")
            text.text = result
        }

        button.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                //add(R.id.fragment_container_view, SegundoFragment()) // Agrega el fragment por encima
                replace(R.id.fragment_container_view, SegundoFragment.newInstance("Javier", 33)) // remplaza el fragment actual por el convocado
                addToBackStack("primerFragment")
            }
        }
    }
}