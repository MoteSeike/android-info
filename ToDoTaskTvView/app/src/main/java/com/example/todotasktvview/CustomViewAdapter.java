package com.example.todotasktvview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomViewAdapter extends ArrayAdapter<RetroUserTask> {

    public CustomViewAdapter(@NonNull Context context, int resource, @NonNull List<RetroUserTask> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.customlistview, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        RetroUserTask currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.textView1);
        textView1.setText(currentNumberPosition.getUserName());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(currentNumberPosition.getTask());

        // then according to the position of the view assign the desired TextView 3 for the same
        TextView textView3= currentItemView.findViewById(R.id.textView3);
        textView3.setText(currentNumberPosition.getTaskDate());

        // then according to the position of the view assign the desired TextView 4 for the same
        TextView textView4= currentItemView.findViewById(R.id.textView4);
        textView4.setText(currentNumberPosition.getDescription());

        // then return the recyclable view
        return currentItemView;
    }
}
