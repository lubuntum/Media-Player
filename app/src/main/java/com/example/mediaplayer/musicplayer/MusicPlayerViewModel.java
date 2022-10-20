package com.example.mediaplayer.musicplayer;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class MusicPlayerViewModel extends ViewModel {
    private List<String> testMusicList;

    public List<String> getTestMusicList() {
        return testMusicList;
    }
}
