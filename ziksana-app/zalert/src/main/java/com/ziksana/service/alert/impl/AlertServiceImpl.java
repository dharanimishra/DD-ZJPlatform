
package com.ziksana.service.alert.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Service;

import com.ziksana.alert.exception.AlertException;
import com.ziksana.constants.ZiksanaConstants;
import com.ziksana.domain.alerts.Alert;
import com.ziksana.exception.DataBaseException;
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
	@Override
	public List<Alert> getAlertList() {
		
		List<Alert> alertList = new ArrayList<Alert>();
		try{
		alertList = alertMapper.getAlerts(Integer.valueOf(ThreadLocalUtil.getToken()
				.getMemberPersonaId().getStorageID()));
		}
		catch (CannotGetJdbcConnectionException dae) {
			throw new DataBaseException(dae);
		}
		catch(NullPointerException ne){
			throw new AlertException(ZiksanaConstants.ZIKSANA_OBJECT_NULL);
		}
		if(alertList.isEmpty()){
			throw new AlertException(ZiksanaConstants.ALERT_NOT_FOUND);
		}
		
		return alertList;
	}
	
	
	@Override
	public void createAlertItem(Alert AlertItem) {

		alertMapper.createAlert(AlertItem);

	}

	
	@Override
	public void editAlertItem(Alert AlertItem) {
		alertMapper.updateAlert(AlertItem);

	}

	
	@Override
	public void deleteAlertItem(Integer alertId) {
		try{
		alertMapper.deleteAlert(alertId);
		}
		catch(NullPointerException ne){

			throw new AlertException(ZiksanaConstants.ZIKSANA_OBJECT_NULL);
		}
		catch (CannotGetJdbcConnectionException dae) {
			throw new DataBaseException(dae);
		}
		catch(MyBatisSystemException mye){
			throw new AlertException(ZiksanaConstants.ALERT_ITEMID_NOTFOUND, mye);
		}
	}

	@Override
	public List<Alert> getMapperAlerts() {
		// TODO Auto-generated method stub
				try{
				Integer memberRoleId = Integer.valueOf(ThreadLocalUtil.getToken()
						.getMemberPersonaId().getStorageID());
				int offset = 0;
				int limit = 3;
				RowBounds rowBounds = new RowBounds(offset, limit);
				return alertMapper.getMapperAlerts(memberRoleId, rowBounds);
				}
				catch(NullPointerException ae){
					throw new AlertException(ZiksanaConstants.ALERT_IS_NULL);
				}
				catch (CannotGetJdbcConnectionException dae) {
					throw new DataBaseException(dae);
				}
	}

}
