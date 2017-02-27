package jinwoo.hw_2;


import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jinwoo.hw_2.R;


public class LoginScreen extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login_BNT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);
        login_BNT = (Button) findViewById(R.id.login_button);

        login_BNT.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (password.getText().toString().equals("123") &&
                                username.getText().toString().equals("user")) {

                            Intent intent = new Intent(v.getContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
        );
    }
}
