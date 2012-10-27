package com.ziksana.persistence.alert;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.alerts.Alert;

public interface AlertMapper {

	
	List<Alert> getAlerts(Integer userMemberRoleId);
	void createAlert(Alert alert);
	void updateAlert(Alert alert);
	void deleteAlert(Integer memberNotificationId);

}
