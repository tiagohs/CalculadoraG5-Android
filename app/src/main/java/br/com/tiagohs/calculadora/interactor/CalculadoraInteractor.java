package br.com.tiagohs.calculadora.interactor;

public interface CalculadoraInteractor {

    interface OnCalculadoraListener {
        void onCalculatorSucess(Double result);
        void onCalculatorError();
    }

    void calcular(String funcao, OnCalculadoraListener listener);
}
