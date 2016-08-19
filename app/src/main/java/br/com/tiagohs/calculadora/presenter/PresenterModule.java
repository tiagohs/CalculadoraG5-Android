package br.com.tiagohs.calculadora.presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    public CalculadoraPresenter providesCalculadoraPresenter() {
        return new CalculadoraPresenterImpl();
    }

}
