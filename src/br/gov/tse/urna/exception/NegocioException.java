package br.gov.tse.urna.exception;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 3405009433801113285L;
	
	public NegocioException(String message) {
		super(message);
	}
	public NegocioException(String message, Exception exception) {
		super(message, exception);
	}
}