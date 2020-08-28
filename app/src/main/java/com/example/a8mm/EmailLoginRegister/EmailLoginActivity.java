package com.example.a8mm.EmailLoginRegister;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.a8mm.MainActivity;
import com.example.a8mm.R;

public class EmailLoginActivity extends AppCompatActivity  {
    private static final String TAG = "email_login" ;
//    ApiInterface apiInterface;
//    @BindView(R.id.email) EditText email;
//    @BindView(R.id.password) EditText password;
//    Button signin;
   private EditText email, password;
   private Button btn_signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        setContentView(R.layout.activity_email_login);

//        ButterKnife.bind(this);

//        email = findViewById(R.id.email);
//        password = findViewById(R.id.password);

//        ButterKnife.bind(this);

        ///////////////// No Status bar start ///////////////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        ///////////////// No Status bar end ///////////////

        //////////////// hide status bar start ////////////
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //////////////// hide status bar end ////////////

//        signin = findViewById(R.id.btn_signIn);
//        signin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Call<UserModel> userModelCall = apiInterface.loginUser(email.getText().toString().trim(),
//                        password.getText().toString());
//
//                userModelCall.enqueue(new Callback<UserModel>() {
//                    @Override
//                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
//                        if (response.body() != null){
//                            UserModel userModel = response.body();
//
//                            if (userModel.isSuccess()){
//                                Toast.makeText(EmailLoginActivity.this, "Successfully Logged in",
//                                        Toast.LENGTH_LONG).show();
//                            }else {
//                                Toast.makeText(EmailLoginActivity.this, "Could not  Logged in  ",
//                                        Toast.LENGTH_LONG).show();
//                                Log.d(TAG, "onResponse: "+response);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<UserModel> call, Throwable t) {
//                        Toast.makeText(EmailLoginActivity.this, "Could not  Loggd in  ",
//                                Toast.LENGTH_LONG).show();
//                        Log.d(TAG, "onFailure: "+t);
//                    }
//                });
//            }
//        });

        init();


    }

    private void init() {
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        btn_signIn = (Button)findViewById(R.id.btn_signIn);

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              LoggingIn();
            }
        });
    }

    private void LoggingIn() {
        String user_email = email.getText().toString();
        String user_password = password.getText().toString();

        if(TextUtils.isEmpty(user_email))
        {
            email.setError("Email is required!");
        }else if (TextUtils.isEmpty(user_password))
        {
            password.setError("Password is required!");
        }else{

            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Signing in...");
            progressDialog.setMessage("Please wait while we are checking your credentials");
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);

            Toast.makeText(EmailLoginActivity.this,"Success",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void GoToRegister(View view) {
        Intent intent = new Intent(EmailLoginActivity.this, EmailRegisterActivity.class);
        startActivity(intent);
        Animatoo.animateSwipeRight(EmailLoginActivity.this);
    }

    public void GoToHome(View view) {
        Intent intent = new Intent(EmailLoginActivity.this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateSlideDown(EmailLoginActivity.this);
    }
//    public void loginUser(View view){
//
//    }



}