package com.example.bookameal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    String mTitle[]={
            "Hungry Goose",
            "Cafe Ark",
            "New Lillies",
            "Golf Course",
            "Funnet",
            "Must Sippers",
            "New World Restuarant",
            "Cafe Havana"
    };
    String mDescription[]={
            "Adit mall opp Bank of Uganda,Floor2",
            "Golf course, Redcross",
            "Taso Village @Must",
            "Golf couse Hostel,Boma",
            "Taso Village, @MUST",
            "Mbarara University of Science and Technology (MUST)",
            "Easy View Complex, Mbarara Town",
            "Cafe Havana, Opp Balya Mall"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView=(ListView)findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(this,mTitle,mDescription);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    startActivity(new Intent(HomeActivity.this,RestuarantActivity.class));
                }else{
                    startActivity(new Intent(HomeActivity.this,RestuarantActivity.class));
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_order) {
            Toast.makeText(this, "Not yet Programmed", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
        } else if (id == R.id.nav_donate) {
            startActivity(new Intent(HomeActivity.this,SupportActivity.class));
        } else if (id == R.id.nav_share) {
            startActivity(new Intent(HomeActivity.this,SupportActivity.class));
        } else if (id == R.id.nav_location) {
            startActivity(new Intent(HomeActivity.this,MapsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
