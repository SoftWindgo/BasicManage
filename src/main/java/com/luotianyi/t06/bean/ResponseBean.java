package com.luotianyi.t06.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseBean implements Serializable{
	private int code;
	private String message;
	private Object data;

	private ResponseBean() {
		super();
	}

	public static ResponseBean getResponseBean(int code, String message, Object data) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setCode(code);
		responseBean.setMessage(message);
		responseBean.setData(data);
		return responseBean;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseBean [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

}
