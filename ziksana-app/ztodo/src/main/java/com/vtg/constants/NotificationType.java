/**
 * 
 */
package com.vtg.constants;

/**
 * @author Ratnesh
 * 
 */
public enum NotificationType {

	ALERT(101), TODO(102), FYI(103), PENALTY(104);

	private int notificationType;

	private NotificationType(int type) {
		notificationType = type;
	}

	public int getNotificationType() {
		return notificationType;
	}

}
