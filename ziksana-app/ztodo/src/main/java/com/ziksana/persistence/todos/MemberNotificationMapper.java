/**
 * 
 */
package com.ziksana.persistence.todos;

import com.ziksana.domain.todos.MemberNotification;

/**
 * @author
 * 
 */
public interface MemberNotificationMapper {

	public MemberNotification getMemberNotification(long id);

	public MemberNotification selectByNotificationType(int notificationType);

	public void updateMemberNotification(MemberNotification memberNotification);

	public void deleteMemberNotification(int memberNotificationId);

	public void createMemberNotification(MemberNotification memberNotification);

}
