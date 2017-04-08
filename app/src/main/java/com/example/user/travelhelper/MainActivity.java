package com.example.user.travelhelper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.settings_m) {
                    drawerLayout.closeDrawer(Gravity.START);
                    Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    return false;
                }

                return false;
            }
        });

        ListView listView = (ListView) findViewById(R.id.list_view);
        int itemLayout = android.R.layout.simple_list_item_1;
        ArrayAdapter adapter = new TravelAdapter(MainActivity.this, Database.COUNTRIES);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { // если нажали на
            case android.R.id.home: // кнопку меню
                // ищем меню
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) { // если уже открыто
                    drawerLayout.closeDrawer(GravityCompat.START); // закрываем
                } else { // иначе
                    drawerLayout.openDrawer(GravityCompat.START); // открываем
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    ConfirmationDialogFragment dialog = new ConfirmationDialogFragment();
    dialog.show(getSupportFragmentManager(), "чат");


}
