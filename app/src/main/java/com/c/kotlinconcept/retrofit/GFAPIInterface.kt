package  com.c.kotlinconcept.retrofit

import com.c.kotlinconcept.retrofit.Users
import com.google.gson.JsonObject
import io.reactivex.Observable
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by santhos on 14/12/17.
 */
interface GFAPIInterface {

    @POST("user/users")
    fun createOrder(
        @Body orderData: ArrayList<Users>
    ): Observable<JSONObject>

    @POST("user/users")
    fun signUp(@Body users: Users): Call<JsonObject>

}
