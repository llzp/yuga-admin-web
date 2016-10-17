package com.yuga.common.entities;

/**
 * 输出前端对象
 * 
 * @author kant
 *
 */
public class KsmDTO{
	
	public KsmDTO(String result, Object data) {
		super();
		this.result = result;
		this.data = data;
	}
		
	public KsmDTO(Object data) {
		if(data != null){
			this.result = "success";
		}else{
			this.result = "failure";
		}
		this.data = data;
	}

	private String result;
	private Object data;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
