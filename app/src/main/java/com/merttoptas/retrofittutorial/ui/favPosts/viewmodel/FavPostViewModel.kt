package com.merttoptas.retrofittutorial.ui.favPosts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merttoptas.retrofittutorial.data.local.database.entity.PostEntity
import com.merttoptas.retrofittutorial.data.model.DataState
import com.merttoptas.retrofittutorial.data.model.Post
import com.merttoptas.retrofittutorial.data.model.PostDTO
import com.merttoptas.retrofittutorial.data.repository.FavPostRepository
import com.merttoptas.retrofittutorial.data.repository.PostRepository
import com.merttoptas.retrofittutorial.ui.posts.viewmodel.PostViewEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class FavPostViewModel @Inject constructor(private val favPostRepository: FavPostRepository) :ViewModel(){

    private var _FavpostLiveData = MutableLiveData<List<PostDTO>?>()
    val postLiveData: LiveData<List<PostDTO>?>
        get() = _FavpostLiveData

    private val _eventStateLiveData = MutableLiveData<FavPostViewEvent>()
    val eventStateLiveData: LiveData<FavPostViewEvent>
        get() = _eventStateLiveData


     fun getPosts() {
        _FavpostLiveData.postValue(favPostRepository.getFavPosts().map {safePost ->
            PostDTO(
                id = safePost.id?.toLong(),
                title = safePost.postTitle,
                body = safePost.postBody,
                userId = null,
            )
        })
    }
}

sealed class FavPostViewEvent {
    object NavigateToDetail : FavPostViewEvent()
    class ShowMessage(val message: String?) : FavPostViewEvent()
}