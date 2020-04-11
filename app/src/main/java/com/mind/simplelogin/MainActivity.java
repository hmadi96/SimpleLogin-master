package com.mind.simplelogin;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btRegister;
    private ImageView circle1;
    TextView tvLogin;
    EditText user ,password;
    String myUser,myPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRegister  = findViewById(R.id.btRegister);
        tvLogin     = findViewById(R.id.tvLogin);
         circle1     = findViewById(R.id.circle1);
        user   = findViewById(R.id.etUsername);
        password  = findViewById(R.id.etPassword);
        btRegister.setOnClickListener(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v==btRegister){
            Intent a = new Intent(MainActivity.this, RegisterActivity.class);
            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View,String> (tvLogin,"login");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
            startActivity(a,activityOptions.toBundle());
        }
    }

    public void setInfoUser(View view) {
        myUser = user.getText().toString().trim();
        myPassword = password.getText().toString().trim();
      if(myUser.isEmpty() && myPassword.isEmpty()){
          Toast.makeText(this,"فارغات بعد عمك ",Toast.LENGTH_LONG).show();
        }else {
         if(myUser.equals("ali")&& myPassword.equals("077282")){
             startActivity( new Intent(this,Main2Activity.class));
         }else {
             Toast.makeText(this,"كلمة السر خطا",Toast.LENGTH_LONG).show();
         }

      }

    }
}
