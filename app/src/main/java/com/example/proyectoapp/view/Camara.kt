package com.example.proyectoapp.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.proyectoapp.R
import com.example.proyectoapp.databinding.ActivityCamaraBinding

class Camara : AppCompatActivity() {
    private lateinit var binding: ActivityCamaraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCamaraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }

    private fun setupListener() {
        binding.btnTakePhoto.setOnClickListener { startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }

    //Evento que procesa el resultado de la cámara y envía la vista previa de la foto al ImageView
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                val imageBitmap = intent?.extras?.get("data") as Bitmap
                binding.shapeableImageView.setImageBitmap(imageBitmap)
                //val imageView = findViewById<ImageView>(R.id.imageView)
                //imageView.setImageBitmap(imageBitmap)
            }
        }

    /*
    private fun setupListener() {
        binding.btnTakePhoto.setOnClickListener { dispatchTakePictureIntent() }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            data?.extras?.let { bundle ->
                val imageBitmap = bundle.get("data") as Bitmap
                binding.shapeableImageView.setImageBitmap(imageBitmap)
            }
        }
    }
     */
}


