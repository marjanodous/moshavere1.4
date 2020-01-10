package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class login extends AppCompatActivity {
    userApp user = new userApp();
    TextView txtgotosingup;
    Button btnLoin;
    public String StoredValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtgotosingup=findViewById(R.id.txtgotosingup);
        btnLoin=findViewById(R.id.ok_sing_up);

        StoredValue = returnExit();
        testNoFirst();

        if(StoredValue == "exit"){
            txtgotosingup.setEnabled(false);
//            Toast.makeText(login.this, "OKKKKKKKKKKK Exit!", Toast.LENGTH_SHORT).show();
        }
        else if(StoredValue == null){
//            Toast.makeText(login.this, "Noooooo Exit!", Toast.LENGTH_SHORT).show();
        }
        txtgotosingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,signup.class));
                login.this.finish();
            }
        });
        btnLoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(login.this);
                user = sharedPreferencesManager.get_shared_preferences();

                if (user.getFirst_time_run() == false) {
                    Toast.makeText(login.this, " ثبت نام کردین!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, MainActivity.class));
                    login.this.finish();

                } else {
                    Toast.makeText(login.this, "لطفا ثبت نام کنید!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void testNoFirst(){
        final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(login.this);
        user = sharedPreferencesManager.get_shared_preferences();

        if (user.getFirst_time_run() == false) {
            startActivity(new Intent(login.this, MainActivity.class));
            login.this.finish();
        }
        if ( StoredValue =="exit") {
//            Toast.makeText(login.this, " exit >> false", Toast.LENGTH_LONG).show();
            user.setFirst_time_run(false);
            sharedPreferencesManager.set_false_first_time(user);
            delExit();
        }
    }
    public String returnExit(){
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("Exit", MODE_PRIVATE);
        String val = myPrefs.getString("exit", null);
        return val;
    }
    public void delExit() {
        SharedPreferences userDetails = getApplicationContext().getSharedPreferences("Exit", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.remove("exit");
        edit.commit();
    }

}
