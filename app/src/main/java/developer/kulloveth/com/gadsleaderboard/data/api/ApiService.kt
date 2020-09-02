package developer.kulloveth.com.gadsleaderboard.data.api

import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHour
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByIqSkill
import retrofit2.Response
import retrofit2.http.GET

/*
 *
 */
interface ApiService {
    @GET(ApiEndPoint.ENDPOINT_LEARNERS_BY_HOURS)
    suspend fun getLeadersByLearningHours(): Response<List<LearnerByHour>>

    @GET(ApiEndPoint.ENDPOINT_LEARNERS_BY_SKILLS)
    suspend fun getLeadersByIqSkills(): Response<List<LearnerByIqSkill>>
}