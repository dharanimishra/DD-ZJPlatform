package com.ziksana.domain.common;
import com.ziksana.domain.common.Header;

public class Header {

	private String token;
	private String codeError;
	private String msgType;
	private String controllerName;

	public static Header getHeader(String controller) {
		// Creating ziksana message header
		Header header = new Header();

//		String token = ThreadLocalUtil.getToken().getMemberPersonaId()
//				.getStorageID().toString();

		// Setting the controller and token
		header.setControllerName(controller);
		//header.setToken(token);
		return header;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
}
