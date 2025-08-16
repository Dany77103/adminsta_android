package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botones
        val btnPerfil = findViewById<Button>(R.id.btnPerfil)
        val btnInstitutos = findViewById<Button>(R.id.btnInstitutos)
        val btnCursos = findViewById<Button>(R.id.btnCursos)
        val btnGrupos = findViewById<Button>(R.id.btnGrupos)
        val btnMaterias = findViewById<Button>(R.id.btnMaterias)
        val btnHorario = findViewById<Button>(R.id.btnHorario)
        val btnAlta = findViewById<Button>(R.id.btnAlta)

        // Navegación a cada pantalla
        btnPerfil.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }

        btnInstitutos.setOnClickListener {
            startActivity(Intent(this, InstitutoActivity::class.java))
        }

        btnCursos.setOnClickListener {
            startActivity(Intent(this, CursosActivity::class.java))
        }

        btnGrupos.setOnClickListener {
            startActivity(Intent(this, GrupoActivity::class.java))
        }

        btnMaterias.setOnClickListener {
            startActivity(Intent(this, MateriasActivity::class.java))
        }

        btnHorario.setOnClickListener {
            startActivity(Intent(this, HorariosActivity::class.java))
        }

        btnAlta.setOnClickListener {
            startActivity(Intent(this, AltaUsuarioActivity::class.java))
        }
    }
}
