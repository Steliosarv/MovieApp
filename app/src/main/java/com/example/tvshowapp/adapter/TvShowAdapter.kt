package com.example.tvshowapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tvshowapp.databinding.ActivityMainBinding
import com.example.tvshowapp.databinding.TvShowLayoutAdapterBinding
import com.example.tvshowapp.helper.MyApplication
import com.example.tvshowapp.models.TvShowItem

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.MyViewHolder> () {

    inner class MyViewHolder(val binding: TvShowLayoutAdapterBinding):
        RecyclerView.ViewHolder(binding.root)

    private val diffcalBack = object: DiffUtil.ItemCallback<TvShowItem>(){
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
                    return oldItem.id == newItem.id
            }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
                    return  oldItem==newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffcalBack)

    var tvShows: List<TvShowItem> get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TvShowLayoutAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun getItemCount() = tvShows.size



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.binding.apply {
            textView.text = currentTvShow.name
            imageView.load(currentTvShow.image.original){
                crossfade(true)
                crossfade(1000)
            }
        }

    }
}