package com.ziksana.util
{
	public final class Logger
	{
		public static const TARGET_FILE:int = 0;
		public static const TARGET_CONSOLE:int = 1;
		
		public static const LOG_LEVEL_NONE :int = 0;
		public static const LOG_LEVEL_INFO: int = 1;
		public static const LOG_LEVEL_ERROR: int = 2;
		public static const LOG_LEVEL_CRITICAL: int = 3;
		private static var m_LoggingLevel:int = LOG_LEVEL_INFO;
		
		private static var _instance:Logger;
		
		public static function get instance():Logger
		{
			if (_instance == null)
			{
				_instance = new Logger();
			}
			return _instance;
		}
			
		public function Logger():void
		{
			if (_instance != null) throw new Error("You can't create Singleton twice!");
		}
	
		public static function SetLoggingLevel (loggingLevel : int) : void
		{
			m_LoggingLevel = loggingLevel;
		}
		
		public function WriteMessage (logMessage : String, loggingLevel : int = LOG_LEVEL_INFO, target : int = TARGET_CONSOLE) : void
		{
			if (loggingLevel < m_LoggingLevel)
				return;
			
			if (target == TARGET_CONSOLE)
				trace (logMessage);
		}
	}
}