package com.example.cursogastonsaillen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_primer_fragment_navegar)
        button.setOnClickListener {
            val action = PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment("Ana", 25)
            findNavController().navigate(action)
        }
    }

}