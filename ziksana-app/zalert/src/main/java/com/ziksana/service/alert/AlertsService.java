/**
 * 
 */
package com.ziksana.service.alert;

import java.util.List;

import com.ziksana.domain.member.MemberPersona;
import com.ziksana.domain.alerts.Alert;

/**
 * @author prabu
 *
 */
public interface AlertsService {
	
	public List<Alert>  getAlertList();
	
	public void createAlertItem( Alert AlertItem);
	
	public void editAlertItem( Alert AlertItem);
	
	public void deleteAlertItem(Integer alertId);
	

}
