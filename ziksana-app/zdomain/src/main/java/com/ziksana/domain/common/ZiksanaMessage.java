package com.ziksana.domain.common;

import java.util.List;

public class ZiksanaMessage<T> {

	private Header header;

	private List<T> content;

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

}
