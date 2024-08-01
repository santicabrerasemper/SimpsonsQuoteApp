package com.example.thesimpsonsquoteapp.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thesimpsonsquoteapp.R
import com.example.thesimpsonsquoteapp.models.SimpsonCharacter
import com.google.android.material.bottomsheet.BottomSheetDialog

class CharacterAdapter(
    private val context: Context,
    var charactersList: List<SimpsonCharacter>
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val characterCardView = item.findViewById(R.id.cv_character) as CardView
        val characterImage = item.findViewById(R.id.img_character) as ImageView
        val characterName = item.findViewById(R.id.tv_character_name) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = charactersList[position]
        Glide
            .with(context)
            .load(character.image)
            .centerInside()
            .into(holder.characterImage)

        holder.characterName.text = character.character

        holder.characterCardView.setOnClickListener {
            showQuote(character.quote)
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    private fun showQuote(quote: String) {
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_quote)

        val tvQuote = bottomSheetDialog.findViewById<TextView>(R.id.tv_quote)
        tvQuote!!.text = quote
        bottomSheetDialog.show()
    }

}