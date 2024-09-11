package com.rdan.amphibians.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Amphibian(
    val name: String,
    val type: AmphibianType,

    @SerialName("img_src")
    val imgSrc: String,

    val description: String,
)