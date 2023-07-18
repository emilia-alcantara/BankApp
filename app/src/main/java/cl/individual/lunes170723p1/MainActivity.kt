package cl.individual.lunes170723p1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.individual.lunes170723p1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
/*1.- Agregar un título de bienvenida.
2.- Ver saldo.
3.- Ingresar dinero.
4.- Sacar dinero, Al intentar retirar dinero, Si el saldo a girar, es mayor al existente, no se
debe permitir realizar la operación
5.- Salir (Cerrar la Aplicación).*/


    }

    private fun initListeners() {
        binding.btnOk.setOnClickListener{
            when (binding.rgOpciones.checkedRadioButtonId) {
                binding.rbSaldo.id -> mostrarSaldo()
                binding.rbIngresar.id -> ingresarSaldo()
                binding.rbRetirar.id -> retirarSaldo()
                binding.rbSalir.id -> finish()
            }
        }
    }

    private fun retirarSaldo() {
        var saldoRetirado = binding.editMonto.text.toString().toInt()
        saldo -= saldoRetirado
        Toast.makeText(this, "Saldo retirado $ $saldoRetirado", Toast.LENGTH_LONG).show()
        binding.editMonto.setText("")
    }

    private fun ingresarSaldo() {
        saldo += binding.editMonto.text.toString().toInt()
        Toast.makeText(this, "Saldo ingresado $ $saldo", Toast.LENGTH_LONG).show()
        binding.editMonto.setText("")
    }

    private fun mostrarSaldo() {
        binding.editMonto.setText(saldo.toString())
        Toast.makeText(this, "Ver saldo realizado exitosamente", Toast.LENGTH_LONG).show()
    }


}