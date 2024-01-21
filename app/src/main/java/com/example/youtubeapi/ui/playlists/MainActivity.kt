package com.example.youtubeapi.ui.playlists


import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi.data.model.Item
import com.example.youtubeapi.data.service.Resource
import com.example.youtubeapi.databinding.ActivityMainBinding
import com.example.youtubeapi.ui.base.BaseActivity
import com.example.youtubeapi.ui.playlistitems.PlaylistItemsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PlaylistsViewModel by viewModel()
    private val playlistsAdapter by lazy { PlaylistsAdapter(this::onClickItem) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpCharactersRecycler()

        viewModel.getPlaylists().stateHandler(
            success = {
                playlistsAdapter.submitList(it)
                binding.recyclerView.adapter = playlistsAdapter
            },
            state = { state ->
                binding.progressBar.isVisible = state is Resource.Loading
            }
        )
    }

    private fun setUpCharactersRecycler() = with(binding.recyclerView) {
        adapter = playlistsAdapter
        layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            true
        )
    }

    private fun onClickItem(item: Item) {
        val intent = Intent(this, PlaylistItemsActivity::class.java)
        intent.putExtra(PlaylistItemsActivity.PLAYLIST_ID_ARG, item.id)
        intent.putExtra("count", item.contentDetails.itemCount)
        startActivity(intent)
    }
}