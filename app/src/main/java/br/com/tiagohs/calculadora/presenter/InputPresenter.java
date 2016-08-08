package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.view.InputView;

public interface InputPresenter {

    void setView(InputView view);
    void apagarUltimoValorInputPrincipal(String valorAtual);
}
