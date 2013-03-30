package com.ziksana.domain.common;

import com.ziksana.id.IntegerZID;
import com.ziksana.id.ZID;

public class Choice implements Comparable<Choice> {

	private ZID id;
	private Integer index;
	private String text;

	private Integer memPstTestId;

	

	/**
	 * @param index
	 * @param text
	 * 
	 */
	public Choice(Integer id, Integer index, String text) {
		super();
		this.id = new IntegerZID(id);
		this.index = index;
		this.text = text;
		
	}
	public Choice(Integer id, Integer index, String text, Integer memPstTestId) {
		super();
		this.id = new IntegerZID(id);
		this.index = index;
		this.text = text;
		this.memPstTestId = memPstTestId;
	}
	
	
	/**
	 * @return the memPstTestId
	 */
	public Integer getMemPstTestId() {
		return memPstTestId;
	}

	/**
	 * @param memPstTestId
	 *            the memPstTestId to set
	 */
	public void setMemPstTestId(Integer memPstTestId) {
		this.memPstTestId = memPstTestId;
	}
	
	
	

	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	
	@Override
	public int compareTo(Choice o) {
		
		return Integer.valueOf(index).compareTo(Integer.valueOf(o.index));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Choice other = (Choice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
