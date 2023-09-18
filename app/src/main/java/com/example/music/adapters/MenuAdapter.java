package com.example.music.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.MainActivity;
import com.example.music.R;
import com.example.music.fragments.MenuFragment;
import com.example.music.fragments.PlayerFragment;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private ArrayList<String> data;
    public MenuAdapter(ArrayList<String> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_menu_item, parent, false);
        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        String item = data.get(position);
        holder.name.setText(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;

        public MenuViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.menuTextView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            Toast.makeText(itemView.getContext(), "Clicked Card...", Toast.LENGTH_LONG).show();

            MainActivity.tabLayout.setVisibility(View.GONE);
            MainActivity.toolbar.setVisibility(View.GONE);
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Fragment myFragment = new PlayerFragment();
            Bundle args = new Bundle();
            args.putString("tab_key", "menu");
            myFragment.setArguments(args);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_menu, myFragment).addToBackStack(null).commit();
        }
    }
}
