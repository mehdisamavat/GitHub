package com.example.github.ui.fragment.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.handler.onError
import com.example.data.remote.handler.onException
import com.example.data.remote.handler.onSuccess
import com.example.domain.model.GitProfile
import com.example.domain.usecase.GetRemoteProfileUseCase
import com.example.github.ui.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val getProfileUseCase: GetRemoteProfileUseCase): ViewModel() {

    val stateResponse = SingleLiveEvent<String>()
    val profile=SingleLiveEvent<GitProfile>()

    fun getProfile(userName:String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = getProfileUseCase.invoke(userName)
            response.onSuccess {
                stateResponse.postValue("Success")
                profile.postValue(it)
            }.onError { code, message ->
                stateResponse.postValue("Error = $code  $message")
            }.onException {
                stateResponse.postValue("Exception =  ${it.message}")
            }
        }
    }


}