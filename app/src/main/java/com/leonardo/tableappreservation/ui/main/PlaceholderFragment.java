package com.leonardo.tableappreservation.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.leonardo.tableappreservation.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_restaurant_menu, container, false);



//        final TextView textView = root.findViewById(R.id.section_labels);
//        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        final TextView item1Text = root.findViewById(R.id.item1Text);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                item1Text.setText("Small Combo");
            }
        });

        final TextView item2Text = root.findViewById(R.id.item2Text);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                item2Text.setText("Medium Combo");

            }
        });

        final TextView item3Text = root.findViewById(R.id.item3Text);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                item3Text.setText("Big Combo");

            }
        });

        final TextView item4Text = root.findViewById(R.id.item4Text);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                item4Text.setText("Couple Combo");

            }
        });

        // Desc

        final TextView item1Desc = root.findViewById(R.id.item1Desc);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                item1Desc.setText("This combo contains of 1 platter selection + 1 drink selection with price RM 12.00.");

            }
        });

        final TextView item2Desc = root.findViewById(R.id.item2Desc);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                item2Desc.setText("This combo contains of 2 platter selection + 2 drink selection with price RM 20.00.");

            }
        });

        final TextView item3Desc = root.findViewById(R.id.item3Desc);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                item3Desc.setText("This combo contains of 4 platter selection + 4 drink selection with price RM 35.00.");

            }
        });

        final TextView item4Desc = root.findViewById(R.id.item4Desc);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                item4Desc.setText("This combo contains of 2 couple platters + 2 couple special drinks with price RM .00.");

            }
        });

        //image

        final ImageView foodImage1 = root.findViewById(R.id.foodImage1);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Glide.with(getContext()).
                        load("https://www.theherdsman.com.au/wp-content/uploads/2016/07/cheese-platter-small.jpg").
                        into(foodImage1);
            }
        });

        final ImageView foodImage2 = root.findViewById(R.id.foodImage2);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Glide.with(getContext()).
                        load("https://i0.wp.com/platterup.ca/wp-content/uploads/2018/08/IMG_5393.jpg?fit=4032%2C3024&ssl=1").
                        into(foodImage2);
            }
        });

        final ImageView foodImage3 = root.findViewById(R.id.foodImage3);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Glide.with(getContext()).
                        load("https://www.miricitysharing.com/wp-content/uploads/2018/07/Big-Platter-Miri-2.jpg").
                        into(foodImage3);
            }
        });

        final ImageView foodImage4 = root.findViewById(R.id.foodImage4);
        pageViewModel.getText().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Glide.with(getContext()).
                        load("https://steemitimages.com/DQmUhdYzpik98sueJQ7LWoga5evJwZ827aVrBEtU5Ac1ruh/26166110_1603338606422195_270773957313904104_n.jpg").
                        into(foodImage4);
            }
        });





        return root;
    }
}