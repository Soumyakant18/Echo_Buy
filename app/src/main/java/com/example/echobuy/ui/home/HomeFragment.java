package com.example.echobuy.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.echobuy.R;
import com.example.echobuy.databinding.FragmentHomeBinding;
import com.example.echobuy.listviewitem;
import com.example.echobuy.listviewitembag;
import com.example.echobuy.listviewitemfurn;
import com.example.echobuy.listviewitempant;
import com.example.echobuy.listviewitemphone;
import com.example.echobuy.listviewitemshoe;
import com.example.echobuy.listviewitemtoy;
import com.example.echobuy.listviewitemwatch;
import com.example.echobuy.mencategory;
import com.example.echobuy.perfumecategory;
import com.example.echobuy.womencategory;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

private CardView crd1,crd2,crd3,crd4,crd5,crd6,crd7,crd8;
private CardView men,women,perfume,phone,sofa;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider (this).get (HomeViewModel.class);

        binding = FragmentHomeBinding.inflate (inflater, container, false);
        View root = binding.getRoot ( );



        crd1 = root.findViewById (R.id.cardshirt);
        crd2 = root.findViewById (R.id.cardshoe);
        crd3 = root.findViewById (R.id.cardpant);
        crd4 = root.findViewById (R.id.cardwatch);
        crd5 = root.findViewById (R.id.cardfurn);
        crd6 = root.findViewById (R.id.cardphone);
        crd7 = root.findViewById (R.id.cardbag);
        crd8 = root.findViewById (R.id.cardtoy);
        men = root.findViewById(R.id.shape1);
        women = root.findViewById(R.id.shape2);
        perfume = root.findViewById(R.id.shape3);
        phone = root.findViewById(R.id.shape4);
        sofa = root.findViewById(R.id.shape5);


        crd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitem.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });
        crd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitemshoe.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });
        crd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitempant.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });
        crd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitemwatch.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });
        crd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitemfurn.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });
        crd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitemphone.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });
        crd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitembag.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });
        crd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitemtoy.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), mencategory.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), womencategory.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });

        perfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), perfumecategory.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });

        sofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitemfurn.class);
                intent.putExtra("key", "value");
                startActivity(intent);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the itemlist fragment when crd1 is clicked
                Intent intent = new Intent(getActivity(), listviewitemphone.class);
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