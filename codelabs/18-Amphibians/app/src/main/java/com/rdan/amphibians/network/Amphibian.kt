package com.rdan.amphibians.network

data class Amphibian(
    val name: String,
    val type: AmphibianType,
    val imgSrc: String,
    val description: String,
)

val mockedAmphibians = listOf(
    Amphibian(
        name = "Great Basin Spadefoot",
        type = AmphibianType.Toad,
        description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
        imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
    ),
    Amphibian(
        name = "Pacific Tree Frog",
        type = AmphibianType.Frog,
        description = "A small frog that can be found in a variety of colors from green to brown. They are known for their distinct chirping sound.",
        imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/pacific-tree-frog.png"
    ),
    Amphibian(
        name = "Eastern Newt",
        type = AmphibianType.Salamander,
        description = "A common salamander found in eastern North America, with a bright orange juvenile stage called a 'red eft'.",
        imgSrc = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/eastern-newt.png"
    )
)