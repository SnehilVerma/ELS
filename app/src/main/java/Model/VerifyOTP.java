package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sibby on 20/6/17.
 */

public class VerifyOTP {

    @SerializedName("response")
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
