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

        if(binding.editMonto.text.toString().isEmpty()){
            mostrarNotificacion("Debe ingresar un monto válido")
            return
        }
        val saldoARetirar = binding.editMonto.text.toString().toInt()

        if(saldoARetirar > saldo){
            mostrarNotificacion("Error. El monto a retirar es mayor al saldo")
            limpiarEditText()
        } else {
            saldo -= saldoARetirar
            mostrarNotificacion("Saldo retirado $ $saldoARetirar")
            limpiarEditText()
        }

    }

    private fun ingresarSaldo() {

        if(binding.editMonto.text.isEmpty()){
            mostrarNotificacion("Debe ingresar un monto válido")
            return
        }

        val saldoAIngresar = binding.editMonto.text.toString().toInt()
        saldo += saldoAIngresar
        mostrarNotificacion("Saldo ingresado $ $saldo")
        limpiarEditText()
    }

    private fun mostrarSaldo() {
        binding.editMonto.setText(saldo.toString())
        mostrarNotificacion("Ver saldo realizado exitosamente")
    }

    private fun limpiarEditText() {
        binding.editMonto.text.clear()
    }

    private fun mostrarNotificacion(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }

}