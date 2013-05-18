/**
 * 
 */
package com.ziksana.service.data;

import java.util.List;
import java.util.Map;

import com.ziksana.domain.utils.UTLLookup;

/**
 * @author Arvind
 * 
 */
public interface UTLLookupService {
	public Map<String, List<UTLLookup>> getUTLLookupMap();
}
