package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by df393 on 6/14/2017.
 */
public class ForgotPasswordResponseModel {
    @SerializedName("status")
    private String status;

    @SerializedName("response")
    private String response;

    public String getResponse() {
        return response;
    }

    public String getStatus() {
        return status;
    }
}
