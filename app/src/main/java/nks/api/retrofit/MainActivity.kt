package nks.api.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import nks.api.retrofit.repository.Repository

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getPost()
        viewModel.response1.observe(this, { response->
           if(response.isSuccessful) {
               Log.d("Response", response.body()?.userId.toString())
               Log.d("Response", response.body()?.id.toString())
               Log.d("Response", response.body()?.title!!)
               Log.d("Response", response.body()?.body!!)
           }
            else{
               Log.d("Response", response.errorBody().toString())
               Log.d("Response", response.code().toString())

           }
        })
    }
}