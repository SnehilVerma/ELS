package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rishi on 6/20/2017.
 */

public class SendOtpForLoginRequest {

    @SerializedName("contact_no")
    @Expose
    private String contactNo;

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

}
