package com.example.cursogastonsaillen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf

class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private var nombre: String? = ""
    private var edad: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = requireArguments().getString(MI_NOMBRE)
        edad = requireArguments().getInt(MI_EDAD)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = view.findViewById<TextView>(R.id.txt_mensaje_segundo_fragment)
        text.text = "$nombre, $edad"
    }

    companion object {
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"

        fun newInstance(nombre: String, edad: Int) = SegundoFragment().apply {
            arguments = bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }

    }

}