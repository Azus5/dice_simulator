package com.example.dicesimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener corkyListener = new View.OnClickListener() {
        public void onClick(View v) {
            EditText edtQntdRolar = (EditText)findViewById(R.id.qntdRolar);
            EditText edtNumMaximo = (EditText)findViewById(R.id.numMaximo);
            int qntdRolar = 1;
            int NumMaximo = 10;
            if(edtQntdRolar.getText().length() > 0) {
                qntdRolar =  Integer.valueOf(edtQntdRolar.getText().toString());
                NumMaximo = Integer.valueOf(edtNumMaximo.getText().toString());
            }
            Integer[] randomNumbers = new Integer[qntdRolar];
            Random rand = new Random();
            for(int i = 0;i<qntdRolar;i++) {
                randomNumbers[i] = rand.nextInt(NumMaximo);
                Log.d("Execução: ", String.valueOf(i));
                Log.d("Val: ", randomNumbers[i].toString());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.btnSubmit);
        button.setOnClickListener(corkyListener);
    }


}