package developer.kulloveth.com.gadsleaderboard.data.api

import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHour
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByIqSkill
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByIqSkillBaseResponse
import retrofit2.Response

interface ApiHelper {

    suspend fun getLearnersByLearningHours(): Response<List<LearnerByHour>>
    suspend fun getLearnersByIqSkill(): Response<List<LearnerByIqSkill>>

}