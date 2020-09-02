package developer.kulloveth.com.gadsleaderboard.data.model

data class Resource<out T>(private val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?) = Resource(Status.SUCCESS, data, null)
        fun <T> error(msg: String, data: T?) = Resource(Status.SUCCESS, data, msg)
        fun <T> loading(data: T?) = Resource(Status.LOADING, data, null)
    }
}