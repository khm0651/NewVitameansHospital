package com.example.newvitameanshospital.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.newvitameanshospital.data.model.User
import com.example.newvitameanshospital.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val user: LiveData<User> = userRepository.loadUser().asLiveData()
}
