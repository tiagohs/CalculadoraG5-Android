package br.com.tiagohs.calculadora.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;


public class CalculadoraServiceImpl implements CalculadoraService {

    public BigDecimal calcularPI() {
        return new BigDecimal(Math.PI);
    }

    public BigDecimal changeSinal(BigDecimal valor) {
        return valor.negate();
    }

    public BigDecimal valorEuler() {
        return new BigDecimal(Math.E);
    }

    public BigDecimal calcularRegraTres(BigDecimal valorA, BigDecimal valorB, BigDecimal valorC) throws NumberFormatException {
        return (valorB.multiply(valorC)).divide(valorA, MathContext.DECIMAL128);
    }

    public boolean isPrimo(BigInteger valor) {
        return valor.isProbablePrime(1);
    }

    public BigDecimal calcularElevadoAoCubo(BigDecimal valor) {
        return new BigDecimal(Math.pow(valor.doubleValue(), 3.0));
    }

    public BigDecimal calcularElevadoAoQuadrado(BigDecimal valor) {
        return new BigDecimal(Math.pow(valor.doubleValue(), 2.0));
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

    public BigDecimal calcularDezElevadoX(BigDecimal valor) {
        return new BigDecimal(Math.pow(10.0, valor.doubleValue()));
    }


    public BigDecimal calcularLog(BigDecimal valor) {
        return new BigDecimal(Math.log10(valor.doubleValue()));
    }

    public BigDecimal calcularLn(BigDecimal valor) {
        return new BigDecimal(Math.log(valor.doubleValue()));
    }

    public BigDecimal operacaodeSoma(BigDecimal valor1, BigDecimal valor2) {
        return valor1.add(valor2);
    }

    public BigDecimal operacaodeSubtracao(BigDecimal valor1, BigDecimal valor2) {
        return valor1.subtract(valor2);
    }

    public BigDecimal operacaodeMultiplicacao(BigDecimal valor1, BigDecimal valor2) {
        return valor1.multiply(valor2);
    }

    public BigDecimal operacaodeDivisao(BigDecimal valor1, BigDecimal valor2) {
        return valor1.divide(valor2, MathContext.DECIMAL128);
    }

    public BigDecimal calcularRaizQuadrada(BigDecimal valor1) {
        return new BigDecimal(Math.sqrt(valor1.doubleValue()));
    }

    public BigDecimal calcularResto(BigDecimal valor, BigDecimal divisor) {
        return valor.remainder(divisor);
    }

    public BigDecimal calcularElevadoY(BigDecimal valor, BigDecimal elevado) {
        return new BigDecimal(Math.pow(valor.doubleValue(), elevado.doubleValue()));
    }

    public BigDecimal calcularRaizQuadradoY(BigDecimal valor, BigDecimal yRoot) {
        return new BigDecimal(Math.pow(yRoot.doubleValue(), 1 / valor.doubleValue()));
    }

    public BigDecimal calcularUnder(BigDecimal valor) {
        return BigDecimal.ONE.divide(valor, MathContext.DECIMAL128);
    }

    public BigDecimal calcularCosseno(Double valor) throws NumberFormatException {
        return new BigDecimal(Math.cos(valor));
    }

    public BigDecimal calcularArcoCosseno(Double valor) throws NumberFormatException {
        return new BigDecimal(Math.acos(valor));
    }

    public BigDecimal calcularSecante(Double valor) throws NumberFormatException {
        return new BigDecimal((1 / Math.cos(valor)));
    }

    public BigDecimal calcularSeno(Double valor) throws NumberFormatException {
        return new BigDecimal(Math.sin(valor));
    }

    public BigDecimal calcularArcoSeno(Double valor) throws NumberFormatException {
        return new BigDecimal(Math.asin(valor));
    }

    public BigDecimal calcularCossecante(Double valor) throws NumberFormatException {
        return new BigDecimal((1 / Math.sin(valor)));
    }

    public BigDecimal calcularTangente(Double valor) throws NumberFormatException {
        return new BigDecimal(Math.tan(valor));
    }

    public BigDecimal calcularArcoTangente(Double valor) throws NumberFormatException {
        return new BigDecimal(Math.atan(valor));
    }

    public BigDecimal calcularCotangente(Double valor) throws NumberFormatException {
        return new BigDecimal((1 / Math.tan(valor)));
    }
}
