package com.example.thesimpsonsquoteapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thesimpsonsquoteapp.R
import com.example.thesimpsonsquoteapp.databinding.ActivityMainBinding
import com.example.thesimpsonsquoteapp.viewmodels.MainViewModel
import com.example.thesimpsonsquoteapp.views.adapters.CharacterAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setUpRecyclerView()
        viewModel.getCharacters()

        viewModel.charactersList.observe(this) {
            adapter.charactersList = it
            adapter.notifyDataSetChanged()
        }

        binding.tilSearch.setEndIconOnClickListener {
            if (binding.tieSearch.text.toString() == "") {
                viewModel.getCharacters()
            } else {
                viewModel.getCharacter(binding.tieSearch.text.toString().trim())
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.rvCharacters.layoutManager = GridLayoutManager(this, 3)
        adapter = CharacterAdapter(this, arrayListOf())
        binding.rvCharacters.adapter = adapter
    }
}