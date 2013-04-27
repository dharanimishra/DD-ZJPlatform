package com.ziksana.connection
{
	import flash.events.Event;
	import flash.events.HTTPStatusEvent;
	import flash.events.IEventDispatcher;
	import flash.events.IOErrorEvent;
	import flash.events.ProgressEvent;
	import flash.events.SecurityErrorEvent;
	import flash.net.URLLoader;
	import flash.net.URLRequest;
	import flash.net.URLRequestMethod;
	import flash.system.Security;
	import com.ziksana.util.JavaExternalInterface;
	import com.ziksana.util.Logger;

	public class PHPConnection
	{
		public static const SecurityPolicyFile :String = "https://video.beta.ziksana.com/crossdomain.xml";
		
		public function PHPConnection()
		{
		}
		
		public function SendData (dataToSend : XML) : void
		{
			var loader:URLLoader = new URLLoader();
			
			RegisterEventListners (loader);
			
			Security.loadPolicyFile(SecurityPolicyFile);
			var flashRecorderPath : String = JavaExternalInterface.GetFlashRecorderPath();
			var request : URLRequest = new URLRequest(flashRecorderPath);  

			request.data = dataToSend;
			request.contentType = "text/xml";
			request.method = URLRequestMethod.POST;
			
			try 
			{
				loader.load(request);
			} 
			catch (errorCode : Error) 
			{
				Logger.WriteMessage ("PHPConnection::SendData ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
			}
		}
		
		private function RegisterEventListners (dispatcher:IEventDispatcher) : void 
		{
			dispatcher.addEventListener(Event.COMPLETE, OnEventCompletion);
			dispatcher.addEventListener(Event.OPEN, OnEventOpen);
			dispatcher.addEventListener(ProgressEvent.PROGRESS, OnEventProgress);
			dispatcher.addEventListener(SecurityErrorEvent.SECURITY_ERROR, OnSecurityErrorHandler);
			dispatcher.addEventListener(HTTPStatusEvent.HTTP_STATUS, OnHTTPStatusHandler);
			dispatcher.addEventListener(IOErrorEvent.IO_ERROR, OnIOErrorHandler);
		}
		
		private function OnEventCompletion(event:Event) : void
		{
			var loader:URLLoader = URLLoader(event.target);
			
			Logger.WriteMessage ("PHPConnection::OnEventCompletion => Data : " + loader.data);
			
			JavaExternalInterface.SetRecordedFilePath(loader.data);
			JavaExternalInterface.DisplayConsoleMessage("PHPConnection::OnEventCompletion ==> " + loader.data);
		}
		
		private function OnEventOpen (event : Event) : void 
		{
			JavaExternalInterface.DisplayConsoleMessage("PHPConnection::OnEventOpen ==> " + event.toString());
		}
		
		private function OnEventProgress (event:ProgressEvent) : void
		{
			JavaExternalInterface.DisplayConsoleMessage("PHPConnection::OnSecurityErrorHandler ==> Loaded : " + event.bytesLoaded + " total: " + event.bytesTotal);
		}
		
		private function OnSecurityErrorHandler(event:SecurityErrorEvent) : void
		{
			JavaExternalInterface.DisplayConsoleMessage("PHPConnection::OnSecurityErrorHandler ==> " + event.toString());
		}
		
		private function OnHTTPStatusHandler (event:HTTPStatusEvent) : void
		{
			JavaExternalInterface.DisplayConsoleMessage("PHPConnection::OnHTTPStatusHandler ==> " + event.toString());
		}
		
		private function OnIOErrorHandler(event:IOErrorEvent) : void 
		{
			Logger.WriteMessage ("PHPConnection::ioErrorHandler => " + event);
		}
	}
}