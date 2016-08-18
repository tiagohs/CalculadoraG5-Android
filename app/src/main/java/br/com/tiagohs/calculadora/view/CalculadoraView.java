package br.com.tiagohs.calculadora.view;

import android.view.View;

/**
 * Created by Tiago Henrique on 07/08/2016.
 */
public interface CalculadoraView {

    void apagarUltimaValor();
    void displayInputPrincipal(String valor);
    void displayInputSecundario(String valor);
    void onClickKeyBoard(View view);
    void onClickOperador(View view);
    void onClickEquals();
}
