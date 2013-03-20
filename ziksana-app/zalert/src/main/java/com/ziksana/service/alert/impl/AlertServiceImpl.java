/**
 * 
 */
package com.ziksana.service.alert.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziksana.domain.alerts.Alert;
import com.ziksana.persistence.alert.AlertMapper;
import com.ziksana.security.util.ThreadLocalUtil;
import com.ziksana.service.alert.AlertsService;

/**
 * @author prabu
 * 
 */
@Service
public class AlertServiceImpl implements AlertsService {

	@Autowired
	public AlertMapper alertMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ziksana.service.alert.AlertsService#getAlertList()
	 */
	@Override
	public List<Alert> getAlertList() {
		
		List<Alert> alertList = new ArrayList<Alert>();
		
		alertList = alertMapper.getAlerts(Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID()));
		
		return alertList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.alert.AlertsService#createAlertItem(com.ziksana.domain
	 * .alerts.Alert)
	 */
	@Override
	public void createAlertItem(Alert AlertItem) {

		alertMapper.createAlert(AlertItem);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.alert.AlertsService#editAlertItem(com.ziksana.domain
	 * .alerts.Alert)
	 */
	@Override
	public void editAlertItem(Alert AlertItem) {
		alertMapper.updateAlert(AlertItem);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ziksana.service.alert.AlertsService#deleteAlertItem(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public void deleteAlertItem(Integer alertId) {
		alertMapper.deleteAlert(alertId);
	}

	@Override
	public List<Alert> getMapperAlerts() {
		// TODO Auto-generated method stub

				Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken()
						.getMemberPersonaId().getStorageID());
				int offset = 0;
				int limit = 3;
				RowBounds rowBounds = new RowBounds(offset, limit);
				return alertMapper.getMapperAlerts(memberRoleId, rowBounds);
	}

}
