package com.alph.favorites.presentation.favorite_film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alph.core.data.local.entity.FilmEntity
import com.alph.core.domain.dto.FilmDto
import com.alph.favorites.databinding.ItemRowFilmBinding

class FavoriteFilmAdapter: RecyclerView.Adapter<FavoriteFilmAdapter.ListViewHolder>() {

    private val list = ArrayList<FilmDto>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(films: ArrayList<FilmDto>) {
        list.clear()
        list.addAll(films)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val binding: ItemRowFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: FilmDto) {

            binding.root.setOnClickListener{
                onItemClickCallback?.onItemClicked(film)
            }

            binding.apply {
                tvTitle.text = film.title
                tvYear.text = film.releaseDate
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = ItemRowFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback{
        fun onItemClicked(data: FilmDto)
    }

}