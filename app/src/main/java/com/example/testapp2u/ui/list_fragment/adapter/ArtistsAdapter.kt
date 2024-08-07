package com.example.testapp2u.ui.list_fragment.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testapp2u.R
import com.example.testapp2u.data.domain.models.artist.ArtistModel
import com.example.testapp2u.databinding.ItemListArtistBinding

class ArtistsAdapter(
    private val context: Context,
    private val listener: ItemArtistListener,
    private var artists: List<ArtistModel>
) : RecyclerView.Adapter<ArtistsAdapter.ViewHolder>() {

    interface ItemArtistListener {
        fun onClick(idArtist: Int)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mBinding = ItemListArtistBinding.bind(view)
        fun setListener(idArtist: Int) {
            mBinding.root.setOnClickListener {
                listener.onClick(idArtist)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_artist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.mBinding) {
            tvNameArtist.text = context.getString(
                R.string.artistFullName,
                artists[position].firstName,
                artists[position].lastName
            )

            Glide.with(context)
                .load(artists[position].image)
                .apply(RequestOptions().centerCrop())
                .error(R.drawable.artist_placeholder)
                .into(imgPhotoArtist)
        }
        holder.setListener(artists[position].id)
    }

    override fun getItemCount() = artists.count()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(newArtistsList: List<ArtistModel>) {
        artists = newArtistsList
        notifyDataSetChanged()
    }
}