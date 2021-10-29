package nks.api.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nks.api.retrofit.model.Post
import nks.api.retrofit.repository.Repository
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {
    val response1:MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {



            val response:Response<Post> = repository.getPost()
            response1.value=response

        }
    }
}