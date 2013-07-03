package com.ziksana.persistence.alert;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.ziksana.domain.alerts.Alert;

public interface AlertMapper {

	
	List<Alert> getAlerts(Integer userMemberRoleId);
	
	List<Alert> getMapperAlerts(Integer memberRoleId, RowBounds rowBounds);
	void createAlert(Alert alert);
	void updateAlert(Alert alert);
	void deleteAlert(Integer memberNotificationId);

}
