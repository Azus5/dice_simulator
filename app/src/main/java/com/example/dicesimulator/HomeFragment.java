package com.example.dicesimulator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.dicesimulator.dao.RoleDAO;
import com.example.dicesimulator.model.Role;

import java.util.Arrays;
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

            String nums = "[ ";
            Random rand = new Random();
            for(int i = 0;i<qntdRolar;i++) {
                nums += String.valueOf(rand.nextInt(NumMaximo)) + " ";
            }
            nums += "]";
            RoleDAO roleDao = new RoleDAO(view.getContext());
            roleDao.create(new Role(0, nums));

            TextView txtNumbers = (TextView)view.findViewById(R.id.numbers);
            ImageView copyIcon = (ImageView)view.findViewById(R.id.copy_icon);
            txtNumbers.setText(nums);
            copyIcon.setVisibility(View.VISIBLE);

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
