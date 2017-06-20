package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by df393 on 6/14/2017.
 */
public class LoginRequest {
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
