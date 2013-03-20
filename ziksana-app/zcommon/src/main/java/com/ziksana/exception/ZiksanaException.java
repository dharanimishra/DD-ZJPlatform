package com.ziksana.exception;

import com.ziksana.util.MessageUtil;

public class ZiksanaException extends RuntimeException {

	
	private static final long serialVersionUID = -8021176035004246465L;

	private String errorCode;

	  private Object[] args;

	  
	  public ZiksanaException(String errorCode)
	  {
	    this(errorCode, null, null);
	  }

	   
	  public ZiksanaException(String errorCode, Object[] args)
	  {
	    this(errorCode, args, null);
	  }

	  
	  public ZiksanaException(String errorCode, Throwable t)
	  {
	    this(errorCode, null, t);
	  }

	  
	  public ZiksanaException(String errorCode, Object[] args, Throwable t)
	  {
	    super(MessageUtil.getMessage(errorCode, args), t);
	    this.errorCode = errorCode;
	    this.args = args;
	  }

	  /**
	   * @return the errorCode
	   */
	  public String getErrorCode()
	  {
	    return errorCode;
	  }

	  /**
	   * @return the arguments
	   */
	  public Object[] getArgs()
	  {
	    return args;
	  }

}
