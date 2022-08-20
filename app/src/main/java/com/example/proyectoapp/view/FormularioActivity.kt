package com.example.proyectoapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.proyectoapp.R
import com.example.proyectoapp.config.Constantes
import com.example.proyectoapp.databinding.ActivityFormularioBinding
import com.example.proyectoapp.viewmodels.FormularioViewModel

class FormularioActivity : AppCompatActivity(), BorrarListener {

    lateinit var binding:ActivityFormularioBinding
    lateinit var viewModel: FormularioViewModel
    lateinit var dialogoBorrar:BorrarDialogo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dialogoBorrar = BorrarDialogo(this)
        viewModel = ViewModelProvider(this).get()
        viewModel.operacion = intent.getStringExtra(Constantes.OPERACION_KEY)!!
        binding.modelo = viewModel
        binding.lifecycleOwner = this

        viewModel.operacionExitosa.observe(this, Observer {
            if(it){
                mostrarMensaje("Operacion Exitosa")
                irInicio()
            }else{
                mostrarMensaje("Ocurrio un error")
            }
        })
        if (viewModel.operacion.equals(Constantes.OPERACION_EDITAR)){
            viewModel.id.value = intent.getLongExtra(Constantes.ID_PERSONAL_KEY,0)
            viewModel.cargarDatos()
            binding.LEditar.visibility = View.VISIBLE
            binding.btnGuardar.visibility = View.GONE

        }else{
            binding.LEditar.visibility = View.GONE
            binding.btnGuardar.visibility = View.VISIBLE
        }
        binding.btnBorrar.setOnClickListener {
            mostrarDialogo()
        }
    }

    private fun mostrarDialogo() {
        dialogoBorrar.show(supportFragmentManager, "dialogo borrar")
    }

    private fun mostrarMensaje(s: String) {
        Toast.makeText(applicationContext,s,Toast.LENGTH_LONG).show()
    }
    private fun irInicio() {
        val intent = Intent(applicationContext,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    override fun borrarPersona() {
        viewModel.eliminarPersonal()
    }
}