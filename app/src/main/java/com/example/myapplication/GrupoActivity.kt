package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GrupoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grupo)

        val etNombreGrupo = findViewById<EditText>(R.id.etNombreGrupo)
        val btnAgregarGrupo = findViewById<Button>(R.id.btnAgregarGrupo)

        val sharedPrefs = getSharedPreferences("AppData", Context.MODE_PRIVATE)

        btnAgregarGrupo.setOnClickListener {
            val nombreGrupo = etNombreGrupo.text.toString().trim()

            if (nombreGrupo.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese un nombre de grupo", Toast.LENGTH_SHORT).show()
            } else {
                // Guardamos el grupo en SharedPreferences
                sharedPrefs.edit().putString("grupo", nombreGrupo).apply()

                Toast.makeText(this, "Grupo guardado: $nombreGrupo", Toast.LENGTH_LONG).show()

                etNombreGrupo.text.clear()
            }
        }
    }
}
