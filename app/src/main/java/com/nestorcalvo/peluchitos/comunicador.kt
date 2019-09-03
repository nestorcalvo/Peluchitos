package com.nestorcalvo.peluchitos


interface comunicador {
    fun guardarDatos(ID:String, nombre:String, cantidad:Int, precio:Int)
    fun removerDatos(index:Int)
}