package com.merttoptas.retrofittutorial.ui.favPosts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.merttoptas.retrofittutorial.data.model.DataState
import com.merttoptas.retrofittutorial.data.model.PostDTO
import com.merttoptas.retrofittutorial.databinding.FragmentFavPostBinding
import com.merttoptas.retrofittutorial.ui.favPosts.adapter.FavPostAdapter
import com.merttoptas.retrofittutorial.ui.favPosts.viewmodel.FavPostViewEvent
import com.merttoptas.retrofittutorial.ui.favPosts.viewmodel.FavPostViewModel
import com.merttoptas.retrofittutorial.ui.loadingprogress.LoadingProgressBar
import com.merttoptas.retrofittutorial.ui.posts.adapter.OnPostClickListener
import com.merttoptas.retrofittutorial.ui.posts.adapter.PostsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavPostFragment : Fragment(),OnPostClickListener {

    lateinit var loadingProgressBar: LoadingProgressBar
    private lateinit var binding: FragmentFavPostBinding
    private val viewModel by viewModels<FavPostViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingProgressBar = LoadingProgressBar(requireContext())

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.postLiveData.observe(viewLifecycleOwner) {
           it?.let {
               binding.rvFavPostList.adapter = FavPostAdapter(this@FavPostFragment).apply {
                   submitList(
                       it
                   )
               }
           }
        }

        viewModel.eventStateLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is FavPostViewEvent.ShowMessage -> {}
                is FavPostViewEvent.NavigateToDetail -> {}
            }
        }
    }

    override fun onPostClick(post: PostDTO) {

    }

    override fun onStart() {
        super.onStart()
        viewModel.getPosts()
    }
}


