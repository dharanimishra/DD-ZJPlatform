package com.ziksana.constants;

/**
 * In Ziksana Constants, use each constant name as Naming convention 
 * eg : <module_name>_<error_name>_<e rror_type>
 * 
 * You can have multiple scenario for each CRUD operation like findById, findByName,
 * upadateByName etc.  e.g.
 * alert.create.failed e.g. alert.retrive.not_found e.g.
 * alert.retrive.not_found_by_date e.g. alert.update.failed e.g.
 * alert.delete.failed.
 * 
 */
public interface ZiksanaConstants {
	
	public static final String COMMON_ERROR_MESSAGE = "ziksana.common.error.message";
	
	//ziksana.common.error.message
	public static final String SYSTEM_EXCEPTION = "SYSTEM";
	public static final String APPLICATION_EXCEPTION = "APPLICATION";
	public static final String DATE_PARSE_ERROR = "ziksana.date.parse.error";

	// DATABASE CONNECTION FAILURE MESSAGE CONSTANTS
	public static final String DATABASE_CONNECTION_PROBLEM = "ziksana.database.error";

	// COMMON CONSTANT MESSAGES
	public static final String ZIKSANA_OBJECT_NULL = "ziksana.null.error";
	public static final String SQL_ERROR = "sql.error";

	public static final String COOKIE_NOT_CREATED_EXCEPTION = "ziksana.system.cookie.notcreated";
	public static final String COOKIE_NOT_DELETED_EXCEPTION = "ziksana.system.cookie.notdeleted";

	// TODO ERROR MESSAGE CONSTANTS
	public static final String TODO_INSERTQUERY_PROBLEM = "todo.insert.error";
	public static final String TODO_INSERTED_SUCCESSFULLY = "TODO INSERTED SUCCESSFULLY";
	public static final String TODO_INSERTION_FAILED = "todo.insert.failed";
	public static final String TODO_UPDATEQUERY_PROBLEM = "todo.update.error";
	public static final String TODO_UPDATECOUNT_ERROR = "todo.updatecount.error";
	public static final String TODO_UPDATED_SUCCESSFULLY = "TODO UPDATED SUCCESSFULLY";
	public static final String TODO_UPDATE_FAILURE = "todo.update.failed";
	public static final String TODO_DELETION_FAILURE = "todo.deletion.failed";
	public static final String TODO_DELETED_SUCCESSFULLY = "TODO DELETED SUCCESSFULLY";

	// ALERT ERROR MESSAGE CONSTANTS
	public static final String ALERT_NOT_FOUND = "ziksana.alert.not_found";
	public static final String ALERT_IS_NULL = "alert.null";
	public static final String ALERT_ITEMID_NOTFOUND = "alert.delete.itemidnotfound";
	public static final String ALERT_DELETION_SUCCESS = "ALERT ITEM DELETED SUCCESSFULLY!";

	// ANNOUNCEMENTS ERROR MESSAGE CONSTANTS
	public static final String ANNOUNCEMENT_NOT_FOUND = "announcement.not.found";
	public static final String ANNOUNCEMENT_PARSE_ERROR = "announcement.parse.error";

	// BlOGS ERROR MESSAGE CONSTANTS
	public static final String BLOGS_NOT_FOUND = "blogs.not.found";

	// KNOWME BETTER MESSAGE CONSTANTS
	public static final String KNOWMEBETTER_NO_QUESTION_FOUND = "knowmebetter.read.error";
	public static final String KNOWMEBETTER_SQL_DATACCESS_ERROR = "knowmebetter.sql.error";
	public static final String KNOWMEBETTER_ANSWER_SAVED_SUCCESSFULLY = "ANSWER SAVED SUCCESSFULLY";
	public static final String KNOWMEBETTER_ANSWER_UPDATED_SUCCESSFULLY = "ANSWER UPDATED SUCCESSFULLY";
	
	// POLLS ERROR MESSAGE CONSTANTS
	public static final String POLL_NOT_FOUND = "announcement.not.found";
	public static final String POLL_DATE_PARSE_ERROR = "poll.date.parse.error";

}
