package com.ziksana.util
{
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.events.ZEvent;
	
	import flash.events.Event;
	import flash.events.HTTPStatusEvent;
	import flash.events.IOErrorEvent;
	import flash.events.ProgressEvent;
	import flash.events.SecurityErrorEvent;
	import flash.net.URLLoader;
	import flash.net.URLRequest;
	
	/** 
	 * XMLUtil is the utility class to load XML files from local or HTTP location and parse to a tree data structure.
	 * This can be extended to suppport XSLT and other generic XML functionality over XML data.
	 * 
	 * @tag XMLUtil XML
	 */
	public class XMLUtil
	{
		/** 
		 * The enums for TYPE specification for XMLUtil 
		 * It may be one of the two - TYPE_HTTP or TYPE_LOCAL.
		 * 
		 * <p> As of now only TYPE_HTTP makes sense. Depending on the architecture. Later a LOCAL directory 
		 * access can be used, where the HTTP access specific events will not come in to the event handling part of 
		 * the class </p>
		 */
		public static const TYPE_HTTP:uint = 0;
		public static const TYPE_LOCAL:uint = 1;
		
		private var type:uint;
		private var url:String = null;
		private var data:XML = null;
		private var urlRequest:URLRequest = null;
		private var xmlLoader:URLLoader = null;
		private var status:String = "UNINITIALIZED";
		private var progress:Number = 0;
		private var m_XMLLoadEvent : ZEvent = null;
		public var m_XMLParsedData:Object = null;
		private var m_CompletionEvent : String = null;
		/** 
		 * Constructor for XMLUtil which takes in type of the 
		 * XMLUtil - TYPE_HTTP or TYPE_LOCAL
		 * and URL to be loaded - depending on the type of the loader.
		 * 
		 * <p> This function just creates the XMLUtil but does not start the loading activity yet.
		 * This is done by explicit call to load() or loadAndParse(). </p>
		 */
		public function XMLUtil(typeOfLoader:uint, urlToLoad:String):void
		{
			type = typeOfLoader;	
			url = urlToLoad;
			data = new XML();
			urlRequest = new URLRequest(url); 
			status = "INITIALIZED";
			xmlLoader = new URLLoader(); 
		}
		

		public function setCompletionEvent (eventName : String) : void
		{
			m_CompletionEvent = eventName;
		}
		
		/** 
		 * loadAndParse() function is used to do both loading of specific URL and parsing of the loaded XML
		 * data sequentially. This can be done separately also.
		 */
		public function loadAndParse():void
		{
			xmlLoader.load(urlRequest);
			xmlLoader.addEventListener(Event.COMPLETE, onXMLLoadCompletion);
			
			if (type == TYPE_HTTP)
			{
				xmlLoader.addEventListener(Event.OPEN, connectionOpened);
				xmlLoader.addEventListener(ProgressEvent.PROGRESS, updateProgress); 
			}
			
			xmlLoader.addEventListener(SecurityErrorEvent.SECURITY_ERROR, throwZikSecurityError); 
			xmlLoader.addEventListener(HTTPStatusEvent.HTTP_STATUS, updateHTTPStatus);
			xmlLoader.addEventListener(IOErrorEvent.IO_ERROR, throwZikNetworkError);
			xmlLoader.addEventListener(IOErrorEvent.DISK_ERROR, throwZikNetworkError);
			xmlLoader.addEventListener(IOErrorEvent.NETWORK_ERROR, throwZikNetworkError);
			
			//Logger.instance.WriteMessage("TESTING LOGGER", Logger.LOG_LEVEL_ERROR);
		} 
		
		
		/**
		 * This is the function that will be called upon successful completion of loading the data. 
		 * The property 'data' will contain the loaded XML data.
		 */
		private function onXMLLoadCompletion(event:Event):void 
		{
			data = XML(xmlLoader.data); 
			var xmlParser:XMLParser = new XMLParser(data);
			m_XMLParsedData = xmlParser.parse();
			
			if (m_CompletionEvent)
			{
				GlobalEventDispatcher.instance.dispatch (new ZEvent(m_CompletionEvent, null));
			}
		}
		
		public function GetXMLParsedData () : Object
		{
			return m_XMLParsedData;
		}
		
		/**
		 * The function is called when HTTP connection type is used and the connection is successfully opened.
		 * This will not be called when there is not network connection is available. The 'status' property of the
		 * XMLUtil is set to CONNECTION OPENED if this function is called. 
		 */
		private function connectionOpened(event:Event):void 
		{ 
			status = "CONNECTION OPENED"; 
		}
		
		/**
		 * This catches the ioError event and encapsulates it into custom ZikException - wiz. ZNetworkException.
		 */
		private function throwZikNetworkError(event:Event):void
		{
						
		}

		/**
		 * This catches the SecurityErrorEvent and encapsulates it into custom ZikException - wiz. ZNetworkSecurityException.
		 */
		private function throwZikSecurityError(event:Event):void
		{
			
		}
		
		/**
		 * This function updates the 'status' property with HTTP Status as and when HTTP connection is opened.
		 */		
		private function updateHTTPStatus(event:HTTPStatusEvent):void
		{
			status = "HTTP STATUS"+ event.status.toString();
		}
		
		/**
		 * This function updates the 'progress' property by using the ProgressEvent genereted by the loader.
		 * 'progress' is represented as percentage value.
		 */	
		private function updateProgress(event:ProgressEvent):void
		{
			progress = event.bytesLoaded/event.bytesTotal;
		}
	}
}