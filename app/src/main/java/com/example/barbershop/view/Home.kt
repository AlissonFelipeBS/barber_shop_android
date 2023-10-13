package com.example.barbershop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barbershop.R
import com.example.barbershop.adapter.ServicosAdapter
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicoAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.textNomeUsuario.text = "Bem-vindo, $nome"
        val recyclerViewServicos = binding.recyclerViewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicoAdapter = ServicosAdapter(this, listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicoAdapter
        getServicos()

        binding.btAgendar.setOnClickListener {
            val intent = Intent(this, Agendamento::class.java)
            intent.putExtra("nome", nome)
            startActivity(intent)
        }
    }

    private fun getServicos(){

        val servico1 = Servicos(R.drawable.img1, "Corte de cabelo")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.img2, "Corte de barba")
        listaServicos.add(servico2)

        val servico3 = Servicos(R.drawable.img3, "Lavagem de cabelo")
        listaServicos.add(servico3)

        val servico4 = Servicos(R.drawable.img4, "Tratamento de cabelo")
        listaServicos.add(servico4)

    }

}