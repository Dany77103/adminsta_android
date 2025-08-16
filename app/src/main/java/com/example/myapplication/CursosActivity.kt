package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CursosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        // Referencias a los elementos de la vista
        val etNombreCurso = findViewById<EditText>(R.id.etNombreCurso)
        val btnAgregarCurso = findViewById<Button>(R.id.btnAgregarCurso)

        // Acción del botón
        btnAgregarCurso.setOnClickListener {
            val nombreCurso = etNombreCurso.text.toString().trim()

            if (nombreCurso.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese un nombre de curso", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí podrías guardar el curso en la base de datos más adelante
                Toast.makeText(this, "Curso agregado: $nombreCurso", Toast.LENGTH_LONG).show()

                // Limpiar campo después de agregar
                etNombreCurso.text.clear()
            }
        }
    }
}
