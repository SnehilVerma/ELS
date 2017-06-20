package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by df393 on 6/15/2017.
 */
public class ForgotPasswordRequestModel {
    @SerializedName("email")
    private String email;

    public ForgotPasswordRequestModel(String email) {
        this.email = email;
    }
}
