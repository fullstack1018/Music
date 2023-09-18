package com.example.music.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.MainActivity;
import com.example.music.R;
import com.example.music.fragments.PlayerFragment;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    private ArrayList<String> data;
    public MusicAdapter(ArrayList<String> data) {
        this.data = data;
    }
    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_music_item, parent, false);
        return new MusicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        String item = data.get(position);
        holder.name.setText(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;

        public MusicViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.musicTextView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            MainActivity.tabLayout.setVisibility(View.GONE);
            MainActivity.toolbar.setVisibility(View.GONE);
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Fragment myFragment = new PlayerFragment();
            Bundle args = new Bundle();
            args.putString("tab_key", "music");
            myFragment.setArguments(args);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_music, myFragment).addToBackStack(null).commit();
        }
    }
}
