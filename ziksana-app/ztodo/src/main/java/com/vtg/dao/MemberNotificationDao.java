/**
 * 
 */
package com.vtg.dao;

import java.util.Collection;

import com.vtg.model.MemberNotification;

/**
 * @author
 * 
 */
public interface MemberNotificationDao {

	public Collection<MemberNotification> selectAll();

	public MemberNotification selectById(long id);

	public MemberNotification selectByNotificationType(int notificationType);

	public void update(MemberNotification memberNotification);

	public void delete(int memberNotificationId);

	public void insert(MemberNotification memberNotification);

}
