package com.example.android.encrypt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Activity extends AppCompatActivity {

    Button btnMd5;
    EditText edtMd5;
    TextView txtMd5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md5);

        btnMd5 = findViewById(R.id.button_md5);
        edtMd5 = findViewById(R.id.editText_md5);
        txtMd5 = findViewById(R.id.textView_md5);

        btnMd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMd5.setText(getMdHash(edtMd5.getText().toString()));
            }
        });
    }

    private String getMdHash(String toString) {
        String MD5 = "MD5";

        try {

            // This creates MD5 hash
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(toString.getBytes());
            byte messageDigest[] = digest.digest();

            // To create Hex String
            StringBuilder hexString = new StringBuilder();

            for(byte aMsgDigest : messageDigest){
                String h = Integer.toHexString(0xFF & aMsgDigest);

                while(h.length()<2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
