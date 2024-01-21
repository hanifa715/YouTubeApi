package com.example.youtubeapi.ui.playlistitems

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.youtubeapi.data.service.Resource
import com.example.youtubeapi.databinding.ActivityPlaylistItemsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistItemsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaylistItemsBinding
    private val viewModel: PlaylistItemsViewModel by viewModel()
    private val playlistItemsAdapter = PlaylistItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaylistItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPlaylistItems.adapter = playlistItemsAdapter

        val getId = intent.getStringExtra(PLAYLIST_ID_ARG).toString()
        val count:Int = intent.getIntExtra("count", 0)
        viewModel.getPlaylistItems(getId, count).observe(this) { result ->
            when (result) {
                is Resource.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    playlistItemsAdapter.submitList(result.data)
                }
            }
        }
    }

    companion object{
        const val PLAYLIST_ID_ARG = "playlist_id_arg"
    }
}