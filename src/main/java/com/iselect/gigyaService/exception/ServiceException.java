package com.iselect.gigyaService.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ServiceException extends Exception {

	/** For serialization. */
	private static final long serialVersionUID = -1216910783316403998L;
	private Logger logger = LoggerFactory.getLogger(ServiceException.class);
	
	/**
	 * Constructs a new exception with <code>null</code> as its detail message. The cause
	 * is not initialized, and may subsequently be initialized by a call to
	 * {@link #initCause}.
	 */
	public ServiceException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message. The cause is not
	 * initialized, and may subsequently be initialized by a call to {@link #initCause}.
	 *
	 * @param message the detail message. The detail message is saved for later retrieval
	 *            by the {@link #getMessage()} method.
	 */
	public ServiceException(final String message) {		
		super(message);
		logger.error(message);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * <p>
	 * Note that the detail message associated with <code>cause</code> is <i>not</i>
	 * automatically incorporated in this exception's detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *            {@link #getMessage()} method).
	 * @param cause the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is permitted, and
	 *            indicates that the cause is nonexistent or unknown.)
	 * @since 1.4
	 */
	public ServiceException(final String message, final Throwable cause) {		
		super(message, cause);
		logger.error(message);
	}

	/**
	 * Constructs a new exception with the specified cause and a detail message of
	 * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the
	 * class and detail message of <tt>cause</tt>). This constructor is useful for
	 * exceptions that are little more than wrappers for other throwables (for example,
	 * {@link java.security.PrivilegedActionException}).
	 *
	 * @param cause the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is permitted, and
	 *            indicates that the cause is nonexistent or unknown.)
	 * @since 1.4
	 */
	public ServiceException(final Throwable cause) {
		super(cause);
		logger.error(cause.toString());
	}
}
