package com.qunhe.exception;

/**
 * @author: duiliu
 * @date 2019/7/22
 */
public class NotFoundRightBracketException extends Exception {

	public NotFoundRightBracketException() {
	}

	public NotFoundRightBracketException(String msg) {
		super(msg);
	}

	public NotFoundRightBracketException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
