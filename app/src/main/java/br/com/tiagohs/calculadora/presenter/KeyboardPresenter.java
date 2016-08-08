package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.view.KeyboardView;

public interface KeyboardPresenter {

    String onClickKeyboard(String value);
    String onClickOperador(String value);
    void setView(KeyboardView view);
}
