package com.example.firstassignmentgreenflag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class WordListAdapter extends
        RecyclerView.Adapter<CustomViewHolder> {
    private final List<User> mWordList;

    public WordListAdapter(
                           List<User> wordList) {
        this.mWordList = wordList;


    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new CustomViewHolder (
                LayoutInflater.from (viewGroup.getContext ()).inflate (
                        R.layout.item_layout,viewGroup,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int position) {
        customViewHolder.birthday.setText (mWordList.get (position).getBirthday ());
        customViewHolder.gender.setText (mWordList.get (position).getGender ());
        customViewHolder.zipcode.setText (mWordList.get (position).getZipcode ());
        customViewHolder.country.setText (mWordList.get (position).getCountry ());
        customViewHolder.name_view.setText (mWordList.get (position).getName ());


    }

    @Override
    public int getItemCount() {
        return mWordList.size ();
    }


}
