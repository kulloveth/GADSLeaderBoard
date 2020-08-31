package developer.kulloveth.com.gadsleaderboard.data.model

import com.squareup.moshi.Json

data class LearnerByHour(
    @Json(name = "name")
    val name: String,
    @Json(name = "hours")
    val hours: Int,
    @Json(name = "country")
    val country: String,
    @Json(name="badgeUrl")
    val badgeUrl: String
)