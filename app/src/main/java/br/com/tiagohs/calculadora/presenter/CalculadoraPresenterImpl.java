package br.com.tiagohs.calculadora.presenter;

import android.util.Log;

import java.math.BigDecimal;

import br.com.tiagohs.calculadora.interactor.CalculadoraInteractor;
import br.com.tiagohs.calculadora.interactor.CalculadoraInteractorImpl;
import br.com.tiagohs.calculadora.util.OperationType;
import br.com.tiagohs.calculadora.view.CalculadoraView;

public class CalculadoraPresenterImpl implements CalculadoraPresenter, CalculadoraInteractor.OnCalculadoraListener {
    private CalculadoraView mView;

    CalculadoraInteractor mCalculadoraInteractor;

    private boolean mIsResultado;
    private boolean isContinueCalc;
    private BigDecimal mCurrentNumber;
    private OperationType mOperation;

    public CalculadoraPresenterImpl() {
        mCalculadoraInteractor = new CalculadoraInteractorImpl();
    }

    @Override
    public void setView(CalculadoraView view) {
        this.mView = view;
        this.mIsResultado = false;
        this.isContinueCalc = false;
    }

    @Override
    public void apagarTudo(String valorAtual, String valorSubAtual) {
        mCurrentNumber = null;

        if (containsValores(valorAtual) || containsValores(valorSubAtual)) {
            mView.displayInputPrincipal("");
            mView.displayInputSecundario("");
        }
    }

    @Override
    public void apagarUltimoValorInputPrincipal(String valorAtual) {
        if (valorAtual.length() == 1)
            mView.displayInputSecundario("");

        if (containsValores(valorAtual))
            mView.displayInputPrincipal(valorAtual.substring(0, valorAtual.length() - 1));
        else
            mView.displayInputPrincipal("");
    }

    private boolean containsValores(String valorAtual) {
        return !valorAtual.isEmpty() && valorAtual.length() > 0;
    }

    public void onCheckKeyboard(String novoValor, String valorAtual) {

        if (isContinueCalc) {
            mView.displayInputPrincipal(novoValor);
            isContinueCalc = false;
        } else if (mIsResultado) {
            mView.displayInputPrincipal(valorAtual);
            mIsResultado = false;
        } else {
            String valorResultante = valorAtual + novoValor;
            mView.displayInputPrincipal(valorResultante);
        }

    }

    public void onCheckOperation(String displayAtual, String displaySub, OperationType operacaoAtual) {
        mOperation = operacaoAtual;

        if (isDisplayEmpty(displayAtual)) {
            mView.displayInputSecundario(displayAtual + " " + operacaoAtual.getSymbol() + " ");
            return;
        }

        if (mCurrentNumber == null)
            updateDisplay(displayAtual, displaySub);
        else
            onCalculateAndUpdateDisplay(displayAtual, displaySub);
    }

    private void updateDisplay(String displayAtual, String displaySub) {
        mCurrentNumber = new BigDecimal(displayAtual);
        mView.displayInputPrincipal("");

        if (displaySub.isEmpty())
            mView.displayInputSecundario(mCurrentNumber.toString() + " " + mOperation.getSymbol() + " ");
        else
            mView.displayInputPrincipal(displaySub + " " + mOperation.getSymbol() + " ");

    }

    private void onCalculateAndUpdateDisplay(String displayAtual, String displayAnterior) {
        mView.displayInputSecundario(displayAnterior + " " + displayAtual + " " + mOperation.getSymbol());
        mCalculadoraInteractor.calcular(mCurrentNumber, new BigDecimal(displayAtual), mOperation, this);
        isContinueCalc = true;
    }

    private boolean isDisplayEmpty(String displayAtual) {
        return displayAtual.isEmpty();
    }

    @Override
    public void onCalculatorSucess(BigDecimal result) {
        mCurrentNumber = result;
        mView.displayInputPrincipal(mCurrentNumber.toString());

        if (mIsResultado) {
            mView.displayInputSecundario("");
            mCurrentNumber = null;
            mIsResultado = false;
        }

    }

    public void onCheckResult(String displayAtual) {

        if (containsValores(displayAtual)) {
            Log.i("Prenter", "Entrou");
            mIsResultado = true;
            mCalculadoraInteractor.calcular(mCurrentNumber, new BigDecimal(displayAtual), mOperation, this);
        }
    }

    public void onCalculatorError() {

    }
}
