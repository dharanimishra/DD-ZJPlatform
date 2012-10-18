/**
 * 
 */
package com.ziksana.service.alert.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ziksana.domain.alerts.Alert;
import com.ziksana.persistence.alert.AlertMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.alert.AlertsService;

/**
 * @author prabu
 *
 */
public class AlertServiceImpl implements AlertsService {
	
	
	@Autowired
	public AlertMapper alertMapper;

	/* (non-Javadoc)
	 * @see com.ziksana.service.alert.AlertsService#getAlertList()
	 */
	@Override
	public List<Alert> getAlertList() {
		// TODO Auto-generated method stub
		int notificationType = 1000;
		return alertMapper.getAlerts( Integer.valueOf(notificationType), Integer.valueOf(ThreadLocalUtil.getToken().getMemberPersonaId().getStorageID()));
	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.alert.AlertsService#createAlertItem(com.ziksana.domain.alerts.Alert)
	 */
	@Override
	public void createAlertItem(Alert AlertItem) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.alert.AlertsService#editAlertItem(com.ziksana.domain.alerts.Alert)
	 */
	@Override
	public void editAlertItem(Alert AlertItem) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ziksana.service.alert.AlertsService#deleteAlertItem(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void deleteAlertItem(Integer memberId, Integer alertId) {
		// TODO Auto-generated method stub

	}

}
