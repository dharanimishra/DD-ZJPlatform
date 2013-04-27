package com.ziksana.util
{
	import flash.display.Sprite;
	import com.ziksana.connection.ConnectionFactory;
	import com.ziksana.connection.ConnectionType;
	import com.ziksana.connection.IConnection;
	import com.ziksana.content.Content;
	import com.ziksana.data.ContentXMLData;
	import com.ziksana.events.CustomEvent;
	import com.ziksana.content.DocumentContent;
	import com.ziksana.content.VideoContent;
	import com.ziksana.data.XMLParser;

	public class UnitTests
	{
		public static const DEFAULT_CONNECTION_URL : String = "rtmp://video.beta.ziksana.com/oflaDemo";
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
			var connectionObj : IConnection;
			var retVal : Boolean;
			
			connectionObj = ConnectionFactory.CreateConnection(ConnectionType.CONNECTION_TYPE_RTMP);
			
			if (!connectionObj)
				return;
			
			retVal = connectionObj.Connect(DEFAULT_CONNECTION_URL);
			
			//connectionMGR.StartPlayback();
			//connectionMGR.Disconnect();
		}
		
		private function TestLiveContent () : void
		{
			var localContent : Content = new VideoContent ();
			
			localContent.Load ("http://54.243.235.88/1.flv");
			VideoContent(localContent).StartPlayback();
		}
	}
}