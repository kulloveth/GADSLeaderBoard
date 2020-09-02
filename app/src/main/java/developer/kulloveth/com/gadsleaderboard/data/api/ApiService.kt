package developer.kulloveth.com.gadsleaderboard.data.api

import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHourBaseResponse
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByIqSkillBaseResponse
import retrofit2.http.GET

/*
 *
 */
interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_LEARNERS_BY_HOURS)
    suspend fun getLeadersByLearningHours():LearnerByHourBaseResponse

    @GET(ApiEndPoint.ENDPOINT_LEARNERS_BY_SKILLS)
    suspend fun getLeadersByIqSkills(): LearnerByIqSkillBaseResponse
}