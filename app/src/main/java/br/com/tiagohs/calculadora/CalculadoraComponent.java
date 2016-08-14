package br.com.tiagohs.calculadora;

import javax.inject.Singleton;

import br.com.tiagohs.calculadora.presenter.PresenterModule;
import br.com.tiagohs.calculadora.view.activity.CalculadoraActivity;
import br.com.tiagohs.calculadora.view.fragments.CalculadoraFragment;
import dagger.Component;


@Singleton
@Component(modules = {PresenterModule.class})
public interface CalculadoraComponent {

    void inject(CalculadoraActivity activity);
    void inject(CalculadoraFragment inputFragment);
}
