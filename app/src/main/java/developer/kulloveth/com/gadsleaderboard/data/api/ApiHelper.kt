package developer.kulloveth.com.gadsleaderboard.data.api

import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByHourBaseResponse
import developer.kulloveth.com.gadsleaderboard.data.model.LearnerByIqSkillBaseResponse

interface ApiHelper {

    suspend fun getLearnersByLearningHours(): LearnerByHourBaseResponse
    suspend fun getLearnersByIqSkill(): LearnerByIqSkillBaseResponse

}