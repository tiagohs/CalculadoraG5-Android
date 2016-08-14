package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.view.CalculadoraView;

/**
 * Created by Tiago Henrique on 14/08/2016.
 */
public class CalculadoraPresenterImpl implements CalculadoraPresenter {
    private CalculadoraView view;

    @Override
    public void setView(CalculadoraView view) {
        this.view = view;
    }

    @Override
    public void apagarUltimoValorInputPrincipal(String valorAtual) {
        if (containsValores(valorAtual))
            view.displayInputPrincipal(valorAtual.substring(0, valorAtual.length() - 1));
        else
            view.displayInputPrincipal("");
    }

    private boolean containsValores(String valorAtual) {
        return valorAtual != null || !valorAtual.isEmpty();
    }

    @Override
    public void onClickKeyboard(String value) {
        view.displayInputPrincipal(value);
    }

    @Override
    public void onClickOperador(String value) {

    }
}
