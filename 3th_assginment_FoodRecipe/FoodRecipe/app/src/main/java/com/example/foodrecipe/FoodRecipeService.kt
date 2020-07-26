package com.example.foodrecipe

import android.media.Image
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 인터페이스를 이용하여 호출방식, 주소 그리고 데이터 등을 정의한다.
 * 레트로핏은 인터페이스 해석하여 통신을 처리한다.
 * 반환타입은 retrofit의 인터페이스 Call을 선택해야한다.
 * 다른 클래스의 Call을 선택하지 않도록 주의해야한다.
 */
interface FoodRecipeService {
    @GET("{idx1}/{idx2}")
    fun getData(
        @Path("idx1") foodIdx1: String,
        @Path("idx2") foodIdx2: String
    ): Call<FoodResponse>
}

/**
 * 응답 받을 데이터 구조와 같은 구조이어야 하며 변수 명도 같아야한다.
 */
data class FoodResponse(
    @SerializedName("COOKRCP01") val data: FoodRecipes
)

data class FoodRecipes(
    @SerializedName("row") val rows : Array<FoodValue>
)

data class FoodValue(
    @SerializedName("RCP_NM") val title: String,
    @SerializedName("ATT_FILE_NO_MK") val foodImgUrl: String
)