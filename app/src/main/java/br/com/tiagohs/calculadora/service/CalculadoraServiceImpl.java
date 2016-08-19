package br.com.tiagohs.calculadora.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;


public class CalculadoraServiceImpl implements CalculadoraService {

    public BigDecimal calcularRegraTres(BigDecimal valorA, BigDecimal valorB, BigDecimal valorC) throws NumberFormatException {
        return (valorB.multiply(valorC)).divide(valorA, MathContext.DECIMAL128);
    }

    public boolean isPrimo(BigInteger valor) {
        return valor.isProbablePrime(1);
    }

    public BigDecimal calcularFatorial(BigDecimal n, BigDecimal acc) {
        if (n.equals(BigDecimal.ONE)) {
            return acc;
        }
        BigDecimal lessOne = n.subtract(BigDecimal.ONE);
        return calcularFatorial(lessOne, acc.multiply(lessOne));
    }

    public BigDecimal calcularDms(BigDecimal valor) {
        BigDecimal in =  valor;
        BigDecimal part = valor.remainder(BigDecimal.ONE);
        BigDecimal numberCem = new BigDecimal(100);
        return (((((in.multiply(numberCem)).divide(numberCem)).add(part)).multiply(new BigDecimal(60))).divide(numberCem));
    }

}
