package com.example.heisenberg.pocket_rgpv;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusBEPTDC;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusBachArchitechture;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusBachEngineering;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusBachPharma;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusDDIPG;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusDiploma;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusMAMDualDegree;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusMCADualDegree;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusMasComputerApplication;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusMasEngineering;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusMasPharma;
import com.example.heisenberg.pocket_rgpv.FragementSyllabus.SyllabusMasTechnology;

public class Syllabus extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        setTitle("Syllabus");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSyllabus);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.syllabus_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_syllabus);
        navigationView.setNavigationItemSelectedListener(this);

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.nav_bach_engineering);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.syllabus_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_bach_engineering:
                fragment = new SyllabusBachEngineering();
                setTitle("B.E.");
                break;
            case R.id.nav_bach_pharmacy:
                fragment = new SyllabusBachPharma();
                setTitle("B.Pharma");
                break;
            case R.id.nav_diploma:
                fragment = new SyllabusDiploma();
                setTitle("Diploma");
                break;
            case R.id.nav_mas_comptuer_application:
                fragment = new SyllabusMasComputerApplication();
                setTitle("MCA");
                break;
            case R.id.nav_mas_engineering:
                fragment = new SyllabusMasEngineering();
                setTitle("M.E.");
                break;
            case R.id.nav_mas_pharmacy:
                fragment = new SyllabusMasPharma();
                setTitle("M.Pharma");
                break;
            case R.id.nav_be_ptdc:
                fragment = new SyllabusBEPTDC();
                setTitle("BE-PTDC");
                break;
            case R.id.nav_bach_architechture:
                fragment = new SyllabusBachArchitechture();
                setTitle("B.Arch");
                break;
            case R.id.nav_ddi_pg:
                fragment = new SyllabusDDIPG();
                setTitle("DDI-PG");
                break;
            case R.id.nav_mas_technology_part_time:
                fragment = new SyllabusMasTechnology();
                setTitle("M.Tech (Part Time)");
                break;
            case R.id.nav_mam_dual_degree:
                fragment = new SyllabusMAMDualDegree();
                setTitle("MAM Dual Degree");
                break;
            case R.id.nav_mca_dual_degree:
                fragment = new SyllabusMCADualDegree();
                setTitle("MCA Dual Degree");
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_syllabus, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.syllabus_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }
}