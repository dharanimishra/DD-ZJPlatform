/**
 * 
 */
package com.vtg.service;

import java.util.Collection;

import com.vtg.model.MemberNotification;

/**
 * @author
 * 
 */
public interface MemberNotificationService {

	public Collection<MemberNotification> selectAll();

	public MemberNotification selectById(int id);

	public void update(MemberNotification memberNotification) throws Exception;

	public void delete(int memberNotificationId) throws Exception;

	public void insert(MemberNotification category);

}
