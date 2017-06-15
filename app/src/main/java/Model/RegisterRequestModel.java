package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by df393 on 6/12/2017.
 */
public class RegisterRequestModel {
    @SerializedName("username")
    private String username;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("middle_name")
    private String middle_name;
    @SerializedName("last_name")
    private String last_name;

    public RegisterRequestModel(String username, String first_name, String middle_name, String last_name, String gender, String user_type, String city, String contact_no, String dob, String password) {
        this.username = username;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.user_type = user_type;
        this.city = city;
        this.contact_no = contact_no;
        this.dob = dob;
        this.password = password;
    }

    @SerializedName("gender")
    private String gender;
    @SerializedName("user_type")
    private String user_type;
    @SerializedName("city")
    private String city;
    @SerializedName("contact_no")
    private String contact_no;
    @SerializedName("dob")
    private String dob;
    @SerializedName("password")
    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
