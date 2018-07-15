package com.story.web.dto;

import java.io.Serializable;

/**
 * 通用数据传输对象
 * @author suihonghua
 *
 * @param <T>
 */
public class CommonDto<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 异常编码  **/
	public static final int CODE_EXCEPTION = 0;
	/** 正常编码  **/
	public static final int CODE_NORMAL = 1;
	/** 警告编码  **/
	public static final int CODE_WARN = 2;

	public static final int CODE_TWO_WAY_CONFIRM = 10;
	
	private T data;
	
	private int code;
	
	private String message;
	
	public CommonDto(){
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

