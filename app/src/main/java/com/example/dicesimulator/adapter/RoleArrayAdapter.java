package com.example.dicesimulator.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dicesimulator.R;
import com.example.dicesimulator.model.Role;

import java.util.List;

public class RoleArrayAdapter extends ArrayAdapter<Role> {
    private LayoutInflater inflater;
    private int layout;

    public RoleArrayAdapter(Activity activity, int layout, List<Role> roles) {
        super(activity, layout, roles);
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.itemText = convertView.findViewById(R.id.itemText);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Role role = getItem(position);
        viewHolder.itemText.setText(role.getNums());

        return convertView;
    }

    static class ViewHolder {
        public TextView itemText;
    }
}
