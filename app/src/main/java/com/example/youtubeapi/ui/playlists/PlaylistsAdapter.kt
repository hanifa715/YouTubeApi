package com.example.youtubeapi.ui.playlists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.youtubeapi.data.model.Item
import com.example.youtubeapi.databinding.ItemPlaylistBinding
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PlaylistsAdapter(private val onClick: (Item) -> Unit) :
    ListAdapter<Item, PlaylistsViewHolder>(
        YouTubeDiffCallback()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlaylistsViewHolder (
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClick
        )

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PlaylistsViewHolder(
    private val binding: ItemPlaylistBinding,
    private val onClick: (Item) -> Unit
) : ViewHolder(binding.root) {
    fun bind(item: Item) = with(binding) {
        playlistName.text = item.snippet.title
        tvCount.text = item.contentDetails.itemCount.toString().plus(" video series")
        itemView.setOnClickListener { onClick.invoke(item) }
        Glide.with(image).load(item.snippet.thumbnails.default.url).into(image)
    }

}

class YouTubeDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
}