package com.ziksana.util
{
	public class Util
	{
		public static const RECORDING_FILE_NAME_PREFIX :String = "red5RecordDemo_";
		
		public function Util()
		{
		}
		
		public function GenerateRecordingFileName () : String
		{
			var currentDate:Date = new Date();
			var unixTime:Number = Math.round(currentDate.getTime()/1000);
			var videoRecordingFileName : String;
			
			// create a random number to store a unique name
			videoRecordingFileName = RECORDING_FILE_NAME_PREFIX + unixTime;
			
			return videoRecordingFileName;
		}
	}
}