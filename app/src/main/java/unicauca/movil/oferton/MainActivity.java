package unicauca.movil.oferton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import unicauca.movil.oferton.databinding.ActivityMainBinding;
import unicauca.movil.oferton.fragments.MainFragment;
import unicauca.movil.oferton.util.Preference;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;
    int content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle =  new ActionBarDrawerToggle(this, binding.drawer, R.string.open_menu
                , R.string.close_menu);
        binding.drawer.addDrawerListener(this);
        binding.nav.setNavigationItemSelectedListener(this);

        content = R.id.nav_home;
        if(savedInstanceState != null){
            content = savedInstanceState.getInt("content");
        }
        setContent(content);
    }

    //region Toggle setup
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }
    //endregion

    //region Navigation View
    public void putFragment(int container, Fragment fragment){
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawer.closeDrawers();
        setContent(item.getItemId());
        return false;
    }

    void setContent(int navItem){
        content = navItem;
        switch (navItem){
            case R.id.nav_home:
                getSupportActionBar().setTitle(R.string.novedades);
                putFragment(R.id.container, MainFragment.instance());
                break;
            case R.id.nav_almacenes:
                getSupportActionBar().setTitle(R.string.nav_almacenes);
                putFragment(R.id.container, MainFragment.instance());
                break;

            case R.id.nav_deportes:
                getSupportActionBar().setTitle(R.string.nav_deportes);
                putFragment(R.id.container, MainFragment.instance());
                break;
            case R.id.nav_ropa:
                getSupportActionBar().setTitle(R.string.nav_ropa);
                putFragment(R.id.container, MainFragment.instance());
                break;
            case R.id.nav_comida:
                getSupportActionBar().setTitle(R.string.nav_comida);
                putFragment(R.id.container, MainFragment.instance());
                break;
            case R.id.nav_electrodomesticos:
                getSupportActionBar().setTitle(R.string.nav_electrodomesticos);
                putFragment(R.id.container, MainFragment.instance());
                break;
            case R.id.nav_cine:
                getSupportActionBar().setTitle(R.string.nav_cine);
                putFragment(R.id.container, MainFragment.instance());
                break;
            case R.id.nav_logout:
                SharedPreferences preferences =  getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor =  preferences.edit();
                editor.putBoolean(Preference.KEY_LOGGED, false);
                editor.apply();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("content", content);
        super.onSaveInstanceState(outState);
    }
    //endregion
}
