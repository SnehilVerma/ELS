package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sibby on 22/6/17.
 */

public class VerifyOTP {
     @SerializedName("response")
     @Expose
     private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
