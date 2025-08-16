package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HorariosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios) // usa tu layout de horarios

        val etHorario = findViewById<EditText>(R.id.etHorario) // asegúrate que en tu XML exista este id
        val btnAgregarHorario = findViewById<Button>(R.id.btnAgregarHorario)
        val btnVerResumen = findViewById<Button>(R.id.btnVerResumen)

        val shared = getSharedPreferences("AppData", Context.MODE_PRIVATE)

        btnAgregarHorario.setOnClickListener {
            val horario = etHorario.text.toString().trim()
            if (horario.isEmpty()) {
                Toast.makeText(this, "Ingresa un horario válido", Toast.LENGTH_SHORT).show()
            } else {
                shared.edit().putString("horario", horario).apply()
                Toast.makeText(this, "Horario guardado: $horario", Toast.LENGTH_LONG).show()
                etHorario.text.clear()
            }
        }

        // Botón para ir a la pantalla de Resumen
        btnVerResumen.setOnClickListener {
            val intent = Intent(this, InstitutoActivity::class.java)
            startActivity(intent)
        }
    }
}
