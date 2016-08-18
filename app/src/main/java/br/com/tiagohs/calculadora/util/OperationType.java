package br.com.tiagohs.calculadora.util;

/**
 * Created by Tiago Henrique on 17/08/2016.
 */
public enum OperationType {
    SOMA("+"), SUBTRACAO("-"), MULTIPLICACAO("*"), DIVISAO(KeyBoardUtils.getSymbolSpecial("&#247;").toString());

    private String symbol;

    OperationType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
