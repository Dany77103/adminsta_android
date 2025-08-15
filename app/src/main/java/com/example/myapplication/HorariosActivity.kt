package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.compose.ui.semantics.text
import com.google.android.material.textfield.TextInputEditText

class HorariosActivity : AppCompatActivity() {

    private lateinit var editTextNombre: TextInputEditText
    private lateinit var editTextGrupo: TextInputEditText
    private lateinit var spinnerDia: Spinner
    private lateinit var editTextHora: TextInputEditText
    private lateinit var buttonAgregar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horarios) // Asegúrate que este sea el nombre de tu archivo XML

        editTextNombre = findViewById(R.id.editTextNombre)
        editTextGrupo = findViewById(R.id.editTextGrupo)
        spinnerDia = findViewById(R.id.spinnerDia)
        editTextHora = findViewById(R.id.editTextHora)
        buttonAgregar = findViewById(R.id.buttonAgregar)

        // Configurar el adaptador para el Spinner si no usaste android:entries
        // ArrayAdapter.createFromResource(
        //     this,
        //     R.array.dias_semana,
        //     android.R.layout.simple_spinner_item
        // ).also { adapter ->
        //     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //     spinnerDia.adapter = adapter
        // }

        buttonAgregar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val grupo = editTextGrupo.text.toString()
            val diaSeleccionado = spinnerDia.selectedItem.toString()
            val hora = editTextHora.text.toString()

            if (nombre.isNotEmpty() && grupo.isNotEmpty() && hora.isNotEmpty()) {
                // Aquí va la lógica para guardar los datos
                val mensaje = "Horario Agregado: \nNombre: $nombre\nGrupo: $grupo\nDía: $diaSeleccionado\nHora: $hora"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

                // Limpiar campos después de agregar (opcional)
                editTextNombre.text?.clear()
                editTextGrupo.text?.clear()
                editTextHora.text?.clear()
                spinnerDia.setSelection(0) // Resetear a la primera opción
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
    