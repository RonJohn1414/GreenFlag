package com.example.firstassignmentgreenflag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<User> dataSet;

    public void setDataSet(List<User> dataSet){
        this.dataSet = dataSet;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder (
                LayoutInflater.from (viewGroup.getContext ()).inflate (
                        R.layout.item_layout,
                        viewGroup,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.birthday.setText (dataSet.get (i).getBirthday ());
        customViewHolder.country.setText (dataSet.get (i).getCountry ());
        customViewHolder.gender.setText (dataSet.get (i).getGender ());
        customViewHolder.name_view.setText (dataSet.get (i).getName ());
        customViewHolder.zipcode.setText (dataSet.get (i).getZipcode ());
    }

    @Override
    public int getItemCount() {
        return dataSet.size ();
    }
}
