package br.com.tiagohs.calculadora.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.tiagohs.calculadora.R;
import butterknife.BindView;

public class CalculadoraActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Nullable
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Nullable
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(mToolbar);

        configurarDrawerLayout();
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_calculadora;
    }

    private void configurarDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_conversoes) {
            // Handle the camera action
        } else if (id == R.id.menu_fracoes) {

        } else if (id == R.id.menu_graficos) {

        } else if (id == R.id.menu_matrizes) {

        } else if (id == R.id.menu_opcoes) {

        } else if (id == R.id.menu_polinomios) {

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
