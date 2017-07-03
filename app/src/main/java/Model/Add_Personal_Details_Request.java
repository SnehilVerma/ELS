package Model;

/**
 * Created by snehil on 3/7/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Add_Personal_Details_Request {

    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("mother_name")
    @Expose
    private String motherName;
    @SerializedName("spouse_name")
    @Expose
    private String spouseName;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("pan_no")
    @Expose
    private String panNo;
    @SerializedName("voter_card_no")
    @Expose
    private String voterCardNo;
    @SerializedName("driving_license_no")
    @Expose
    private String drivingLicenseNo;
    @SerializedName("religion")
    @Expose
    private String religion;
    @SerializedName("caste")
    @Expose
    private String caste;
    @SerializedName("passport_no")
    @Expose
    private String passportNo;
    @SerializedName("aadhar_card_no")
    @Expose
    private String aadharCardNo;
    @SerializedName("educational_qualification")
    @Expose
    private String educationalQualification;

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getVoterCardNo() {
        return voterCardNo;
    }

    public void setVoterCardNo(String voterCardNo) {
        this.voterCardNo = voterCardNo;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getAadharCardNo() {
        return aadharCardNo;
    }

    public void setAadharCardNo(String aadharCardNo) {
        this.aadharCardNo = aadharCardNo;
    }

    public String getEducationalQualification() {
        return educationalQualification;
    }

    public void setEducationalQualification(String educationalQualification) {
        this.educationalQualification = educationalQualification;
    }

}

