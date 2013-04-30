package com.ziksana.content
{
	import com.ziksana.util.Logger;
	
	import flash.display.Loader;
	import flash.display.LoaderInfo;
	import flash.events.Event;
	import flash.net.URLRequest;
	
	public class DocumentContent extends Content
	{
		private var m_ImageURLArray:Array = new Array ();
		private var m_ImageArray:Array = new Array();
		private var m_EventReceiver : Object = null;
		
		public function DocumentContent()
		{
			super.SetContentType(ContentType.CONTENT_TYPE_DOCUMENT);
			super.SetContentDescription("Document");
		}
		
		public override function Load(contentURL : String) : Boolean
		{
			try 
			{
				super.Load(contentURL);
				
				var currentImage : int;
				var numberOfImages : int;
				var imagePath : String;
				var currentImageToDownload : String;
				
				/*
				numberOfImages = JavaExternalInterface.GetNumberOfImages();
				imagePath = JavaExternalInterface.GetImagePath();
				
				//Just use number of images as number of position
				SetNumberOfPosition(numberOfImages);
				
				Logger.WriteMessage ("DocumentContent::DownloadImage ==> Loading All Images Image");
				
				for (currentImage = 0; currentImage < numberOfImages; currentImage++)
				{
					currentImageToDownload = imagePath + "img" + currentImage + ".jpg";
					LoadImage (currentImageToDownload);
				}
				*/
				//temporary..
				LoadImage (contentURL);
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("DocumentContent::Load ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
				return false;
			}

			return true;
		}
		
		private function LoadImage (imageToDownload : String) : Boolean
		{
			m_ImageURLArray.push(imageToDownload);
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
			//ZIKLogger.WriteMessage (e.target, ZIKLogger.LOG_LEVEL_INFO);
			var imageLoaderInfo :LoaderInfo = LoaderInfo(e.target);
			
			Logger.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Image Loaded    ------------------");
			Logger.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Content Type    = " + imageLoaderInfo.contentType);
			Logger.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Number of Bytes = " + imageLoaderInfo.bytesLoaded);
			Logger.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Width           = " + imageLoaderInfo.width);
			Logger.WriteMessage ("DocumentContent::OnImageDownloadComplete ==> Container       = " + imageLoaderInfo.loaderURL);
			
			m_ImageArray.push(e.target.content);
			m_NumberOfPosition++;
			
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
			
			//Move the current data pointer here.
		}
	}
}