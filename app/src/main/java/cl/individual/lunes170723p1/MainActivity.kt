package cl.individual.lunes170723p1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.individual.lunes170723p1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}