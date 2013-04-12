package com.Ziksana.Player
{
	import flash.display.Sprite;

	public class UnitTests
	{
		public static const XMLLoadCompletionEvent:String = "ON_XML_LOAD_COMPLETION";
		private var m_Parent : Sprite = null;
		public function UnitTests(parentObj : Sprite)
		{
			m_Parent = parentObj;
		}

		private function TestComponents () : void
		{
			TestXMLParser ();
			TestRTMPConnection ();
			TestDocumentContent();
			TestLiveContent ();
		}
		
		private function TestXMLParser () : void
		{
			var xmlParser : XMLParser;
			var xmlURL : String = "D:\\VTG\\data1359274006.ecxml";
			var xmlLoadEvent : CustomEvent;
			
			xmlParser = new XMLParser(xmlURL);
			
			m_Parent.addEventListener(XMLLoadCompletionEvent, OnXMLLoadCompletion);
			xmlLoadEvent = new CustomEvent(XMLLoadCompletionEvent, m_Parent, xmlParser);
			
			xmlParser.RegisterOnCompletionEvent(xmlLoadEvent);
		}
		
		
		public function OnXMLLoadCompletion (xmlEvent : CustomEvent) : void
		{
			var contentXMLData : ContentXMLData;
			contentXMLData = new ContentXMLData();
			
			var xmlParser : XMLParser = XMLParser (xmlEvent.GetEventParam());
			var bXMLLoaded : Boolean = xmlParser.GetContentXMLData(contentXMLData);
			
			if (bXMLLoaded)
				Logger ("XML : " + xmlParser.GetXMLURL() + " Loaded successfully.");
			else
				Logger ("Error Failed to Load XML : " + xmlParser.GetXMLURL());
			
			Logger ("Image Path : " + contentXMLData.GetImagePath());
			
		}
		
		private function TestDocumentContent () : void
		{
			var localContent : Content = new DocumentContent ();
			
			localContent.Load("");
		}
		
		private function TestRTMPConnection () : void
		{
			//Test code
			var connectionMGR : ConnectionManager;
			var retVal : Boolean;
			
			connectionMGR = new ConnectionManager();
			
			if (!connectionMGR)
				return;
			
			retVal = connectionMGR.Connect(ConnectionManager.DEFAULT_CONNECTION_URL, ConnectionType.CONNECTION_TYPE_RTMP);
			
			//connectionMGR.StartPlayback();
			//connectionMGR.Disconnect();
		}
		
		private function TestLiveContent () : void
		{
			var localContent : Content = new LiveContent ();
			
			localContent.Load ("http://54.243.235.88/1.flv");
			LiveContent(localContent).StartPlayback();
		}
	}
}