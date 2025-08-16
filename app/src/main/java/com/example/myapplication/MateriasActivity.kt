package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MateriasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materias)

        val etNombreMateria = findViewById<EditText>(R.id.etNombreMateria)
        val btnAgregarMateria = findViewById<Button>(R.id.btnAgregarMateria)
        val btnEnviarAInstituto = findViewById<Button>(R.id.btnEnviarAInstituto)

        val shared = getSharedPreferences("AppData", Context.MODE_PRIVATE)

        btnAgregarMateria.setOnClickListener {
            val materia = etNombreMateria.text.toString().trim()
            if (materia.isEmpty()) {
                Toast.makeText(this, "Ingresa un nombre de materia", Toast.LENGTH_SHORT).show()
            } else {
                // Guardamos Materia para usarla en otras pantallas (Instituto, Grupo, Horario, etc.)
                shared.edit().putString("materia", materia).apply()
                Toast.makeText(this, "Materia guardada: $materia", Toast.LENGTH_LONG).show()
                etNombreMateria.text.clear()
            }
        }

        btnEnviarAInstituto.setOnClickListener {
            // Navegación a Instituto para que puedas ver/combinar los datos ahí
            val intent = Intent(this, InstitutoActivity::class.java)
            startActivity(intent)
        }
    }
}
