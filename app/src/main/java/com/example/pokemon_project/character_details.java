package com.example.pokemon_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link character_details#newInstance} factory method to
 * create an instance of this fragment.
 */
public class character_details extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public character_details() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment character_details.
     */
    // TODO: Rename and change types and number of parameters
    public static character_details newInstance(String param1, String param2) {
        character_details fragment = new character_details();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_details, container, false);

        TextView newTextViewName = view.findViewById(R.id.textViewName);
        TextView newTextViewVersion = view.findViewById(R.id.textViewVersion);
        ImageView newImageView = view.findViewById(R.id.imageView);
        newTextViewName.setText(getArguments().getString("name"));
        newTextViewVersion.setText(getArguments().getString("fullDescription"));
        String name = getArguments().getString("image");
        newImageView.setImageResource(getResources().getIdentifier(name, "drawable", "com.example.pokemon_project"));

        Button backButton = view.findViewById(R.id.buttonBackToMain);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_character_details_to_main_characters);
            }
        });

        return view;
    }
}