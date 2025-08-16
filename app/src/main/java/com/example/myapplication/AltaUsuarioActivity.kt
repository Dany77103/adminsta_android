package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AltaUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta_usuario)

        val etNombre = findViewById<EditText>(R.id.etNombreUsuario)
        val etCorreo = findViewById<EditText>(R.id.etCorreoUsuario)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarUsuario)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val correo = etCorreo.text.toString()

            if (nombre.isNotEmpty() && correo.isNotEmpty()) {
                Toast.makeText(this, "Usuario guardado:\n$nombre - $correo", Toast.LENGTH_LONG).show()
                etNombre.text.clear()
                etCorreo.text.clear()
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
