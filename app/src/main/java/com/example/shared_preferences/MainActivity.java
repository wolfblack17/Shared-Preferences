package com.example.shared_preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText User, pass;
    CheckBox cbSavePass;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = User.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if(username.equals("thanhtuong") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    if (cbSavePass.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", username);
                        editor.putString("matkhau", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void anhxa() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        User = (EditText) findViewById(R.id.inputUser);
        pass = (EditText) findViewById(R.id.inputPassword);
        cbSavePass = (CheckBox) findViewById(R.id.cbRemember);
    }
}