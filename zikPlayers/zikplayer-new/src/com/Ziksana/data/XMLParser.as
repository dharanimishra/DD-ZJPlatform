package com.ziksana.data
{
	import flash.events.Event;
	import flash.net.URLLoader;
	import flash.net.URLRequest;
	import com.ziksana.events.CustomEvent;
	import com.ziksana.events.EventData;
	
	public class XMLParser
	{
		private var m_XML : XML;
		private var m_XMLURL : String;
		private var m_XMLLoadEvent : CustomEvent;
		
		public function XMLParser(xmlURL : String)
		{
			m_XMLURL = xmlURL;
			LoadXML(xmlURL);
		}
		
		public function RegisterOnCompletionEvent (xmlLoadEvent : CustomEvent) : void
		{
			m_XMLLoadEvent = xmlLoadEvent;
		}
		
		private function LoadXML (xmlURL : String) : void 
		{
			var loader:URLLoader = new URLLoader(new URLRequest(xmlURL));
			loader.addEventListener(Event.COMPLETE, OnXMLLoadCompletion);
		}

		public function Load () : Boolean
		{
			return true;
		}
		
		public function Unload () : void
		{
		}
		
		
		public function GetXMLURL () : String
		{
			return m_XMLURL;
		}
		
		private function OnXMLLoadCompletion (xmlEvent : Event) : void
		{
			m_XML = new XML(xmlEvent.target.data);
			m_XMLLoadEvent.DispatchEvent();
		}
		
		public function GetContentXMLData (m_ContentXMLData : ContentXMLData) : Boolean
		{
			try 
			{
				if (m_XML.length() <= 0)
					return false;
				
				m_ContentXMLData.SetStartTime(m_XML.INIT[0].TIME);
				m_ContentXMLData.SetStartSlideNumber(m_XML.INIT[0].STARTSLIDE);
				m_ContentXMLData.SetImagePath(m_XML.INIT[0].IMAGEPATH);
				m_ContentXMLData.SetNumberOfImages(m_XML.INIT[0].NUMBEROFIMAGES);
				m_ContentXMLData.SetTotalTime(m_XML.INIT[0].TOTALTIME);
				
				var numberOfVideos : Number =  m_XML.VIDEO.length();
				m_ContentXMLData.SetNumberOfVideos(numberOfVideos);
				for (var currentVideoIndex:Number = 0; currentVideoIndex < numberOfVideos; currentVideoIndex++)
				{
					m_ContentXMLData.AddToVideoList(m_XML.VIDEO[currentVideoIndex]);
				}
				
				var numberOfRecordedEvents : Number =  m_XML.RECORD_EVENT.length();
				m_ContentXMLData.SetNumberOfRecordedEvents(numberOfRecordedEvents);
				for (var currentEventIndex:Number = 0; currentEventIndex < numberOfRecordedEvents; currentEventIndex++)
				{
					var ctrlKey:Boolean = (m_XML.RECORD_EVENT[currentEventIndex].CTRLKEY=="TRUE") ? true: false;
					
					//Construct an eventdata object here
					var evtData:EventData = new EventData (m_XML.RECORD_EVENT[currentEventIndex].TYPE, 
						m_XML.RECORD_EVENT[currentEventIndex].X,
						m_XML.RECORD_EVENT[currentEventIndex].Y, 
						ctrlKey, 
						m_XML.RECORD_EVENT[currentEventIndex].TOOL,
						m_XML.RECORD_EVENT[currentEventIndex].TIME);
					
					m_ContentXMLData.AddEventToList(evtData);
				}
			}
			catch (errorCode : Error)
			{
				trace ("XMLParser::GetContentXMLData ==> Error while parsing XML data. ErrorID : " + 
					errorCode.errorID.toString() + " " + errorCode.message);
					
			}
			
			return true;
		}
	}
}