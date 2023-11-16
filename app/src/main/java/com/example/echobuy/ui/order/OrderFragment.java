package com.example.echobuy.ui.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.echobuy.DatabaseHelper;
import com.example.echobuy.R;
import com.example.echobuy.User;
import com.example.echobuy.databinding.FragmentOrderBinding;

import java.util.List;

public class OrderFragment extends Fragment {

    private TextView textViewName;
    private TextView textView2;
    private DatabaseHelper databaseHelper;

    private FragmentOrderBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Remove the ViewModel related code
        binding = FragmentOrderBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textViewName = root.findViewById(R.id.name);
        textView2 = root.findViewById(R.id.orderto);
        databaseHelper = new DatabaseHelper(requireContext());

        List<User> userList = databaseHelper.getAllUsers();

        if (!userList.isEmpty()) {
            User user = userList.get(0); // Get the first user for display
            textViewName.setText(user.getUsername());
        }

        // Your code for the fragment goes here (if needed)

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
