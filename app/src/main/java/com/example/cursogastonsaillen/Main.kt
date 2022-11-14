package com.example.cursogastonsaillen

fun main() {

    val persona: Persona = Persona("Gaston", "Saillen")
    persona.darBienvenida()
}

class Persona(val nombre: String, val apellido: String) {
    fun darBienvenida() {
        println("Bienvenido $nombre, $apellido")
    }
}

