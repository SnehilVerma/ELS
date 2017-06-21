package Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sibby on 20/6/17.
 */

public class VerifyOTPRequestModel {
    @SerializedName("contact_no")
    private String contact_no;
    @SerializedName("otp")
    private String otp;
    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

}
