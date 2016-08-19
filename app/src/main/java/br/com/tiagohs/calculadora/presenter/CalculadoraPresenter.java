package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.util.OperationType;
import br.com.tiagohs.calculadora.view.CalculadoraView;

/**
 * Created by Tiago Henrique on 14/08/2016.
 */
public interface CalculadoraPresenter {

    void setView(CalculadoraView view);
    void apagarUltimoValorInputPrincipal(String valorAtual);
    void onCheckKeyboard(String novoValor, String displayAtual);
    void onCheckOperador(OperationType operationType, String displayAtual);
    void onCheckResult(String displayAtual);
    void onCheckOperadorEspecial(OperationType operacaoEspecial, String displayAtual);
    void apagarTudo(String valorAtual, String valorSubAtual);
}
