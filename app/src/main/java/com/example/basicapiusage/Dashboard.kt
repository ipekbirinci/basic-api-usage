package com.example.basicapiusage

import android.net.DnsResolver.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val serviceGenerator=ServiceGenerator.buildService(ApiService::class.java)
        val call=serviceGenerator.getPosts()
        val recyclerview=findViewById<RecyclerView>(R.id.myrecyclerview)

        call.enqueue(object :retrofit2.Callback<MutableList<PostModel>>{
            override fun onResponse(
                call: Call<MutableList<PostModel>>,
                response: Response<MutableList<PostModel>>
            ) {
                if(response.isSuccessful){
                   recyclerview.apply {
                       layoutManager=LinearLayoutManager(this@Dashboard)
                       adapter=PostAdapter(response.body()!!)
                   }

                }
            }

            override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error",t.message.toString())
            }
        })

    }

}