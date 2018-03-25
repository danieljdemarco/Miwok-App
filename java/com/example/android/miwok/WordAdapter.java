package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by danieldemarco on 3/15/18.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int color;

    public WordAdapter(Activity context, ArrayList<Word> words, int color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.color = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwokTV
        TextView miwokView = (TextView) listItemView.findViewById(R.id.miwokTV);
        // Get the translation from the current Word object and
        // set this text on the Miwok TextView
        miwokView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID defaultTV
        TextView defaultView = (TextView) listItemView.findViewById(R.id.defaultTV);
        // Get the translation from the current Word object and
        // set this text on the default TextView
        defaultView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image;
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image from the current Word object and
        // set this image on the image ImageView
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        //set the background color of the LinearLayout containing the text views and play button
        LinearLayout textLayout = (LinearLayout) listItemView.findViewById(R.id.text_and_media);
        textLayout.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
