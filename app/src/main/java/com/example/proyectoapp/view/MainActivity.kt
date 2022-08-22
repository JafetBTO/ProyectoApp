package com.example.proyectoapp.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoapp.data.local.dao.config.Constantes
import com.example.proyectoapp.databinding.ActivityMainBinding
import com.example.proyectoapp.view.adapter.PersonalAdapter
import com.example.proyectoapp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO
        viewModel = ViewModelProvider(this).get()
        viewModel.iniciar()

        binding.lifecycleOwner = this
        binding.modelo = viewModel

        binding.Recycler.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }

        viewModel.personalList.observe(this, Observer {
            binding.Recycler.adapter = PersonalAdapter(it)
        })

        binding.ftAgregar.setOnClickListener {
            val intent = Intent(this,FormularioActivity::class.java)
            intent.putExtra(Constantes.OPERACION_KEY,Constantes.OPERACION_INSERTAR)
            startActivity(intent)
        }

        binding.etBuscar.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p: Editable?) {
                if(p.toString().isNotEmpty()){
                    viewModel.buscarPersonal()
                }
            }

        })
    }
}