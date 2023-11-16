package com.example.echobuy.ui.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.echobuy.DatabaseHelper;
import com.example.echobuy.R;
import com.example.echobuy.User;
import com.example.echobuy.R;
import com.example.echobuy.databinding.FragmentAccountBinding;
import com.example.echobuy.loginactivity;

import java.util.List;

public class AccountFragment extends Fragment {

    private TextView textViewName, textViewEmail;
    private DatabaseHelper databaseHelper;

    private Button btnMoveToActivity;
    private FragmentAccountBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AccountViewModel slideshowViewModel =
                new ViewModelProvider (this).get (AccountViewModel.class);



        binding = FragmentAccountBinding.inflate (inflater, container, false);
        View root = binding.getRoot ( );

        textViewName = root.findViewById(R.id.accname); // Replace with your TextView for name
        textViewEmail = root.findViewById(R.id.accemail);

        databaseHelper = new DatabaseHelper(requireContext());

        // Retrieve user data from the database
        List<User> userList = databaseHelper.getAllUsers();

        // Assuming you want to display the data of the first user retrieved
        if (!userList.isEmpty()) {
            User user = userList.get(0); // Get the first user for display
            textViewName.setText(user.getUsername());
            textViewEmail.setText(user.getEmail());
        }

    //    final TextView textView = binding.textSlideshow;
        btnMoveToActivity = root.findViewById(R.id.btnacc);

        btnMoveToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), loginactivity.class);
                startActivity(intent);
            }
        });
        //    final TextView textView = binding.textSlideshow;

      //  slideshowViewModel.getText ( ).observe (getViewLifecycleOwner ( ), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ( );
        binding = null;
    }
}