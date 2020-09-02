package developer.kulloveth.com.gadsleaderboard.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import developer.kulloveth.com.gadsleaderboard.data.api.repository.LearnerRepository
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHour
import developer.kulloveth.com.gadsleaderboard.data.model.Resource
import kotlinx.coroutines.launch

class LearnersViewModel(private val repository: LearnerRepository):ViewModel() {

    private val learnerByHourLivedata = MutableLiveData<Resource<List<LearnerByHour>>>()
    fun getLearnersByHours():LiveData<Resource<List<LearnerByHour>>>{
        viewModelScope.launch {
           learnerByHourLivedata.postValue(Resource.loading(null))
            repository.getLearnersByHours().let {
                if (it.isSuccessful) {
                    learnerByHourLivedata.postValue(Resource.success(it.body()))
                }else{learnerByHourLivedata.postValue(Resource.error(it.errorBody().toString(),null))}
            }
        }
        return learnerByHourLivedata
    }

    fun getLearnersBySkill(){
        viewModelScope.launch {
            repository.getLearnersBySkills()
        }
    }
}