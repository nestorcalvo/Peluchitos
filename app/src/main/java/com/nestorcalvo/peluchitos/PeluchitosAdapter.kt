package com.nestorcalvo.peluchitos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_inventory.view.*
import kotlinx.android.synthetic.main.peluchitos_items.view.*

class PeluchitosAdapter : RecyclerView.Adapter<PeluchitosAdapter.PeluchitosViewHolder> {


    private var listPeluchitos: List<PeluchesClass>? = null
    private var context: Context? = null

    constructor(listPeluchitos: List<PeluchesClass>, context: Context) {
        this.listPeluchitos = listPeluchitos
        this.context = context

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeluchitosViewHolder {
        //traer superheroe
        var view = LayoutInflater.from(context).inflate(R.layout.peluchitos_items, parent,false)
        return PeluchitosViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listPeluchitos?.size!!
    }

    override fun onBindViewHolder(holder: PeluchitosViewHolder, position: Int) {
        var peluchitos : PeluchesClass = listPeluchitos!![position]
        holder.loadItem(peluchitos)

    }

    //setea informacion
    class PeluchitosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun loadItem(peluchitos: PeluchesClass) {
            itemView.tvID.text = peluchitos.ID
            itemView.tvNombre.text = peluchitos.nombre
            itemView.tvCantidad.text = peluchitos.cantidad.toString()
            itemView.tvPrecio.text = peluchitos.precio.toString()
        }
    }

}