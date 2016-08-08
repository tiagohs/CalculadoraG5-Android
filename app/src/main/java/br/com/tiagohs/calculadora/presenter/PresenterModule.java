package br.com.tiagohs.calculadora.presenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    public InputPresenter providesInputPresenter() {
        return new InputPresenterImpl();
    }

    @Provides
    public KeyboardPresenter providesKeyboardPresenter() {
        return new KeyboardPresenterImpl();
    }

    @Provides
    public OperacoesEspeciaisPresenter providesOperacoesEspeciaisPresenter() {
        return new OperacoesEspeciaisPresenterImpl();
    }
}
