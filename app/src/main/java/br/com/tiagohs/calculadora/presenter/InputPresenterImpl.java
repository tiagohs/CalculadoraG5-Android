package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.view.InputView;

public class InputPresenterImpl implements InputPresenter {
    private InputView view;

    @Override
    public void setView(InputView view) {
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
}
