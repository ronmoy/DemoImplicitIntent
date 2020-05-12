package com.myapplicationdev.android.demoimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnEmail, btnRP;
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage=(EditText)findViewById(R.id.editTextMessage);
        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,
                        editTextMessage.getText());
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }});
        btnRP = findViewById(R.id.btnRP);
        btnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });
    }
}
