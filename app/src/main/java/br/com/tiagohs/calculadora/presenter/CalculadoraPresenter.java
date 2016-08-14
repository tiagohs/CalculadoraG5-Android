package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.view.CalculadoraView;

/**
 * Created by Tiago Henrique on 14/08/2016.
 */
public interface CalculadoraPresenter {

    void setView(CalculadoraView view);
    void apagarUltimoValorInputPrincipal(String valorAtual);
    void onClickKeyboard(String value);
    void onClickOperador(String value);
}
