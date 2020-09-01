package developer.kulloveth.com.gadsleaderboard.data.api.repository

import developer.kulloveth.com.gadsleaderboard.data.api.ApiHelper

class LearnerRepository(private val apiHelper: ApiHelper) {
    suspend fun getLearnersByHours() = apiHelper.getLearnersByLearningHours()
    suspend fun getLearnersBySkills() = apiHelper.getLearnersByIqSkill()
}