package com.minhnpa.readfiledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRead;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = (Button) findViewById(R.id.btnRead);
        editText = (EditText) findViewById(R.id.editText);

        btnRead.setOnClickListener(this);
    }

    public String readFile() {
        InputStream is = this.getResources().openRawResource(R.raw.read);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuffer strBuffer = new StringBuffer();

        if (is != null) {
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    strBuffer.append(line + "\n");
                }
                bufferedReader.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strBuffer.toString();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRead) {
            editText.setText(readFile());
        }
    }
}
