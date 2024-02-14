package mx.edu.potros.examen1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etC: EditText
    private lateinit var etF: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etC = findViewById(R.id.etC)
        etF = findViewById(R.id.etF)

        val btnGC: Button = findViewById(R.id.btnGC)
        val btnGF: Button = findViewById(R.id.btnGF)

        btnGC.setOnClickListener {
            convertirACelsius()
        }

        btnGF.setOnClickListener {
            convertirAFahrenheit()
        }
    }

    private fun convertirACelsius() {
        try {
            val fahrenheit = etF.text.toString().toDouble()
            val celsius = (fahrenheit - 32) / 1.8
            etC.setText(String.format("%.2f", celsius))
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese un valor válido en °F", Toast.LENGTH_SHORT).show()
        }
    }

    private fun convertirAFahrenheit() {
        try {
            val celsius = etC.text.toString().toDouble()
            val fahrenheit = (celsius * 1.8) + 32
            etF.setText(String.format("%.2f", fahrenheit))
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese un valor válido en °C", Toast.LENGTH_SHORT).show()
        }
    }
}
