package com.example.ai37c.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ai37c.model.UserModel
import com.example.ai37c.repository.UserRepo
import com.google.firebase.auth.FirebaseUser

class UserViewModel(val repo: UserRepo) : ViewModel() {


    fun login(
        email: String, password: String,
        callback: (Boolean, String) -> Unit
    ){
        repo.login(email,password,callback)
    }

    fun register(
        email: String, password: String,
        callback: (Boolean, String, String) -> Unit
    ){
     repo.register(email,password,callback)
    }

    fun addUserToDatabase(
        userId: String,
        model: UserModel, callback: (Boolean, String) -> Unit
    ){
        repo.addUserToDatabase(userId,model,callback)
    }

    fun forgetPassword(email: String, callback: (Boolean, String) -> Unit){
        repo.forgetPassword(email,callback)
    }

    fun editProfile(
        userId: String, model: UserModel,
        callback: (Boolean, String) -> Unit
    ){
        repo.editProfile(userId,model,callback)
    }

    fun logout(callback: (Boolean, String) -> Unit){
       repo.logout(callback)
    }

    fun deleteAccount(userId: String, callback: (Boolean, String) -> Unit){
        repo.deleteAccount(userId,callback)
    }

    fun getCurrentUser(): FirebaseUser?{
        return repo.getCurrentUser()
    }

    private val _users = MutableLiveData<UserModel?>()
    val users : MutableLiveData<UserModel?> get() = _users

    private val _allUsers = MutableLiveData<List<UserModel>?>()
    val allUsers : MutableLiveData<List<UserModel>?> get() = _allUsers

    fun getUserById(
        userId: String
    ){
        repo.getUserById(userId){
            success,msg,data->
            if(success){
                _users.postValue(data)
            }else{
                _users.postValue(null)

            }
        }
    }

    fun getAllUser(){
        repo.getAllUser {
            success,message,data->
            if (success){
                _allUsers.postValue(data)
            }else{
                _allUsers.postValue(emptyList())

            }
        }
    }


}