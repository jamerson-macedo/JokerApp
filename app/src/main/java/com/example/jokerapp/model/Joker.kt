package com.example.jokerapp.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("icon_url")val iconUrl: String,
    @SerializedName("value") val text: String
) {
    // como eu so quero 2 valores do jsoin entao tem que usar o serializable
}