package com.example.github.ui.fragment.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.domain.model.GitRepo
import com.example.domain.usecase.UpdateLocalBookmarkUseCase
import com.example.domain.usecase.GetAllLocalRepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    getAllLocalRepoUseCase: GetAllLocalRepoUseCase,
    private val updateLocalBookmarkUseCase: UpdateLocalBookmarkUseCase ) : ViewModel() {

    val bookMarkRepo: LiveData<List<GitRepo?>> = getAllLocalRepoUseCase().asLiveData()
    fun updateBookmark(id:Int, isBookmark:Boolean) {
            updateLocalBookmarkUseCase.invoke(id,isBookmark)
    }
}