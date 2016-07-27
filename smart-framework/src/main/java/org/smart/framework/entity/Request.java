package org.smart.framework.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 请求的对象
 * @author sunkang
 *
 */
public class Request {
	
	//请求对象的类型，如get，post
	private String requestType;
	
	//请求的路径
	private String requestPath;

	
	
	public Request(String requestType, String requestPath) {
		this.requestType = requestType;
		this.requestPath = requestPath;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}

	
	@Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
	
	
	
	
}
