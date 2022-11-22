package com.example.cursogastonsaillen

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private var nombre: String? = ""
    private var edad: Int? = 0
    private val args: SegundoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = args.nombre
        edad = args.edad
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mensaje = view.findViewById<TextView>(R.id.txt_segundo_fragment_mensaje)
        mensaje.text = "$nombre, $edad"

        val button = view.findViewById<Button>(R.id.btn_segundo_fragment_navegar)
        button.setOnClickListener {
            findNavController().navigate(Uri.parse("cursoandroid://producto"))
        }
    }



}