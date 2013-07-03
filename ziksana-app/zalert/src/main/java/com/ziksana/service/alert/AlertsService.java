/**
 * 
 */
package com.ziksana.service.alert;

import java.util.List;

import com.ziksana.domain.alerts.Alert;

/**
 * @author prabu
 *
 */
public interface AlertsService {
	
	public List<Alert>  getAlertList();
	
	List<Alert> getMapperAlerts();
	
	public void createAlertItem( Alert alertItem);
	
	public void editAlertItem( Alert alertItem);
	
	public void deleteAlertItem(Integer alertId);
	

}
