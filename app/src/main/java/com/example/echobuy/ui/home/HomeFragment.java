package com.example.echobuy.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.echobuy.R;
import com.example.echobuy.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private VideoView videoView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider (this).get (HomeViewModel.class);

        binding = FragmentHomeBinding.inflate (inflater, container, false);
        View root = binding.getRoot ( );

        videoView = root.findViewById (R.id.videoView);

        Uri videoUri = Uri.parse("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.shop);
        videoView.setVideoURI(videoUri);
        videoView.start();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ( );
        binding = null;
    }
}