package developer.kulloveth.com.gadsleaderboard.data.api


class ApiHelperImpl(private val apiService: ApiService):ApiHelper {
    override suspend fun getLearnersByLearningHours() = apiService.getLeadersByLearningHours()
    override suspend fun getLearnersByIqSkill() = apiService.getLeadersByIqSkills()
}