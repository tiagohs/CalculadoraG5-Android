package br.com.tiagohs.calculadora.presenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    public CalculadoraPresenter providesCalculadoraPresenter() {
        return new CalculadoraPresenterImpl();
    }

}
