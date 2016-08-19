package br.com.tiagohs.calculadora.interactor;

import android.util.Log;

import br.com.tiagohs.calculadora.model.Equacao;
import br.com.tiagohs.calculadora.service.CalculadoraService;
import br.com.tiagohs.calculadora.service.CalculadoraServiceImpl;
import br.com.tiagohs.calculadora.util.EquacaoVariavelInexistenteException;
import br.com.tiagohs.calculadora.util.SintaxeEquacaoIncorretaException;

public class CalculadoraInteractorImpl implements CalculadoraInteractor {
    private static final String TAG = CalculadoraInteractorImpl.class.getSimpleName();

    CalculadoraService mCalculadoraService;

    public CalculadoraInteractorImpl() {
        mCalculadoraService = new CalculadoraServiceImpl();
    }

    @Override
    public void calcular(String funcao, OnCalculadoraListener listener) {

        try {
            Equacao equacao = new Equacao(funcao);
            double result = equacao.evaluate();
            listener.onCalculatorSucess(result);
            Log.i(TAG, "Result: " + result);
        } catch (SintaxeEquacaoIncorretaException e) {
            Log.e(TAG, "Função com Sintaxe Incorreta: " + funcao);
            listener.onCalculatorError();
        } catch (EquacaoVariavelInexistenteException e) {
            Log.e(TAG, "Função com Variavel inexistente: " + funcao);
            listener.onCalculatorError();
        }
    }

}
