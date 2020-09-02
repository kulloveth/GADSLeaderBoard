package developer.kulloveth.com.gadsleaderboard.data.model

import com.squareup.moshi.Json


data class LearnerByIqSkillBaseResponse(val learnersByIqSkill: List<LearnerByIqSkill>)

data class LearnerByIqSkill(
    @Json(name = "name")
    val name: String,
    @Json(name = "score")
    val score: Int,
    @Json(name = "country")
    val country: String,
    @Json(name = "badgeUrl")
    val badgeUrl: String
)