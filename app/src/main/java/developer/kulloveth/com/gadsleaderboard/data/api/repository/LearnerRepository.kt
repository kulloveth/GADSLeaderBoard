package developer.kulloveth.com.gadsleaderboard.data.api.repository

import developer.kulloveth.com.gadsleaderboard.data.api.ApiHelper

class LearnerRepository(private val apiHelper: ApiHelper) {
    suspend fun getLearnersByHours() = apiHelper.getLearnersByLearningHours()
    suspend fun getLearnersBySkills() = apiHelper.getLearnersByIqSkill()
    suspend fun submitForm(email:String,name:String,lName:String,gitLink:String)=apiHelper.submitForm(email,name,lName, gitLink)
}