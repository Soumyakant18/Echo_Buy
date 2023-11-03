package com.example.echobuy.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.echobuy.R;
import com.example.echobuy.databinding.FragmentHomeBinding;
import com.example.echobuy.listviewitem;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private VideoView videoView;
private CardView crd1,crd2,crd3,crd4,crd5,crd6,crd7,crd8;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider (this).get (HomeViewModel.class);

        binding = FragmentHomeBinding.inflate (inflater, container, false);
        View root = binding.getRoot ( );

        videoView = root.findViewById (R.id.videoView);

        crd1 = root.findViewById (R.id.cardshirt);
        crd2 = root.findViewById (R.id.cardshoe);
        crd3 = root.findViewById (R.id.cardpant);
        crd4 = root.findViewById (R.id.cardwatch);
        crd5 = root.findViewById (R.id.cardfurn);
        crd6 = root.findViewById (R.id.cardphone);
        crd7 = root.findViewById (R.id.cardbag);
        crd8 = root.findViewById (R.id.cardtoy);
        Uri videoUri = Uri.parse("android.resource://" + requireActivity().getPackageName() + "/" + R.raw.shop);
        videoView.setVideoURI(videoUri);
        videoView.start();

        crd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitem.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ( );
        binding = null;
    }
}