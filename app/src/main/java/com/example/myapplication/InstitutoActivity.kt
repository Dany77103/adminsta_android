package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InstitutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instituto)

        val tvResumen = findViewById<TextView>(R.id.tvResumen)

        val shared = getSharedPreferences("AppData", Context.MODE_PRIVATE)

        // Recuperar todos los datos guardados
        val instituto = shared.getString("instituto", "No definido")
        val grupo = shared.getString("grupo", "No definido")
        val curso = shared.getString("curso", "No definido")
        val materia = shared.getString("materia", "No definido")
        val horario = shared.getString("horario", "No definido")

        // Crear el texto del resumen
        val resumen = """
            📘 Resumen de Datos
            
            Instituto: $instituto
            Grupo: $grupo
            Curso: $curso
            Materia: $materia
            Horario: $horario
        """.trimIndent()

        // Mostrar en el TextView
        tvResumen.text = resumen
    }
}
