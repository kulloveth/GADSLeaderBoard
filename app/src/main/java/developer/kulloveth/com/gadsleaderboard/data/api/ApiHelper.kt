package developer.kulloveth.com.gadsleaderboard.data.api

import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHour
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByIqSkill

interface ApiHelper {

    suspend fun getLearnersByLearningHours():List<LearnerByHour>
    suspend fun getLearnersByIqSkill():List<LearnerByIqSkill>

}