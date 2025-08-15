package com.bookapi.pojo.response;

public class Detail {
	
	private String detail;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	  
	    public String toString() {
	        return "{\n" +
	               "  \"detail\": \"" + detail + "\"\n" +
	               "}";
	    }

}
