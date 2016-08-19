package br.com.tiagohs.calculadora.util;

public class EquacaoVariavelInexistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public EquacaoVariavelInexistenteException() {
        super();
    }

    public EquacaoVariavelInexistenteException(final String mensagem, final Throwable causa) {
        super(mensagem, causa);
    }

    public EquacaoVariavelInexistenteException(final String mensagem) {
        super(mensagem);
    }

    public EquacaoVariavelInexistenteException(final Throwable causa) {
        super(causa);
    }
}
