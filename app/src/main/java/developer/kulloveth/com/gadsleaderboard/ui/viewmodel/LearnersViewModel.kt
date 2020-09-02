package developer.kulloveth.com.gadsleaderboard.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import developer.kulloveth.com.gadsleaderboard.data.api.repository.LearnerRepository
import kotlinx.coroutines.launch

class LearnersViewModel(private val repository: LearnerRepository):ViewModel() {

    fun getLearnersByHours(){
        viewModelScope.launch {
            repository.getLearnersByHours()
        }
    }

    fun getLearnersBySkill(){
        viewModelScope.launch {
            repository.getLearnersBySkills()
        }
    }
}