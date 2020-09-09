package developer.kulloveth.com.gadsleaderboard.data.api

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface FormService {
    @POST(ApiEndPoint.ENDPOINT_FORM_SUBMISSION)
    @FormUrlEncoded
    suspend fun submitForm(
        @Field("entry.1824927963")email:String,
        @Field("entry.1877115667")name:String,
        @Field("entry.2006916086")lName:String,
        @Field("entry.284483984")gitLink:String
    ):Response<Void>
}