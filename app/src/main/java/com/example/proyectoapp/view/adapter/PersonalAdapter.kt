package com.example.proyectoapp.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoapp.R
import com.example.proyectoapp.config.Constantes
import com.example.proyectoapp.databinding.ItemListBinding
import com.example.proyectoapp.model.Personal
import com.example.proyectoapp.view.FormularioActivity


class PersonalAdapter(private val dataSet: List<Personal>?) :
    RecyclerView.Adapter<PersonalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet?.get(position)
        viewHolder.enlazarItem(item!!)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet!!.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemListBinding.bind(view)
        var contexto = view.context

        fun enlazarItem(p: Personal) {
            binding.tvName.text = "${p.nombre} ${p.apellido}"
            binding.tvTelefono.text = p.email
            binding.tvEmail.text = p.telefono
            binding.tvEdad.text = p.edad.toString()

            binding.root.setOnClickListener {
                val intent = Intent(contexto,FormularioActivity::class.java)
                intent.putExtra(Constantes.OPERACION_KEY, Constantes.OPERACION_EDITAR)
                intent.putExtra(Constantes.ID_PERSONAL_KEY,p.idEmpleado)
                contexto.startActivity(intent)
            }
        }

    }
}