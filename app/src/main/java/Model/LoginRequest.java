package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sibby on 6/21/2017.
 */
public class LoginRequest {


    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
