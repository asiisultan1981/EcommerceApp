package com.example.a8mm.PhoneLoginRegister;

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

public class PhoneLoginActivity extends AppCompatActivity {
    private EditText phone;
    private Button btn_signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);

        ///////////////// No Status bar start ///////////////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        ///////////////// No Status bar end ///////////////

        init();
    }

    private void init() {
        phone = (EditText)findViewById(R.id.phone);
        btn_signIn = (Button)findViewById(R.id.btn_signIn);
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneLogin();
            }
        });

    }

    private void PhoneLogin() {
        String phoneNumber = phone.getText().toString();



        if (TextUtils.isEmpty(phoneNumber))
        {
            phone.setError("phoneNumber is required!");
        }else
        {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Signing in...");
            progressDialog.setMessage("Please wait while we are checking your credentials");
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);

            Toast.makeText(PhoneLoginActivity.this,"Success",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void GoToRegister(View view) {
        Intent intent = new Intent(PhoneLoginActivity.this, PhoneRegisterActivity.class);
        startActivity(intent);
        Animatoo.animateSwipeRight(PhoneLoginActivity.this);
    }

    public void GoToHome(View view) {
        Intent intent = new Intent(PhoneLoginActivity.this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateSlideDown(PhoneLoginActivity.this);
    }
}
