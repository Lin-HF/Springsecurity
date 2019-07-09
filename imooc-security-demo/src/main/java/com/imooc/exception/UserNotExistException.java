/**
 * 
 */
package com.imooc.exception;

/**
 * @author linhaifeng1
 *
 */
public class UserNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6112780192479692859L;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserNotExistException(String id) {
		super("user not exist");
		this.id = id;
	}

}
