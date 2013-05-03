package com.ziksana.application
{
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.events.ZEvent;
	import com.ziksana.util.Logger;
	import com.ziksana.util.XMLUtil;

	public class ApplicationConfiguration
	{
		private var m_XMLUtil : XMLUtil = null;
		private var m_Parent : Object = null;
		private var m_ApplicationConfigurationFile:String = null;
		
		private var m_ApplicationLoggingLevel : int = 0;
		private var m_SecurityPolicyFile : String = null;
		private var m_RTMPHost : String = null;
		private var m_RTMPPort : int = 0;
		private var m_RTMPStreamsURL : String = null;
		private var m_VideoQuality : int = 0;
		private var m_VideoWidth : int = 0;
		private var m_VideoHeight : int = 0;
		private var m_VideoFilePrefix : String = null;
		private var m_AnnotatorUIFile : String = null;
		private var m_EnhanceUIFile : String = null;
		
		public function ApplicationConfiguration (configurationFile : String)
		{
			m_ApplicationConfigurationFile = configurationFile;
			m_XMLUtil = new XMLUtil(XMLUtil.TYPE_HTTP, m_ApplicationConfigurationFile);
		}
		
		public function Load() : void
		{
			if (m_XMLUtil)
			{
				GlobalEventDispatcher.instance.addGlobalListener(ZEvent.EVENT_CONFIGURATION_XML_PARSED, OnConfigurationXMLParsed);
				m_XMLUtil.setCompletionEvent(ZEvent.EVENT_CONFIGURATION_XML_PARSED);
				m_XMLUtil.loadAndParse();
			}
		}
		
		private function OnConfigurationXMLParsed (zEvent:ZEvent):void
		{
			var configurationFile:Object = m_XMLUtil.GetXMLParsedData();
			
			m_AnnotatorUIFile = configurationFile.SKIN.ANNOTATOR_THEME;
			m_EnhanceUIFile = configurationFile.SKIN.ENHANCER_THEME;
			
			m_ApplicationLoggingLevel = configurationFile.LOGGING_LEVEL;
			
			m_SecurityPolicyFile = configurationFile.SECURITY_POLICY_FILE;
			m_RTMPHost = configurationFile.RTMP.RTMP_HOST;
			m_RTMPPort = configurationFile.RTMP.RTMP_PORT;
			m_RTMPStreamsURL = configurationFile.RTMP.RTMP_STREAMS_URL;
			
			m_VideoQuality = configurationFile.VIDEO.VIDEO_QUALITY;
			m_VideoWidth = configurationFile.VIDEO.VIDEO_WIDTH;
			m_VideoHeight = configurationFile.VIDEO.VIDEO_HEIGHT;
			m_VideoFilePrefix = configurationFile.VIDEO.VIDEO_FILE_PREFIX;
			
			GlobalEventDispatcher.instance.dispatch(new ZEvent(ZEvent.EVENT_CONFIGURATION_LOADED,null));
		}
		
		public function get AnnotatorFile (): String 
		{
			return m_AnnotatorUIFile;
		}
		
		public function set AnnotatorFile (annotatorFile : String): void 
		{
			m_AnnotatorUIFile = annotatorFile;
		}
		
		public function get EnhanceUIFile (): String 
		{
			return m_EnhanceUIFile;
		}
		
		public function set EnhanceUIFile (enhanceUIFile : String): void 
		{
			m_EnhanceUIFile = enhanceUIFile;
		}
		
		public function get SecurityPolicyFile (): String 
		{
			return m_SecurityPolicyFile;
		}
		
		public function set SecurityPolicyFile (securityPolicyFile : String): void 
		{
			m_SecurityPolicyFile = securityPolicyFile;
		}
		
		public function get AppicationLoggingLevel (): int 
		{
			return m_ApplicationLoggingLevel;
		}
		
		public function set ApplicationLoggingLevel (loggingLevel : int): void 
		{
			m_ApplicationLoggingLevel = loggingLevel;
		}
		
		public function get RTMPHost (): String 
		{
			return m_RTMPHost;
		}
		
		public function set RTMPHost (rtmpHost : String): void 
		{
			m_RTMPHost = rtmpHost;
		}
		
		public function get RTMPPort (): int 
		{
			return m_RTMPPort;
		}
		
		public function set RTMPPort (rtmpPort : int): void 
		{
			m_RTMPPort = rtmpPort;
		}
		
		public function get RTMPStreamsURL (): String 
		{
			return m_RTMPStreamsURL;
		}
		
		public function set RTMPStreamsURL (rtmpStreamsURL : String): void 
		{
			m_RTMPStreamsURL = rtmpStreamsURL;
		}
		
		public function get VideoQuality (): int 
		{
			return m_VideoQuality;
		}
		
		public function set VideoQuality (videoQuality : int): void 
		{
			m_VideoQuality = videoQuality;
		}
		
		
		public function get VideoWidth (): int 
		{
			return m_VideoWidth;
		}
		
		public function set VideoWidth (videoWidth : int): void 
		{
			m_VideoWidth = videoWidth;
		}
		
		public function get VideoHeight (): int 
		{
			return m_VideoHeight;
		}
		
		public function set VideoHeight (videoHeight : int): void 
		{
			m_VideoHeight = videoHeight;
		}
		
		public function get VideoFilePrefix (): String 
		{
			return m_VideoFilePrefix;
		}
		
		public function set VideoFilePrefix (filePrefix : String): void 
		{
			m_VideoFilePrefix = filePrefix;
		}
	}
}