/**
 * 
 */
package com.ziksana.constants;

/**
 * In Ziksana Constants, use each constant name as Naming convention
 * eg :
 * <module_name>_<error_name>_<error_type>
 *
 */
public interface ZiksanaConstants {
	
	 //DATABASE CONNECTION FAILURE MESSAGE CONSTANTS
	 public static final String DATABASE_CONNECTION_PROBLEM = "ziksana.database.error";
	
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
}
