package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.text
// import androidx.compose.ui.semantics.error // ELIMINAR ESTA LÍNEA
// import androidx.compose.ui.semantics.text // ELIMINAR ESTA LÍNEA

// CAMBIA ESTA IMPORTACIÓN para que coincida con tu applicationId
// Si tu applicationId es "com.example.myapplication", entonces debería ser:
import com.example.myapplication.databinding.ActivityPerfilBinding
// Si es diferente, ajústala. Ejemplo: import com.tuempresa.tuapp.databinding.ActivityPerfilBinding

import kotlin.text.isNullOrEmpty // Esta está bien
import kotlin.text.trim // Esta está bien

class PerfilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding // Esto ahora debería funcionar si la importación anterior es correcta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater) // Esto ahora debería funcionar
        setContentView(binding.root)

        cargarDatosPerfil()
        configurarListeners()
    }

    private fun cargarDatosPerfil() {
        if (binding.etNombre.text.isNullOrEmpty()) {
            // binding.etNombre.hint = "Nombre de Usuario"
        }
    }

    private fun configurarListeners() {
        binding.btnGuardarCambios.setOnClickListener {
            guardarCambiosPerfil()
        }

        binding.imgFotoPerfil.setOnClickListener {
            Toast.makeText(this, "Seleccionar nueva foto de perfil", Toast.LENGTH_SHORT).show()
        }
    }

    private fun guardarCambiosPerfil() {
        val nombre = binding.etNombre.text.toString().trim()
        val telefono = binding.etTelefono.text.toString().trim()
        val correo = binding.etCorreo.text.toString().trim()

        if (!validarCampos(nombre, telefono, correo)) {
            return
        }

        val sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("nombre", nombre)
            putString("telefono", telefono)
            putString("correo", correo)
            apply()
        }

        Toast.makeText(this, "Cambios guardados exitosamente", Toast.LENGTH_SHORT).show()
    }

    private fun validarCampos(nombre: String, telefono: String, correo: String): Boolean {
        var esValido = true

        if (nombre.isEmpty()) {
            binding.tilNombre.error = "El nombre no puede estar vacío"
            esValido = false
        } else {
            binding.tilNombre.error = null
        }

        if (telefono.isEmpty()) {
            binding.tilTelefono.error = "El teléfono no puede estar vacío"
            esValido = false
        } else if (!android.util.Patterns.PHONE.matcher(telefono).matches()) {
            binding.tilTelefono.error = "Formato de teléfono no válido"
            esValido = false
        } else {
            binding.tilTelefono.error = null
        }

        if (correo.isEmpty()) {
            binding.tilCorreo.error = "El correo no puede estar vacío"
            esValido = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            binding.tilCorreo.error = "Formato de correo no válido"
            esValido = false
        } else {
            binding.tilCorreo.error = null
        }

        return esValido
    }
}
