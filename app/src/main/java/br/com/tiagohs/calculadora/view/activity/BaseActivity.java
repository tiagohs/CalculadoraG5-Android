package br.com.tiagohs.calculadora.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        injectViews();
    }

    private void injectViews() {
        ButterKnife.bind(this);
    }

    protected abstract int getActivityLayout();
}
