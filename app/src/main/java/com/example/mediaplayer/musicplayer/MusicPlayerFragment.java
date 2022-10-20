package com.example.mediaplayer.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.mediaplayer.R;
import com.example.mediaplayer.databinding.FragmentMusicPlayerBinding;

public class MusicPlayerFragment extends Fragment {
    FragmentMusicPlayerBinding binding;
    MusicPlayerViewModel musicPlayerViewModel;
    ArrayAdapter<String> testMusicAdapter;
    ActivityResultLauncher<Intent> downloadMusic =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK){
                                Toast.makeText(getContext(), result.getData().getData().toString(), Toast.LENGTH_SHORT).show();
                                /*Parse file*/
                            }
                        }
                    });
    public MusicPlayerFragment() {
        // Required empty public constructor
    }

    public static MusicPlayerFragment newInstance() {
        MusicPlayerFragment fragment = new MusicPlayerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMusicPlayerBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        musicListInit();
    }

    public void musicListInit(){
        testMusicAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                musicPlayerViewModel.getTestMusicList());
        binding.musicList.setAdapter(testMusicAdapter);
    }

}