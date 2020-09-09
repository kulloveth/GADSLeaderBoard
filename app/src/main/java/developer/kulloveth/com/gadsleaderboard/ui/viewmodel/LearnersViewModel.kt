package developer.kulloveth.com.gadsleaderboard.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import developer.kulloveth.com.gadsleaderboard.data.api.repository.LearnerRepository
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHour
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByIqSkill
import developer.kulloveth.com.gadsleaderboard.util.NetworkHelper
import developer.kulloveth.com.gadsleaderboard.util.Resource
import kotlinx.coroutines.launch

class LearnersViewModel(private val repository: LearnerRepository,private val networkHelper: NetworkHelper):ViewModel() {

    private val learnerByHourLivedata = MutableLiveData<Resource<List<LearnerByHour>>>()
    private val learnerByIqSkillsLivedata = MutableLiveData<Resource<List<LearnerByIqSkill>>>()
    private val formLivedata = MutableLiveData<Resource<String>>()
    val fLivedata = formLivedata
    fun getLearnersByHours():LiveData<Resource<List<LearnerByHour>>>{
        viewModelScope.launch {
           learnerByHourLivedata.postValue(Resource.loading(null))
            if(networkHelper.isNetworkConnected()){
            repository.getLearnersByHours().let {
                if (it.isSuccessful) {
                    learnerByHourLivedata.postValue(Resource.success(it.body()))
                }else learnerByHourLivedata.postValue(Resource.error(it.errorBody().toString(),null))
            }} else learnerByHourLivedata.postValue(
                Resource.error("No internet Connection",null)
            )}
        return learnerByHourLivedata
    }

    fun getLearnersBySkill():LiveData<Resource<List<LearnerByIqSkill>>>{
        viewModelScope.launch {
            learnerByIqSkillsLivedata.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
            repository.getLearnersBySkills().let {
                if(it.isSuccessful){
                    learnerByIqSkillsLivedata.postValue(Resource.success(it.body()))
                }else{
                    learnerByIqSkillsLivedata.postValue(Resource.error(it.errorBody().toString(),null))
                } }}else learnerByIqSkillsLivedata.postValue(Resource.error("No internet Connection",null)) }
        return learnerByIqSkillsLivedata
    }

    fun submitForm(email:String,name:String,lName:String,gitLink:String){
        viewModelScope.launch {
            repository.submitForm(email,name,lName,gitLink).let {
                if (it.isSuccessful){
                    formLivedata.postValue(Resource.success("submitted"))
                }else{
                    formLivedata.postValue(Resource.error("error submitting form",null))
                }
            }
        }

    }
}