package br.com.tiagohs.calculadora;

import android.app.Application;

/**
 * Created by Tiago Henrique on 07/08/2016.
 */
public class App extends Application {
    CalculadoraComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerCalculadoraComponent.builder().build();
    }

    public CalculadoraComponent getComponent() {
        return component;
    }
}
