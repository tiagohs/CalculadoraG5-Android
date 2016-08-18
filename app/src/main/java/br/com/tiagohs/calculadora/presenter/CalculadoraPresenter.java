package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.util.OperationType;
import br.com.tiagohs.calculadora.view.CalculadoraView;

/**
 * Created by Tiago Henrique on 14/08/2016.
 */
public interface CalculadoraPresenter {

    void setView(CalculadoraView view);
    void apagarUltimoValorInputPrincipal(String valorAtual);
    void onCheckOperation(String displayAtual, String displaySub, OperationType operacaoAtual);
    void onCheckKeyboard(String novoValor, String valorAtual);
    void onCheckResult(String displayAtual);
    void apagarTudo(String valorAtual, String valorSubAtual);
}
