package com.example.echobuy;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.echobuy.databinding.ActivityMenupageBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class menupage_activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMenupageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        binding = ActivityMenupageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar (binding.appBarMenupage.toolbar);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT username, email FROM Users WHERE id = 1", null);
        String userName = "";
        String userEmail = "";
        if (cursor != null && cursor.moveToFirst()) {
            int userNameIndex = cursor.getColumnIndex("username");
            int userEmailIndex = cursor.getColumnIndex("email");

            if (userNameIndex != -1) {
                userName = cursor.getString(userNameIndex);
            }

            if (userEmailIndex != -1) {
                userEmail = cursor.getString(userEmailIndex);
            }
        }
        if (cursor != null) {
            cursor.close();
        }


        db.close();

        NavigationView navigationView = binding.navView;
        View headerView = navigationView.getHeaderView(0);
        TextView userNameTextView = headerView.findViewById(R.id.nav_header_name); // Replace with actual ID
        TextView userEmailTextView = headerView.findViewById(R.id.nav_header_email); // Replace with actual ID

        userNameTextView.setText(userName);
        userEmailTextView.setText(userEmail);

        binding.appBarMenupage.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView1 = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder (
                R.id.nav_home, R.id.nav_order, R.id.nav_account, R.id.nav_logout)
                .setOpenableLayout (drawer)
                .build ( );
        NavController navController = Navigation.findNavController (this, R.id.nav_host_fragment_content_menupage);
        NavigationUI.setupActionBarWithNavController (this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController (navigationView, navController);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ( ).inflate (R.menu.menupage_activity, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController (this, R.id.nav_host_fragment_content_menupage);
        return NavigationUI.navigateUp (navController, mAppBarConfiguration)
                || super.onSupportNavigateUp ( );
    }
}