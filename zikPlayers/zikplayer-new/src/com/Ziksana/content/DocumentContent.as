package com.ziksana.content
{
	import com.ziksana.util.Logger;
	
	import flash.display.Loader;
	import flash.display.LoaderInfo;
	import flash.events.Event;
	import flash.net.URLRequest;
	
	public class DocumentContent extends Content
	{
		private var m_ImageArray:Array = new Array();
		private var m_EventReceiver : Object = null;
		
		public function DocumentContent()
		{
			super.SetContentType(ContentType.CONTENT_TYPE_DOCUMENT);
			super.SetContentDescription(ContentType.CONTENT_TYPE_DOCUMENT_STRING);
		}
		
		public override function Load() : Boolean
		{
			var currentImage : int;
			try 
			{
				super.Load();
				
				//Load first image here
				if (m_ContentURLArray.length > 0)
					LoadImage(m_ContentURLArray[0]);
			}
			catch (errorCode : Error)
			{
				Logger.instance.WriteMessage ("DocumentContent::Load ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
				return false;
			}

			return true;
		}
		
		private function LoadImage (imageToDownload : String) : Boolean
		{
			DownloadImage (imageToDownload);
			return true;
		}
		
		private function DownloadImage (imageURL : String) : void
		{
			var imageLoader:Loader = new Loader();
			var fileRequest:URLRequest = new URLRequest(imageURL);
			
			imageLoader.load(fileRequest);
			imageLoader.contentLoaderInfo.addEventListener(Event.COMPLETE, OnImageDownloadComplete);
			
			return;
		}

		private function OnImageDownloadComplete (e:Event) : void 
		{
			var imageLoaderInfo :LoaderInfo = LoaderInfo(e.target);
			
			Logger.instance.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Image [" + (m_NumberOfPosition+1) + "] Loaded    ------------------");
			Logger.instance.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Content Type    = " + imageLoaderInfo.contentType);
			Logger.instance.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Number of Bytes = " + imageLoaderInfo.bytesLoaded);
			Logger.instance.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Height           = " + imageLoaderInfo.height);
			Logger.instance.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Width           = " + imageLoaderInfo.width);
			//Logger.instance.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Container       = " + imageLoaderInfo.loaderURL);
			Logger.instance.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> -------------------------------------------------------------------");
			
			m_ImageArray.push(e.target.content);
			m_NumberOfPosition++;
			
			//Load Next Image
			if (m_NumberOfPosition < m_ContentURLArray.length)
				LoadImage(m_ContentURLArray[m_NumberOfPosition]);
			
			if (m_ContentLoadEvent)
				m_ContentLoadEvent.DispatchEvent();
		}
		

		public override function GetData () : Object
		{
			return m_ImageArray[m_CurrentPosition];
		}
		
		//NAVIGATION STUFF
		public override function GetNumberOfPosition () : Number
		{
			return m_NumberOfPosition;
		}
		
		public override function SetNumberOfPosition (numberOfPosition : Number) : void
		{
			m_NumberOfPosition = numberOfPosition;
		}
		
		public override function GetCurrentPosition () : Number
		{
			return m_CurrentPosition;			
		}
		
		public override function SetCurrentPosition (currentPosition : Number) : void
		{
			if ((currentPosition >= 0) && (currentPosition < m_NumberOfPosition))
				m_CurrentPosition = currentPosition;
		}
	}
}