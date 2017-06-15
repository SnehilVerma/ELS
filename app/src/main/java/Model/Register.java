package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by df393 on 6/12/2017.
 */
public class Register {


    @SerializedName("id")
    private String id;
    @SerializedName("username")
    private String username;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("middle_name")
    private String middle_name;
    @SerializedName("last_name")
    private String last_name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("user_type")
    private String user_type;
    @SerializedName("city")
    private String city;
    @SerializedName("token")
    private String token;
    @SerializedName("contact_no")
    private String contact_no;
    @SerializedName("dob")
    private String dob;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getCity() {
        return city;
    }

    public String getToken() {
        return token;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getDob() {
        return dob;
    }
}
