/**
 * 
 */
package com.ziksana.persistence.data;

import java.util.List;

import com.ziksana.domain.utils.NameValue;

/**
 * @author Ratnesh Kumar
 *
 */
public interface EnumStaticDataMapper {
	
	public List<NameValue> fetchData(String category);

}
