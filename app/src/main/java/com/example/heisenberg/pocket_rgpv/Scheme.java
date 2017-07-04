package com.example.heisenberg.pocket_rgpv;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeBEPTDC;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeBachArchitechture;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeBachEnginnering;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeBachPharma;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeDDIPG;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeDiploma;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeMAMDualDegree;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeMCADualDegree;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeMasCompApplication;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeMasEngineering;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeMasPharma;
import com.example.heisenberg.pocket_rgpv.FragementScheme.SchemeMasTechnology;
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

import static android.R.attr.permission;

public class Scheme extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int EXTERNAL_STORAGE_PERMISSION_CONSTANT = 100;
    private static final int REQUEST_PERMISSION_SETTING = 101;
    private boolean sentToSettings = false;
    private SharedPreferences permissionStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);

        setTitle("Scheme");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarScheme);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.scheme_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_scheme);
        navigationView.setNavigationItemSelectedListener(this);

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.nav_bach_engineering);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.scheme_drawer_layout);
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
                fragment = new SchemeBachEnginnering();
                setTitle("B.E.");
                break;
            case R.id.nav_bach_pharmacy:
                fragment = new SchemeBachPharma();
                setTitle("B.Pharma");
                break;
            case R.id.nav_diploma:
                fragment = new SchemeDiploma();
                setTitle("Diploma");
                break;
            case R.id.nav_mas_comptuer_application:
                fragment = new SchemeMasCompApplication();
                setTitle("MCA");
                break;
            case R.id.nav_mas_engineering:
                fragment = new SchemeMasEngineering();
                setTitle("M.E.");
                break;
            case R.id.nav_mas_pharmacy:
                fragment = new SchemeMasPharma();
                setTitle("M.Pharma");
                break;
            case R.id.nav_be_ptdc:
                fragment = new SchemeBEPTDC();
                setTitle("BE-PTDC");
                break;
            case R.id.nav_bach_architechture:
                fragment = new SchemeBachArchitechture();
                setTitle("B.Arch");
                break;
            case R.id.nav_ddi_pg:
                fragment = new SchemeDDIPG();
                setTitle("DDI-PG");
                break;
            case R.id.nav_mas_technology_part_time:
                fragment = new SchemeMasTechnology();
                setTitle("M.Tech (Part Time)");
                break;
            case R.id.nav_mam_dual_degree:
                fragment = new SchemeMAMDualDegree();
                setTitle("MAM Dual Degree");
                break;
            case R.id.nav_mca_dual_degree:
                fragment = new SchemeMCADualDegree();
                setTitle("MCA Dual Degree");
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_scheme, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.scheme_drawer_layout);
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