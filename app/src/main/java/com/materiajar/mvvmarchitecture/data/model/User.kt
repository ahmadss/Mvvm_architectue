package com.materiajar.mvvmarchitecture.data.model

import com.google.gson.annotations.SerializedName

/*"id": "1",
    "name": "Dr. Edwin Orn",
    "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/sunlandictwin/128.jpg",
    "email": "Connor.Hartmann71@gmail.com"*/

data class User(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("email")
    val email: String = "",

    @SerializedName("avatar")
    val avatar: String = ""

)
