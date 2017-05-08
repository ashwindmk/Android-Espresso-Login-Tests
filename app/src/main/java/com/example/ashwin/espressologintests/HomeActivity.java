package com.example.ashwin.espressologintests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mWelcomeUserTextView;
    private String usernameString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        usernameString = getIntent().getExtras().getString("username");

        mWelcomeUserTextView = (TextView) findViewById(R.id.welcomeUserTextView);
        mWelcomeUserTextView.setText("Welcome " + usernameString);
    }
}
