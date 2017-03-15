package com.example.user.travelhelper;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Countries [] страны;
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
                return false;
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.START);
                break;
            }
        });
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

}
