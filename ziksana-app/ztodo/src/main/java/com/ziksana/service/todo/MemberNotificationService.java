/**
 * 
 */
package com.ziksana.service.todo;

import com.ziksana.domain.todos.MemberNotification;

/**
 * @author
 * 
 */
public interface MemberNotificationService {

	public MemberNotification getMemberNotification(long l);

	public void updateMemberNotification(MemberNotification memberNotification);

	public void deleteMemberNotification(int memberNotificationId);

	public void createMemberNotification(MemberNotification category);

}
