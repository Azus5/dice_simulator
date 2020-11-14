package com.example.dicesimulator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.dicesimulator.adapter.RoleArrayAdapter;
import com.example.dicesimulator.dao.RoleDAO;
import com.example.dicesimulator.model.Role;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    View view;

    private void getRoles(View view) {
        RoleDAO roleDAO = new RoleDAO(view.getContext());
        List<Role> roles = roleDAO.selectAll();

        System.out.println("Numeros: ");
        for(Role role : roles) {
            System.out.print(role.getId() + " ");
            System.out.println(role.getNums());
        }

        RoleArrayAdapter adapter = new RoleArrayAdapter(getActivity(), R.layout.history_item, roles);
        ListView ltvLista = view.findViewById(R.id.ltvLista);
        ltvLista.setAdapter(adapter);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_history, container, false);
        getRoles(view);

        return view;
    }
}
