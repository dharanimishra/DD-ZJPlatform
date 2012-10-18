package com.ziksana.persistence.alert;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ziksana.domain.alerts.Alert;

public interface AlertMapper {

	@Select({ "select", "membernotificationid as ID,",
			"NotificationContent as description,", "completeby,",
			"memmembernotification.*", " from ", "memmembernotification ",
			" where ", " NotificationType=#{notificationType} and ", " formemberroleid=#{userMemberRoleId} " })
	List<Alert> getAlerts(Integer userMemberRoleId, Integer notificationType);

}
