package cn.dolphinsoft.glance.dto;

import java.io.Serializable;

public class ResultDto implements Serializable {

	private static final long serialVersionUID = -860348231882815868L;

	private String code;

	private String message;

	private Object data;

	public ResultDto(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

}
