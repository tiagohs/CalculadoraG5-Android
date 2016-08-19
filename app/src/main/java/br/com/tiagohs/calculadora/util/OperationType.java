package br.com.tiagohs.calculadora.util;

public enum OperationType {
    SOMA("+", "+"),
    SUBTRACAO("-", "-"),
    MULTIPLICACAO(KeyBoardUtils.getSymbolSpecial("&#215;").toString(), "*"),
    DIVISAO(KeyBoardUtils.getSymbolSpecial("&#247;").toString(), "/"),
    ELEVADO_CUBO("", "^3"),
    ELEVADO_QUADRADO("", "^2"),
    FATORIAL("", ""),
    DMS("", ""),
    DEZ_ELEVADO_X("", "10^"),
    LOG("log(", "log("),
    LN("", ""),
    RAIZ_QUADRADA("sqrt(", "sqrt("),
    RESTO("%", "%"),
    ELEVADO_Y("^", "^"),
    RAIZ_QUADRADA_Y("", ""),
    UNDER("", ""),
    COSSENO("cos(", "cos("),
    ARCO_COSSENO("acos(", "acos("),
    SECANTE("sec(", "sec("),
    SENO("sen(", "sin("),
    ARCO_SENO("asen(", "asin("),
    COSSECANTE("coss(", "coss("),
    TANGENTE("tan(", "tan("),
    ARCO_TANGENTE("atan(", "atan("),
    COTANGENTE("cot(", "cot("),
    CHANGE_SINAL("", "neg"),
    PONTO("", ""),
    EULER("", ""),
    PI("", "");

    private String symbolFormatado;
    private String symbol;

    OperationType(String symbolFormatado, String symbol) {
        this.symbolFormatado = symbolFormatado;
        this.symbol = symbol;
    }

    public String getSymbolFormatado() {
        return symbolFormatado;
    }

    public String getSymbol() {
        return symbol;
    }
}
