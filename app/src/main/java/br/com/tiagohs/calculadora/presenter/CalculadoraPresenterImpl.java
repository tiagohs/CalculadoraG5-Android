package br.com.tiagohs.calculadora.presenter;

import br.com.tiagohs.calculadora.interactor.CalculadoraInteractor;
import br.com.tiagohs.calculadora.interactor.CalculadoraInteractorImpl;
import br.com.tiagohs.calculadora.util.OperationType;
import br.com.tiagohs.calculadora.view.CalculadoraView;

public class CalculadoraPresenterImpl implements CalculadoraPresenter, CalculadoraInteractor.OnCalculadoraListener {
    private CalculadoraView mView;

    CalculadoraInteractor mCalculadoraInteractor;

    private String mFunctionInput;

    public CalculadoraPresenterImpl() {
        mCalculadoraInteractor = new CalculadoraInteractorImpl();
        mFunctionInput = "";
    }

    @Override
    public void setView(CalculadoraView view) {
        this.mView = view;
    }

    @Override
    public void apagarTudo(String valorAtual, String valorSubAtual) {

        if (containsValores(valorAtual) || containsValores(valorSubAtual)) {
            mFunctionInput = "";
            mView.displayInputPrincipal("");
            mView.displayInputSecundario("");
        }
    }

    @Override
    public void apagarUltimoValorInputPrincipal(String valorAtual) {
        if (valorAtual.length() == 1)
            mView.displayInputSecundario("");

        if (containsValores(valorAtual)) {
            mFunctionInput = mFunctionInput.substring(0, valorAtual.length() - 1);
            mView.displayInputSecundario(valorAtual.substring(0, valorAtual.length() - 1));
        } else
            mView.displayInputSecundario("");
    }

    private boolean containsValores(String valorAtual) {
        return !valorAtual.isEmpty() && valorAtual.length() > 0;
    }

    public void onCheckKeyboard(String novoValor, String displayAtual) {
        mView.displayInputSecundario(displayAtual + novoValor);

        mFunctionInput += novoValor;
        mCalculadoraInteractor.calcular(mFunctionInput, this);
    }

    @Override
    public void onCheckOperador(OperationType operationType, String displayAtual) {

        mView.displayInputSecundario(displayAtual + operationType.getSymbolFormatado());
        mFunctionInput += operationType.getSymbol();

        mCalculadoraInteractor.calcular(mFunctionInput, this);
    }

    @Override
    public void onCheckResult(String displayAtual) {

        if (containsValores(displayAtual)) {
            mView.displayInputSecundario("");
        }
    }

    @Override
    public void onCheckOperadorEspecial(OperationType operacaoEspecial, String displayAtual) {

        switch (operacaoEspecial) {
            case CHANGE_SINAL:
                if (containsValores(displayAtual)) {
                    Double valor = -(Double.parseDouble(displayAtual));
                    mView.displayInputPrincipal(valor.toString());
                }
                break;
            case PONTO:
                if (displayAtual.indexOf(".") == -1) {
                    if (displayAtual.length() > 0)
                        mView.displayInputSecundario(displayAtual + ".");
                    else
                        mView.displayInputSecundario(displayAtual + "0.");
                }
                break;
            case PI:
                onCheckKeyboard(Double.toString(Math.PI), displayAtual);
                break;
            case EULER:
                onCheckKeyboard(Double.toString(Math.E), displayAtual);
                break;
        }

    }

    @Override
    public void onCalculatorSucess(Double result) {
        mView.setSucessFormat();
        mView.displayInputPrincipal(result.toString());
    }

    public void onCalculatorError() {
        mView.setErrorFormat();
    }
}
