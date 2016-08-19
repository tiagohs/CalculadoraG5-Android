package br.com.tiagohs.calculadora.service;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface CalculadoraService {

    BigDecimal calcularRegraTres(BigDecimal valorA, BigDecimal valorB, BigDecimal valorC);
    boolean isPrimo(BigInteger valor);
    BigDecimal calcularFatorial(BigDecimal n, BigDecimal acc);
    BigDecimal calcularDms(BigDecimal valor);
}
