package br.com.tiagohs.calculadora.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import br.com.tiagohs.calculadora.R;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_container);

        if (fragment == null) {
            fragmentManager.beginTransaction()
                                            .add(R.id.activity_container, createFragment())
                                            .commit();
        }

        injectViews();
    }

    private void injectViews() {
        ButterKnife.bind(this);
    }

    protected abstract Fragment createFragment();
}
