package com.example.a8mm.Models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("response")
    private String  Response;

    @SerializedName("user_id")
    private String UserId;

    public String getResponse() {
        return Response;
    }

    public String getUserId() {
        return UserId;
    }

    //    @Expose
//    @SerializedName("email")
//    private String email;
//
//    @Expose
//    @SerializedName("name")
//    private String name;
//
//    @Expose
//    @SerializedName("phone")
//    private String phone;
//
//    @Expose
//    @SerializedName("password")
//    private String password;
//
//    @Expose
//    @SerializedName("success")
//    private boolean success;
//
//    @Expose
//    @SerializedName("message")
//    private String message;
//
//
//    public UserModel() {
//    }
//
//    public UserModel(String name, String email, String phone, String password, boolean success,
//                     String message) {
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//        this.success = success;
//        this.message = message;
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }


}
