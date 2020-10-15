package com.example.dicesimulator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.Random;

public class HomeFragment extends Fragment {
    View view;

    private View.OnClickListener corkyListener = new View.OnClickListener() {
        public void onClick(View v) {
            EditText edtQntdRolar = (EditText)view.findViewById(R.id.qntdRolar);
            EditText edtNumMaximo = (EditText)view.findViewById(R.id.numMaximo);
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
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        Button btn = (Button)view.findViewById(R.id.btnSubmit);
        btn.setOnClickListener(corkyListener);
        return view;
    }
}
