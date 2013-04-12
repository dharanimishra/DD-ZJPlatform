package com.Ziksana.Player
{
	import flash.external.ExternalInterface;

	public class JavaExternalInterface
	{
		private static const FF_GET_FLASH_RECORDER_PATH : String = "ff_get_flash_recorder";
		private static const FF_RECORDING_SAVE_PATH : String = "ff_recording_save_path";
		private static const FF_DISPLAY_CONSOLE_MESSAGE : String = "ff_display_console_message";
		private static const FF_GET_RECORDED_FILE : String = "ff_get_recorded_file";
		private static const FF_LOAD_IMAGES : String = "ff_load_images";
		private static const FF_CUSTOM : String = "";

		public function JavaExternalInterface()
		{
		}
		
		public static function DisplayConsoleMessage (messageToDisplay : String) : void
		{
			try 
			{
				ExternalInterface.call(FF_DISPLAY_CONSOLE_MESSAGE, messageToDisplay); 
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("JavaExternalInterface::DisplayConsoleMessage ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
			}
		}
		
		public static function GetFlashRecorderPath () : String
		{
			var flashRecorderPath :String;
			try 
			{
				flashRecorderPath = ExternalInterface.call(FF_GET_FLASH_RECORDER_PATH);
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("JavaExternalInterface::GetFlashRecorderPath ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
			}

			return flashRecorderPath;
		}

		public static function SetRecordedFilePath (recordingPath : String) : void
		{
			try 
			{
				ExternalInterface.call(FF_GET_RECORDED_FILE, recordingPath);
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("JavaExternalInterface::SetRecordedFilePath ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
			}
		}
		
		public static function GetRecordedFile () : String
		{
			var recordedFile :String;
			try 
			{
				recordedFile = ExternalInterface.call(FF_GET_RECORDED_FILE);
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("JavaExternalInterface::GetRecordedFile ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
			}
			return recordedFile;
		}
		
		public static function GetLoadImagesURL () : String
		{
			var imageURL:String;
			try 
			{
				imageURL = ExternalInterface.call(FF_LOAD_IMAGES);
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("JavaExternalInterface::GetLoadImagesURL ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
			}
			
			return imageURL;
		}
		
		public static function GetImagePath () : String
		{
			var imageURL:String;
			var imagePath:String;
			var delimiterIndex : Number;
			
			imageURL = GetLoadImagesURL ();
			
			delimiterIndex = imageURL.indexOf("|||");
			imagePath = imageURL.substr(0, delimiterIndex);
			
			return imagePath;
		}
		
		public static function GetNumberOfImages () : int
		{
			var imageURL : String = GetImagePath();
			var numberOfImages : int;
			var delimiterIndex : Number;
			
			delimiterIndex = imageURL.indexOf("|||");
			numberOfImages = new Number(imageURL.substr(delimiterIndex + 3));
			
			return numberOfImages;
		}
		
		public static function CallFunction (functionToCall : String, ...args) : void
		{
			try 
			{
				ExternalInterface.call(functionToCall, args);			
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("JavaExternalInterface::CallFunction ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
			}
		}
	}
}