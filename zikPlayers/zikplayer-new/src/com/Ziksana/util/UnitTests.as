package com.ziksana.util
{
	import flash.display.Sprite;
	import com.ziksana.connection.ConnectionFactory;
	import com.ziksana.connection.ConnectionType;
	import com.ziksana.connection.IConnection;
	import com.ziksana.content.Content;
	import com.ziksana.data.ContentXMLData;
	import com.ziksana.events.ZEvent;
	import com.ziksana.content.DocumentContent;
	import com.ziksana.content.VideoContent;
	import com.ziksana.data.XMLParser;

	public class UnitTests
	{
		public static const DEFAULT_CONNECTION_URL : String = "rtmp://video.beta.ziksana.com/oflaDemo";
		private var m_Parent : Sprite = null;
		public function UnitTests(parentObj : Sprite)
		{
			m_Parent = parentObj;
		}

		private function TestComponents () : void
		{
			TestRTMPConnection ();
			TestDocumentContent();
			TestLiveContent ();
		}
		
		private function TestDocumentContent () : void
		{
			var localContent : Content = new DocumentContent ();
			
			//localContent.Load();
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
			
			//localContent.Load ("http://54.243.235.88/1.flv");
			//VideoContent(localContent).StartPlayback();
		}
	}
}