package com.example.dicesimulator;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SobreFragment extends Fragment {
    View view;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_sobre, container, false);
        TextView textao = (TextView)view.findViewById(R.id.textao);
        textao.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }
}
