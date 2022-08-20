package com.example.proyectoapp.viewmodels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoapp.config.Constantes
import com.example.proyectoapp.config.PersonalApp.Companion.db
import com.example.proyectoapp.model.Personal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FormularioViewModel:ViewModel() {


    var id = MutableLiveData<Long>()
    var nombre = MutableLiveData<String>()
    var apellido = MutableLiveData<String>()
    var telefono = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var edad = MutableLiveData<Int>()
    var operacion:String = Constantes.OPERACION_INSERTAR
    var operacionExitosa = MutableLiveData<Boolean>()

    init {
        edad.value=18
    }
    fun guardarUser(){
        if (validarInformacion()){
            var nPersonal = Personal(0,nombre.value!!,apellido.value!!,
                telefono.value!!,email.value!!,edad.value!!)

            when(operacion){
                Constantes.OPERACION_INSERTAR->{
                    viewModelScope.launch {
                        val result = withContext(Dispatchers.IO){
                            db.personalDao().insert(arrayListOf<Personal>(nPersonal))
                        }
                        operacionExitosa.value = result.isNotEmpty()

                    }
                }
                Constantes.OPERACION_EDITAR->{
                    nPersonal.idEmpleado = id.value!!
                    viewModelScope.launch {
                        val result = withContext(Dispatchers.IO){
                            db.personalDao().update(nPersonal)
                        }
                        operacionExitosa.value = (result>0)
                    }
                }
            }
        }else{
            operacionExitosa.value =false
        }

    }

    fun cargarDatos() {
        viewModelScope.launch {
            var persona = withContext(Dispatchers.IO){
                db.personalDao().getById(id.value!!)
            }
            nombre.value = persona.nombre
            apellido.value = persona.apellido
            telefono.value = persona.telefono
            email.value = persona.email
            edad.value = persona.edad
        }
    }

    private fun validarInformacion():Boolean{
        return !(nombre.value.isNullOrBlank() ||
                apellido.value.isNullOrBlank() ||
                telefono.value.isNullOrBlank() ||
                email.value.isNullOrBlank() ||
                edad.value!! <= 0 || edad.value!! >=100
                )
    }

    fun eliminarPersonal() {
        var nPersonal = Personal(id.value!!,"","","","",0)
        viewModelScope.launch {
            var result = withContext(Dispatchers.IO){
                db.personalDao().delete(nPersonal)
            }
            operacionExitosa.value = (result>0)
        }
    }
}