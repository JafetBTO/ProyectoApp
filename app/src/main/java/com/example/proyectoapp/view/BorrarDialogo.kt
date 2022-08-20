package com.example.proyectoapp.view


import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.proyectoapp.R

class BorrarDialogo (var borrarListener: BorrarListener): DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.borrar_persona)
                .setPositiveButton(R.string.si,
                    DialogInterface.OnClickListener { dialog, id ->
                        borrarListener.borrarPersona()
                    })
                .setNegativeButton(R.string.cancelar,
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
interface  BorrarListener{
    fun borrarPersona()
}