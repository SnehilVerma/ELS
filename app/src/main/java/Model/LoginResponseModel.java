package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by df393 on 6/14/2017.
 */
public class LoginResponseModel
{
    @SerializedName("token")
    private String token;
    @SerializedName("non_field_errors")
    private String non_field_errors;
    @SerializedName("status")
    private String status;
    @SerializedName("response")
    private String response;

    public String getToken() {
        return token;
    }

    public String getNon_field_errors() {
        return non_field_errors;
    }

    public String getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }
}
