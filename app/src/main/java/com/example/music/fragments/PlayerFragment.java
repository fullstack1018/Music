package com.example.music.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.music.MainActivity;
import com.example.music.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String tap_key;

    public PlayerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayerFragment newInstance(String param1, String param2) {
        PlayerFragment fragment = new PlayerFragment();
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
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    private ImageView back_menu;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            tap_key = getArguments().getString("tab_key");
            Log.e("key", tap_key);
        }

        back_menu = view.findViewById(R.id.back_menu);
        back_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(view.getContext(), MainActivity.class);
//                startActivity(intent);

                MainActivity.tabLayout.setVisibility(View.VISIBLE);
                MainActivity.toolbar.setVisibility(View.VISIBLE);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment;
                if(tap_key.equals("menu")) {
                    myFragment = new MenuFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_menu, myFragment).addToBackStack(null).commit();
                }
                else if(tap_key.equals("top")) {
                    myFragment = new TopFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_top, myFragment).addToBackStack(null).commit();
                }
                else if(tap_key.equals("music")) {
                    myFragment = new MusicFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_music, myFragment).addToBackStack(null).commit();
                }
            }
        });
    }
}