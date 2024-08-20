package com.pandora.gamedatabases.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pandora.gamedatabases.core.databinding.ItemsLayoutBinding
import com.pandora.gamedatabases.core.domain.model.Game

class GameAdapter(private val onGameClick: (Game) -> Unit) : ListAdapter<Game, GameAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(private val binding: ItemsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            Glide.with(binding.root)
                .load(game.backgroundImage)
                .into(binding.ivPoster)
            binding.tvTitle.text = game.name

            binding.root.setOnClickListener {
                onGameClick(game)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = getItem(position)
        holder.bind(game)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Game>(){
            override fun areItemsTheSame(
                oldItem: Game,
                newItem: Game
            ): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: Game,
                newItem: Game
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}