package br.com.tiagohs.calculadora.service;

import java.math.BigDecimal;

public interface CalculadoraService {

    //Operações Básicas
    BigDecimal operacaodeSoma(BigDecimal valor1, BigDecimal valor2);
    BigDecimal operacaodeSubtracao(BigDecimal valor1, BigDecimal valor2);
    BigDecimal operacaodeMultiplicacao(BigDecimal valor1, BigDecimal valor2);
    BigDecimal operacaodeDivisao(BigDecimal valor1, BigDecimal valor2);

    //Operações sem Calculo
    BigDecimal calcularPI();
    BigDecimal changeSinal(BigDecimal valor);
    BigDecimal valorEuler();

    //Outras Operações
    BigDecimal calcularElevadoAoCubo(BigDecimal valor);
    BigDecimal calcularElevadoAoQuadrado(BigDecimal valor);
    BigDecimal calcularFatorial(BigDecimal n, BigDecimal acc);
    BigDecimal calcularDms(BigDecimal valor);
    BigDecimal calcularDezElevadoX(BigDecimal valor);
    BigDecimal calcularLog(BigDecimal valor);
    BigDecimal calcularLn(BigDecimal valor);
    BigDecimal calcularRaizQuadrada(BigDecimal valor1);
    BigDecimal calcularResto(BigDecimal valor, BigDecimal divisor);
    BigDecimal calcularElevadoY(BigDecimal valor, BigDecimal elevado);
    BigDecimal calcularRaizQuadradoY(BigDecimal valor, BigDecimal yRoot);
    BigDecimal calcularUnder(BigDecimal valor);

    //Trigonometria
    BigDecimal calcularCosseno(Double valor) throws NumberFormatException;
    BigDecimal calcularArcoCosseno(Double valor) throws NumberFormatException;
    BigDecimal calcularSecante(Double valor) throws NumberFormatException;
    BigDecimal calcularSeno(Double valor) throws NumberFormatException;
    BigDecimal calcularArcoSeno(Double valor) throws NumberFormatException;
    BigDecimal calcularCossecante(Double valor) throws NumberFormatException;
    BigDecimal calcularTangente(Double valor) throws NumberFormatException;
    BigDecimal calcularArcoTangente(Double valor) throws NumberFormatException;
    BigDecimal calcularCotangente(Double valor) throws NumberFormatException;

    //Outros
    BigDecimal calcularRegraTres(BigDecimal valorA, BigDecimal valorB, BigDecimal valorC) throws NumberFormatException;
}
