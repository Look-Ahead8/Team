package com.team.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 閫氱敤鐨勮繑鍥炵殑绫�
 * 
 * @author lfy
 * 
 */
public class Msg {
	
	private int state;
	
	private String message;
	
	
	private Map<String, Object> extend = new HashMap<String, Object>();

	public static Msg success(){
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("执行成功");
		return result;
	}
	
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("执行失败");
		return result;
	}
	
	public Msg add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	public int getCode() {
		return state;
	}

	public void setCode(int code) {
		this.state = code;
	}

	public String getMsg() {
		return message;
	}

	public void setMsg(String msg) {
		this.message = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
	
}
