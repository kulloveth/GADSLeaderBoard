package developer.kulloveth.com.gadsleaderboard.data.api

import retrofit2.Response


class ApiHelperImpl(private val apiService: ApiService,private val formService: FormService):ApiHelper {
    override suspend fun getLearnersByLearningHours() = apiService.getLeadersByLearningHours()
    override suspend fun getLearnersByIqSkill() = apiService.getLeadersByIqSkills()
    override suspend fun submitForm(email:String,name:String,lName:String,gitLink:String): Response<Void> {
       return formService.submitForm(email,name,lName,gitLink)
    }
}