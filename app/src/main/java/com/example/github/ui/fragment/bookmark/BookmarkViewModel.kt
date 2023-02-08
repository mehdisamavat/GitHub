package com.example.github.ui.fragment.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.domain.model.GitRepo
import com.example.domain.usecase.GetAllLocalRepoUseCase
import com.example.domain.usecase.UpdateLocalBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    getAllLocalRepoUseCase: GetAllLocalRepoUseCase,
    private val updateLocalBookmarkUseCase: UpdateLocalBookmarkUseCase ) : ViewModel() {

    val bookMarkRepo: LiveData<List<GitRepo?>> = getAllLocalRepoUseCase().map { it.filter { item -> item?.isBookmark ?: false } }.asLiveData()
    fun updateBookmark(id:Int, isBookmark:Boolean) {
            updateLocalBookmarkUseCase.invoke(id,isBookmark)
    }
}