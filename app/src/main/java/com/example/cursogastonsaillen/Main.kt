package com.example.cursogastonsaillen

fun main() {

    val persona: Persona = Persona("Gaston", "Saillen")
    val persona2 = Persona()
    persona2.nombre = "Carmen"
    persona2.apellido = "Gonzales"
    persona2.darBienvenida()

    val dolly: Perro = Perro("Dolly", "Chihuahua")
    val cony: Perro = Perro("Cony", "San Bernardo")
    val milanezo: Perro = cony.copy(nombre = "Milaneso")
    val milanezoHermano: Perro = milanezo.copy()

    println("Son iguales: ${dolly == cony}")
    println("Son iguales: ${milanezo == cony}")
    println("Son iguales: ${milanezo == milanezoHermano}")

}

class Persona(var nombre: String ="", var apellido: String = "") {
    fun darBienvenida() {
        println("Bienvenido $nombre, $apellido")
    }
}

data class Perro(var nombre: String, var raza: String)