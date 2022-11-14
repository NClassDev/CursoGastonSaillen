package com.example.cursogastonsaillen

fun main() {

    val persona: Persona = Persona("Gaston", "Saillen")
    val persona2 = Persona()
    persona2.nombre = "Carmen"
    persona2.apellido = "Gonzales"
    persona2.darBienvenida()

    // Data Class
    val dolly: Perro = Perro("Dolly", "Chihuahua")
    val cony: Perro = Perro("Cony", "San Bernardo")
    val milanezo: Perro = cony.copy(nombre = "Milaneso")
    val milanezoHermano: Perro = milanezo.copy()

    println("Son iguales: ${dolly == cony}")
    println("Son iguales: ${milanezo == cony}")
    println("Son iguales: ${milanezo == milanezoHermano}")

    // Constantes
    println(Constantes.direccion)

    //Enum Classes
    val dia = DIAS.JUEVES.numero
    println(dia)

    //Metodos
    println(esPar(2))

    //IF ELSE
    val a = 3
    val b = 2

    val max = if (a > b) a else b

    if (a < b) {
        println("a es menor que b")
    } else {
        println("a es mayor que b")
    }

    println("$max")


    // Listas
    var listaDeColores = mutableListOf("Azul", "Verdes", "Negro")  //Lista Mutable
    var listInmutable = listOf<String>("Auto", "Moto", "Bicicleta") // ListaInMutable

    for (nombre in listaDeColores) {
        println(nombre)
    }

    //Lista con indice
    for ((index, value) in listaDeColores.withIndex()) {
        println("Nombre: $value con indice: $index")
    }

    listInmutable.forEach { elemento ->
        println(elemento)
    }

    listInmutable.forEachIndexed() { index, elemento ->
        println("Elemento: $elemento con indice: $index")
    }

    val x = 4
    when (x) {
        1 -> {
            println("X es 1")
        }
        2 -> {
            println("X es 2")
        }
        else ->  println("X es diferente a 1 y 2")
    }

}

class Persona(var nombre: String = "", var apellido: String = "") {
    fun darBienvenida() {
        println("Bienvenido $nombre, $apellido")
    }
}

data class Perro(var nombre: String, var raza: String)

class Constantes {
    companion object {
        const val direccion = "Calle Independencia #35, Colonia Montañas"
    }
}

enum class DIAS(val numero: Int) {
    LUNES(0),
    MARTES(1),
    MIERCOLES(2),
    JUEVES(3),
    VIERNES(4),
    SABADO(5),
    DOMINGO(6)
}

fun esPar(numero: Int): Boolean {
    return numero % 2 == 0
}

