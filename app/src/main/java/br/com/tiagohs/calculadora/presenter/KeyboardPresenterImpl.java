package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.view.KeyboardView;

/**
 * Created by Tiago Henrique on 07/08/2016.
 */
public class KeyboardPresenterImpl implements KeyboardPresenter {
    private KeyboardView keyboardView;

    @Override
    public String onClickKeyboard(String value) {
        return value;
    }

    @Override
    public String onClickOperador(String value) {

        return value;
    }

    @Override
    public void setView(KeyboardView view) {
        this.keyboardView = view;
    }

    public void setKeyboardView(KeyboardView keyboardView) {
        this.keyboardView = keyboardView;
    }
}
