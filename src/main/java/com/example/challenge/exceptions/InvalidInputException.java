/**
 * 
 */
package com.example.challenge.exceptions;

/**
 * @author lfhernandez
 *
 */
public class InvalidInputException extends RuntimeException {


    /**
	 * 
	 */
	private static final long serialVersionUID = -5841005628060711226L;
	private int errorCode;
    private String errorMessage;

    public InvalidInputException(Throwable throwable) {
        super(throwable);
    }

    public InvalidInputException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public InvalidInputException(String msg) {
        super(msg);
    }

    public InvalidInputException(String message, int errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }


    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return this.errorCode + " : " + this.getErrorMessage();
    }
}
