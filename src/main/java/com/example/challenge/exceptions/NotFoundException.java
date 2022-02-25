/**
 * 
 */
package com.example.challenge.exceptions;

/**
 * @author lfhernandez
 *
 */
public class NotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1500970941344655842L;
	private int errorCode;
    private String errorMessage;

    public NotFoundException(Throwable throwable) {
        super(throwable);
    }

    public NotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String message, int errorCode) {
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