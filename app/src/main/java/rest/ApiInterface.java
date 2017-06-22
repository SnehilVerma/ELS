package rest;

import Model.ForgotPasswordRequestModel;
import Model.ForgotPasswordResponseModel;
import Model.LoginRequest;
import Model.LoginResponseModel;
import Model.Register;
import Model.RegisterRequestModel;
import Model.SendOtpForLoginRequest;
import Model.SendOtpForLoginResponse;
import Model.VerifyOTP;
import Model.VerifyOTPRequestModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by DM365 on 08-May-17.
 */

public interface ApiInterface {

    @POST("api/v1/users/login/")
    Call<LoginResponseModel> IAuthenticate(@Body LoginRequest loginRequest);

    @POST("api/v1/register/")
    Call<Register> IRegistration(@Body RegisterRequestModel registerRequest);

    @PUT("api/v1/send/otp/")
    Call<VerifyOTP> getOTP(@Body VerifyOTPRequestModel verifyOTPRequestModel);

    @POST("api/v1/forgotpassword/")
    Call<ForgotPasswordResponseModel> IForgotPassword(@Body ForgotPasswordRequestModel forgotPasswordRequest);

    @POST("api/v1/send/otp/")
    Call<SendOtpForLoginResponse> SendOtp(@Body SendOtpForLoginRequest sendOtpForLoginRequest);
}
