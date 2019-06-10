package com.example.firstassignmentgreenflag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    public TextView name_view;
    public TextView country;
    public TextView zipcode;
    public TextView gender;
    public TextView birthday;


    public CustomViewHolder(@NonNull View itemView) {
        super (itemView);
        name_view = itemView.findViewById (R.id.il_name);
        country = itemView.findViewById (R.id.il_country);
        zipcode = itemView.findViewById (R.id.il_zipcode);
        gender = itemView.findViewById (R.id.il_gender);
        birthday = itemView.findViewById (R.id.il_birthday);

    }
}

