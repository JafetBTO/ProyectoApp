package com.example.proyectoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.proyectoapp.R
import com.example.proyectoapp.databinding.ActivityMainBinding
import com.example.proyectoapp.databinding.ActivityPokedexBinding

class Pokedex : AppCompatActivity() {

    lateinit var binding: ActivityPokedexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pokedex)
        setContentView(binding.root)
    }
}