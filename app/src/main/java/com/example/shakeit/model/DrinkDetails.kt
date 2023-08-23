package com.example.shakeit.model



import com.google.gson.annotations.SerializedName

data class DrinkDetails(

    val dateModified: String?,

    @SerializedName("idDrink")
    val idDrink: String,

    val strAlcoholic: String?,
    val strCategory: String?,
    val strCreativeCommonsConfirmed: String?,
    @SerializedName("strDrink")
    val strDrink: String?,
    val strDrinkAlternate: String?,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?,
    val strGlass: String?,
    val strIBA: String?,
    val strImageAttribution: String?,
    val strImageSource: String?,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strInstructions: String?,
    val strInstructionsDE: String?,
    val strInstructionsES: String?,
    val strInstructionsFR: String?,
    val strInstructionsIT: String?,
    @SerializedName("strInstructionsZH_HANS")
    val strInstructionsZH_HANS: String?,
    @SerializedName("strInstructionsZH_HANT")
    val strInstructionsZH_HANT: String?,
    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strTags: String?,
    val strVideo: String?
){    fun toDrink (drinkDetails: DrinkDetails): Drink {
        return drinkDetails.strDrink?.let {
            drinkDetails.strDrinkThumb?.let { it1 ->
                Drink(
                    idDrink = drinkDetails.idDrink,
                    strDrink = it,
                    strDrinkThumb = it1
                )
            }
        } ?: Drink("", "", "")
    }
}

