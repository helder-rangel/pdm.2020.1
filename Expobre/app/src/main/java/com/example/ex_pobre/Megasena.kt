package com.example.ex_pobre

import java.util.*
object Megasena {

    fun getInstance(): Set<Int>{
        val random = Random()
        var numeros = mutableSetOf<Int>()

        while(numeros.size < 6){
            numeros.add(random.nextInt(60) + 1)
        }
        return numeros
    }
}