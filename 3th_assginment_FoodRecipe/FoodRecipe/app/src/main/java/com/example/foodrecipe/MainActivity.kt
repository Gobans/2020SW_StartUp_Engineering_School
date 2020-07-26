package com.example.foodrecipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var recipes: MutableList<simpleFoodValue> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ItemAdapter()
//        adapter.items = setData()
        // getDataByRetrofit 으로 얻은 Foodvalue 넣어야한다
        getDataByRetrofit {adapter.notifyDataSetChanged()}
        adapter.items = recipes
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }




    //Retrofit 으로 api 데이터 가져오기
    private fun getDataByRetrofit(callback: () -> Unit) {
        try{
            /**
             * retrofit 객체생성
             * 서버에서 데이터를 JSON으로 돌려주기 때문에 GsonConverterFactory.create()를 통하여 JSON을 변환해주는 컨버터도 추가해주고 build()를 통해 생성
             */
            val retrofit = Retrofit.Builder()
                .baseUrl("http://openapi.foodsafetykorea.go.kr/api/8f8163a74abf48a9a2e3/COOKRCP01/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            /**
             * retrofit 객체를 통해 인터페이스를 실행가능한 서비스객체 생성
             * 인터페이스에 정의된 API 엔드포인트들의 구현체를 만든다
             */
            val foodRecipeService = retrofit.create(FoodRecipeService::class.java)
            foodRecipeService.getData("0","10").enqueue(object: Callback<FoodResponse> {
                // foodIdx1,foodIdx2의 값은 나중에 변수로 처리
                override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                    Log.d("Response Error ::", "Failed API call with call: " + call +
                            " + exception: " + t)
                }

                override fun onResponse(
                    call: Call<FoodResponse>,
                    response: Response<FoodResponse>
                ) {
                    Log.d("Resopnse::", "${response.body()}")
                    if (response.isSuccessful){
//                        textView.append(response.body()?.data.toString())
                    //        fun setData():MutableList<Item>{
                    //            var data = mutableListOf<Item>()
                    //
                    //            for(i in 1..50){
                    //                data.add(Item("$i", "This is content $i"))
                    //            }
                    //            return data
                    //        }
                    //
//                        var data = mutableListOf<FoodValue>()
//                        return data
                        //mutableList를 따로 만들어서 요소를 추가하면 되는 것 이였다..
                        for ((idx, ele) in response.body()?.data?.rows!!.withIndex()) {
                            val item = simpleFoodValue(ele.foodImgUrl, ele.title, View.OnClickListener {
                                val intent = Intent(baseContext, DetailActivity::class.java)
//                                intent.putExtra("dataIdx", Integer.parseInt(startIdx) + idx)
                                startActivity(intent)
                            })
                            recipes.add(item)

                            }
                        callback()
                    }
                }
            })
        } catch (e: Exception){
            throw e
        }
    }

    //RecyclerView





}

