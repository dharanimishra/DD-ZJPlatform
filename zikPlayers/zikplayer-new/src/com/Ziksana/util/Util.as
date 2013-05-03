package com.ziksana.util
{
	public final class Util
	{
		public static const RECORDING_FILE_NAME_PREFIX :String = "red5RecordDemo_";
		
		public function Util()
		{
		}
		
		public static function GenerateRecordingFileName () : String
		{
			var currentDate:Date = new Date();
			var unixTime:Number = Math.round(currentDate.getTime()/1000);
			var videoRecordingFileName : String;
			
			// create a random number to store a unique name
			videoRecordingFileName = RECORDING_FILE_NAME_PREFIX + unixTime;
			
			return videoRecordingFileName;
		}
		
		public static function RGBToHex (red : int, green : int, blue : int) : Number
		{
			var hexNumber:Number = Number("0x" + red.toString(16) + green.toString(16) + blue.toString(16));
			
			return hexNumber;
		}
	}
}