package com.example.goldenstatewarrior.ui.roster;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RosterViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public RosterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
