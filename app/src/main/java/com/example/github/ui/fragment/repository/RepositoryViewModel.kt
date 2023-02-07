package com.example.github.ui.fragment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.remote.handler.onError
import com.example.data.remote.handler.onException
import com.example.data.remote.handler.onSuccess
import com.example.domain.model.GitRepo
import com.example.domain.usecase.UpdateLocalBookmarkUseCase
import com.example.domain.usecase.GetAllLocalRepoUseCase
import com.example.domain.usecase.GetRemoteRepoUseCase
import com.example.github.ui.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val getRemoteRepoUseCase: GetRemoteRepoUseCase,
    getAllLocalRepoUseCase: GetAllLocalRepoUseCase,
    private val updateLocalBookmarkUseCase: UpdateLocalBookmarkUseCase,
) : ViewModel() {

    val stateResponse = SingleLiveEvent<String>()
    val allRepo: LiveData<List<GitRepo?>> = getAllLocalRepoUseCase().asLiveData()


    fun getGitRep(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getRemoteRepoUseCase.invoke(userName)
            response.onSuccess {
                stateResponse.postValue("Success")
            }.onError { code, message ->
                stateResponse.postValue("Error = $code  $message")
            }.onException {
                stateResponse.postValue("Exception =  ${it.message}")
            }
        }
    }
    fun updateBookmark(id:Int, isBookMark:Boolean) {
            updateLocalBookmarkUseCase.invoke(id,isBookMark)
    }


}