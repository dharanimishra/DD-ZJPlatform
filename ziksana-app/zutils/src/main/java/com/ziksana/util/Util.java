package com.ziksana.util;

import com.ziksana.domain.common.Header;
import com.ziksana.security.util.ThreadLocalUtil;

public class Util {
	
	
	public static  Header getHeader(String controller) {
		// Creating ziksana message header
		Header header = new Header();

		String token = ThreadLocalUtil.getToken().getMemberPersonaId()
				.getStorageID().toString();

		
		// Setting the controller and token
		header.setControllerName(controller);
		header.setToken(token);
		return header;
	}
	
	

}
