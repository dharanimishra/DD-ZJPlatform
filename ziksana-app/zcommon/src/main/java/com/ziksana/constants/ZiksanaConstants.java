/**
 * 
 */
package com.ziksana.constants;

/**
 * In Ziksana Constants, use each constant name as Naming convention
 *  You can have multiple scenario for each CRUD operation
 *  like findById, findByName, upadateByName  etc.
 * eg :
 * <module_name>_<error_name>_<e
 * rror_type>
 * e.g. alert.create.failed
 * e.g. alert.retrive.not_found
 * e.g. alert.retrive.not_found_by_date
 * e.g. alert.update.failed
 * e.g. alert.delete.failed.
 *
 */
public interface ZiksanaConstants {
	
	public static final String SYSTEM_EXCEPTION = "SYSTEM";
	public static final String APPLICATION_EXCEPTION = "APPLICATION";
	
	 //DATABASE CONNECTION FAILURE MESSAGE CONSTANTS
	 public static final String DATABASE_CONNECTION_PROBLEM = "ziksana.database.error";
	 
	 public static final String COOKIE_NOT_CREATED_EXCEPTION = "ziksana.system.cookie.notcreated";
	 public static final String COOKIE_NOT_DELETED_EXCEPTION = "ziksana.system.cookie.notdeleted";
	
	 //TODO ERROR MESSAGE CONSTANTS
	 public static final String TODO_INSERTQUERY_PROBLEM = "todo.insert.error";
	 public static final String TODO_INSERTED_SUCCESSFULLY = "TODO INSERTED SUCCESSFULLY";
	 public static final String TODO_INSERTION_FAILED = "todo.insert.failed";
	 public static final String TODO_UPDATEQUERY_PROBLEM = "todo.update.error";
	 public static final String TODO_UPDATECOUNT_ERROR = "todo.updatecount.error";
	 public static final String TODO_UPDATED_SUCCESSFULLY = "TODO UPDATED SUCCESSFULLY";
	 public static final String TODO_UPDATE_FAILURE = "todo.update.failed";
	 public static final String TODO_DELETION_FAILURE = "todo.deletion.failed";
	 public static final String TODO_DELETED_SUCCESSFULLY = "todo.delete.success";
	 
	 //alert error codes
	 public static final String ALERT_RETRIEVE_NOT_FOUND = "ziksana.alert.retrieve.not_found";
	 public static final String ALERT_RETRIEVE_NOT_FOUND_BYDATE = "ziksana.alert.retrieve.not_found_bydate";
	 
}
