package com.ziksana.player
{
	import flash.display.Bitmap;
	import flash.display.DisplayObject;
	import flash.display.MovieClip;
	import flash.display.Sprite;
	import flash.events.MouseEvent;
	import com.ziksana.content.Content;
	import com.ziksana.events.ZEvent;
	import com.ziksana.events.GlobalEventDispatcher;
	
	public class DocumentViewer extends ContentViewer
	{
		
		[Embed(source='../../../../resources/MoveLeft.png')]
		public static var MOVETOPREVIOUSPAGE_BUTTON:Class;
		
		[Embed(source='../../../../resources/MoveRight.png')]
		public static var MOVETONEXTPAGE_BUTTON:Class;
		
		private static const CHILD_IMAGEMASK_INDEX : uint = 0;
		private static const CHILD_IMAGECONTENT_INDEX : uint = 1;
		private static const CHILD_MOVETOPREVIOUSIMAGE_BUTTON_INDEX : uint = 2;
		private static const CHILD_MOVETONEXTIMAGE_BUTTON_INDEX : uint = 3;
		
		private var m_DocumentPage : MovieClip = new MovieClip();
		
		private var m_LastImageDrawn : DisplayObject = null;
		private var m_LastImageMask : DisplayObject = null;
		private var bIsDrawingFirstTime : Boolean = true;
		
		public function DocumentViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			m_ContentDisplayObject.addChild(m_DocumentPage);
			
			//up arrow
			//down arrow
			RegisterEvents ();
		}
		
		public override function Load () : void
		{
			SetContent();
			m_Content.Load();
		}
		
		public override function Unload () : void
		{
		}
		
		
		private function SetContent () : void
		{
			var m_ImageURLArray:Array = new Array ();
			
			//Download images here
			/*
			var currentImage : int;
			var numberOfImages : int;
			var imagePath : String;
			var currentImageToDownload : String;
			
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
			
			//m_ImageURLArray.push("d:\\images\\1.jpg");
			m_ImageURLArray.push("d:\\images\\2.jpg");
			m_ImageURLArray.push("d:\\images\\3.jpg");
			m_ImageURLArray.push("d:\\images\\4.jpg");
			m_ImageURLArray.push("d:\\images\\5.jpg");
			m_ImageURLArray.push("d:\\images\\6.jpg");
			m_ImageURLArray.push("d:\\images\\7.jpg");
			m_ImageURLArray.push("d:\\images\\8.jpg");
			m_ImageURLArray.push("d:\\images\\9.jpg");
			
			m_Content.SetContentURL(m_ImageURLArray);
		}
		
		public override function RegisterEvents () : void
		{
			GlobalEventDispatcher.instance.addGlobalListener(ZEvent.EVENT_CONTENT_IMAGE_LOADED, OnContentLoadEvent);
			m_Content.RegisterOnCompletionEvent(ZEvent.EVENT_CONTENT_IMAGE_LOADED);
			
			m_DocumentPage.addEventListener (MouseEvent.MOUSE_DOWN, OnPageContainerMouseDown);
			m_DocumentPage.addEventListener (MouseEvent.MOUSE_MOVE, OnPageContainerMouseMove);
			m_DocumentPage.addEventListener (MouseEvent.MOUSE_UP, OnPageContainerMouseUp);
			m_DocumentPage.addEventListener (MouseEvent.MOUSE_OUT, OnPageContainerMouseUp);
		}
		
		private function DisplayContentData () : void
		{
			var bmp : Bitmap = m_Content.GetData() as Bitmap;
			var imageToDraw : Bitmap = new Bitmap(bmp.bitmapData);
			
			DrawScaledImage(imageToDraw);
			AddNavigationButtons ();
		}
		
		private function DrawScaledImage (imageToDraw : Bitmap) : void
		{
			imageToDraw.x = 0;
			imageToDraw.y = 0;
			imageToDraw.rotation = 0;
			imageToDraw.scaleX = new Number(m_Width/imageToDraw.width);
			imageToDraw.scaleY = imageToDraw.scaleX;
			
			if (m_LastImageDrawn)
			{
				m_DocumentPage.removeChild(m_LastImageDrawn);
				m_LastImageDrawn = null;
			}
			if (m_LastImageMask)
			{
				m_DocumentPage.removeChild(m_LastImageMask);
				m_LastImageMask = null;
			}
			
			var imageMask:Sprite      = new Sprite();
			imageMask.graphics.beginFill( 0xFF6600, 0 );  
			imageMask.graphics.drawRoundRectComplex(m_Left, m_Top, m_Width, m_Height, 6, 6, 6, 6);
			m_LastImageDrawn = m_DocumentPage.addChildAt (imageMask, CHILD_IMAGEMASK_INDEX);
			
			imageToDraw.mask = imageMask;
			m_LastImageMask = m_DocumentPage.addChildAt(imageToDraw, CHILD_IMAGECONTENT_INDEX);
		}
		
		private function AddNavigationButtons () : void
		{
			var buttonExist : Boolean = false;
			if (m_DocumentPage.numChildren >= 4)
			{
				buttonExist =  m_DocumentPage.getChildAt(CHILD_MOVETOPREVIOUSIMAGE_BUTTON_INDEX) &&
					m_DocumentPage.getChildAt(CHILD_MOVETONEXTIMAGE_BUTTON_INDEX);
			}
					
			if (!buttonExist)
			{
				var previousButtonClip : MovieClip = new MovieClip();
				var previousPageButton:Bitmap = new MOVETOPREVIOUSPAGE_BUTTON();
				previousPageButton.x=0;
				previousPageButton.y=(m_Height-previousPageButton.height)/2;
				previousButtonClip.addChild(previousPageButton);
				
				var  nextButtonClip : MovieClip = new MovieClip();
				var nextPageButton : Bitmap = new MOVETONEXTPAGE_BUTTON();
				nextPageButton.x=m_Width-previousPageButton.width;
				nextPageButton.y=(m_Height-previousPageButton.height)/2
				nextButtonClip.addChild(nextPageButton);
				
				previousButtonClip.addEventListener(MouseEvent.CLICK, OnGoToPreviousImage);
				nextButtonClip.addEventListener(MouseEvent.CLICK, OnGoToNextImage);

				m_DocumentPage.addChildAt(previousButtonClip, CHILD_MOVETOPREVIOUSIMAGE_BUTTON_INDEX);
				m_DocumentPage.addChildAt(nextButtonClip, CHILD_MOVETONEXTIMAGE_BUTTON_INDEX);
			}
		}
		
		public function OnContentLoadEvent (contentLoadEvent : ZEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
			if (bIsDrawingFirstTime)
				DisplayContentData ();
			bIsDrawingFirstTime = false;
		}
		
		private function OnPageContainerMouseDown (mouseEvent : MouseEvent) : void 
		{
			//Logger.WriteMessage("DocumentViewer::OnMouseDown ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY); 
		}
		
		private function OnPageContainerMouseUp (mouseEvent : MouseEvent) : void 
		{
			//Logger.WriteMessage("DocumentViewer::OnMouseUp ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
		}
		
		private function OnPageContainerMouseMove (mouseEvent : MouseEvent) : void 
		{
			//Logger.WriteMessage("DocumentViewer::OnMouseMove ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
		}
		
		private function OnGoToPreviousImage (mouseEvent : MouseEvent) : void 
		{
			MoveToPreviousPosition();
			DisplayContentData();
		}

		private function OnGoToNextImage (mouseEvent : MouseEvent) : void 
		{
			MoveToNextPosition();
			DisplayContentData();
		}
	}
}