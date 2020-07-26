package com.example.goldenstatewarrior.ui.roster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.goldenstatewarrior.R;
import com.example.goldenstatewarrior.ui.gallery.GalleryViewModel;
import com.example.goldenstatewarrior.ui.home.HomeViewModel;

public class RosterFragment extends Fragment {
    private RosterViewModel rosterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rosterViewModel = ViewModelProviders.of(this).get(RosterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_roster ,container, false);
        final TextView textView = root.findViewById(R.id.text_roster);
       rosterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
