package com.ziksana.service.alert.impl;

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

	/**
	 * get alert list
	 */
	public List<Alert> getAlertList() {

		List<Alert> alertList = null;
		alertList = alertMapper.getAlerts(Integer.valueOf(ThreadLocalUtil
				.getToken().getMemberPersonaId().getStorageID()));

		return alertList;
	}

	public void createAlertItem(Alert AlertItem) {

		alertMapper.createAlert(AlertItem);

	}

	public void editAlertItem(Alert AlertItem) {
		alertMapper.updateAlert(AlertItem);

	}

	public void deleteAlertItem(Integer alertId) {
		alertMapper.deleteAlert(alertId);
	}

	public List<Alert> getMapperAlerts() {
		Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID());
		int offset = 0;
		int limit = 3;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return alertMapper.getMapperAlerts(memberRoleId, rowBounds);
	}

}
