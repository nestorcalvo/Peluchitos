package com.nestorcalvo.peluchitos


interface comunicador {
    fun enviarDatos(ID:String, nombre:String, cantidad:String, precio:String)
    fun guardarDatos(ID:String, nombre:String, cantidad:Int, precio:Int)
}