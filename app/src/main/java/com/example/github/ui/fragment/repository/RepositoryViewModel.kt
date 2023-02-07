package com.example.github.ui.fragment.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.handler.onError
import com.example.data.remote.handler.onException
import com.example.data.remote.handler.onSuccess
import com.example.domain.model.GitProfile
import com.example.domain.model.GitRepo
import com.example.domain.usecase.GitRepoDataUseCase
import com.example.github.ui.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(private val gitRepoDataUseCase: GitRepoDataUseCase) : ViewModel() {

    val stateResponse = SingleLiveEvent<String>()
    val gitRepo= SingleLiveEvent<List<GitRepo>>()



    fun getGitRep(userName:String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = gitRepoDataUseCase.invoke(userName)
            response.onSuccess {
                stateResponse.postValue("Success")
                gitRepo.postValue(it)
            }.onError { code, message ->
                stateResponse.postValue("Error = $code  $message")
            }.onException {
                stateResponse.postValue("Exception =  ${it.message}")
            }
        }
    }


}