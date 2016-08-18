package br.com.tiagohs.calculadora.interactor;

import java.math.BigDecimal;

import br.com.tiagohs.calculadora.util.OperationType;

public interface CalculadoraInteractor {

    interface OnCalculadoraListener {
        void onCalculatorSucess(BigDecimal result);
        void onCalculatorError();
    }

    void calcular(BigDecimal valor1, BigDecimal valor2, final OperationType operacao, final OnCalculadoraListener listener);
    void calcular(BigDecimal valor, final OperationType operacao, final OnCalculadoraListener listener);
}
