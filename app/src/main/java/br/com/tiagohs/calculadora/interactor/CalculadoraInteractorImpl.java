package br.com.tiagohs.calculadora.interactor;

import android.util.Log;

import java.math.BigDecimal;

import br.com.tiagohs.calculadora.service.CalculadoraService;
import br.com.tiagohs.calculadora.service.CalculadoraServiceImpl;
import br.com.tiagohs.calculadora.util.OperationType;

public class CalculadoraInteractorImpl implements CalculadoraInteractor {
    private static final String TAG = CalculadoraInteractorImpl.class.getSimpleName();

    CalculadoraService mCalculadoraService;

    public CalculadoraInteractorImpl() {
        mCalculadoraService = new CalculadoraServiceImpl();
    }

    public void calcular(BigDecimal valor1, BigDecimal valor2, OperationType operacao, OnCalculadoraListener listener) {

        try {
            switch (operacao) {
                case SOMA:
                    listener.onCalculatorSucess(mCalculadoraService.operacaodeSoma(valor1, valor2));
                    break;
                case SUBTRACAO:
                    listener.onCalculatorSucess(mCalculadoraService.operacaodeSubtracao(valor1, valor2));
                    break;
                case MULTIPLICACAO:
                    listener.onCalculatorSucess(mCalculadoraService.operacaodeMultiplicacao(valor1, valor2));
                    break;
                case DIVISAO:
                    listener.onCalculatorSucess(mCalculadoraService.operacaodeDivisao(valor1, valor2));
                    break;
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "Não é aceito valores vazios.", e);
            listener.onCalculatorError();
        }

    }

    public void calcular(BigDecimal valor, OperationType operacao, OnCalculadoraListener listener) {

    }
}
