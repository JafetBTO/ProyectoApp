package com.example.proyectoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectoapp.R
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Principal : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)


        val boton1=findViewById<Button>(R.id.btnagenda)
        boton1.setOnClickListener {
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }

        val boton2=findViewById<Button>(R.id.btnpokedex)
        boton2.setOnClickListener {
            val intent2 = Intent(this, Pokedex::class.java)
            startActivity(intent2)
        }

        val boton3=findViewById<Button>(R.id.btnmapa)
        boton3.setOnClickListener {
            val intent3 = Intent(this, Mapa::class.java)
            startActivity(intent3)
        }
        val boton4=findViewById<Button>(R.id.btnmapa2)
        boton4.setOnClickListener {
            val intent4 = Intent(this, Pokedex::class.java)
            startActivity(intent4)
        }
        val boton5=findViewById<Button>(R.id.btncamara)
        boton5.setOnClickListener {
            val intent5 = Intent(this, Pokedex::class.java)
            startActivity(intent5)
        }

        val drawer : DrawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view2)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)


        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            R.string.drawer_open,
            R.string.drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.salir -> {
                    //Toast.makeText(this, "Hola" , Toast.LENGTH_SHORT).show()

                    AlertDialog.Builder(this).apply {
                        setTitle("Aviso")
                        setMessage("¿Deseas salir de la aplicación?")
                        setPositiveButton("Si"){ _: DialogInterface, _:Int ->
                            aceptar()
                        }
                        setNegativeButton("No"){ _: DialogInterface, _:Int ->
                            drawer.closeDrawer(GravityCompat.START)
                        }


                    }.show()
                }

            }
            true
        }

    }



    fun aceptar() {
        finishAffinity()
    }

    private fun validateForm(){
        var isValid = true
        true
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}