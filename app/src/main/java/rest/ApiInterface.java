package rest;

import Model.ForgotPasswordRequestModel;
import Model.ForgotPasswordResponseModel;
import Model.LoginRequest;
import Model.LoginResponseModel;
import Model.Register;
import Model.RegisterRequestModel;

import java.util.Map;

import Model.SendOtpForLoginRequest;
import Model.SendOtpForLoginResponse;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

/**
 * Created by DM365 on 08-May-17.
 */

public interface ApiInterface {

    @POST("api/v1/users/login/")
    Call<LoginResponseModel> IAuthenticate(@Body LoginRequest loginRequest);

    @POST("api/v1/register/")
    Call<Register> IRegistration(@Body RegisterRequestModel registerRequest);

    @POST("api/v1/forgotpassword/")
    Call<ForgotPasswordResponseModel> IForgotPassword(@Body ForgotPasswordRequestModel forgotPasswordRequest);

    @POST("api/v1/send/otp/")
    Call<SendOtpForLoginResponse> SendOtp(@Body SendOtpForLoginRequest sendOtpForLoginRequest);
}
