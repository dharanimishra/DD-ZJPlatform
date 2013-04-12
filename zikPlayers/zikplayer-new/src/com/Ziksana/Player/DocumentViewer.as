package com.Ziksana.Player
{
	import flash.display.Bitmap;
	import flash.display.DisplayObject;
	import flash.display.MovieClip;
	import flash.display.Sprite;
	import flash.events.MouseEvent;

	public class DocumentViewer extends ContentViewer
	{
		
		[Embed(source='../../../../resources/MoveLeft.png')]
		public static var MOVETOPREVIOUSPAGE_BUTTON:Class;
		
		[Embed(source='../../../../resources/MoveRight.png')]
		public static var MOVETONEXTPAGE_BUTTON:Class;
		
		private var m_PageContainer : MovieClip = new MovieClip();
		private var m_ContentLoadEvent : CustomEvent = null;
		private var m_AllotedWidth : Number = 0;
		private var m_AllotedHeight : Number = 0;
		
		private static const ContentLoadEvent:String = "ON_CONTENT_LOAD";
		private static const CHILD_IMAGEMASK_INDEX : uint = 0;
		private static const CHILD_IMAGECONTENT_INDEX : uint = 1;
		private static const CHILD_MOVETOPREVIOUSIMAGE_BUTTON_INDEX : uint = 2;
		private static const CHILD_MOVETONEXTIMAGE_BUTTON_INDEX : uint = 3;
		
		private var m_LastImageDrawn : DisplayObject = null;
		private var m_LastImageMask : DisplayObject = null;
		
		
		private var bFirstTime : Boolean = true;
		
	
		
		public function DocumentViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			
			m_ContentDisplayObject.addChild(m_PageContainer);
			
			//up arrow
			//down arrow
			RegisterContentEvents ();
			
			m_Content.Load("d:\\images\\1.jpg");
			//m_Content.Load("http://54.243.235.88/zikload-xml/uploads/document/f1364629539/thumbnails/img1.jpg");
			m_Content.Load("d:\\images\\2.jpg");
			m_Content.Load("http://54.243.235.88/zikload-xml/uploads/document/f1364629539/thumbnails/img0.jpg");
			m_Content.Load("d:\\images\\3.jpg");
			m_Content.Load("d:\\images\\4.jpg");
			m_Content.Load("d:\\images\\5.jpg");
			m_Content.Load("d:\\images\\6.jpg");
			m_Content.Load("d:\\images\\7.jpg");
			m_Content.Load("d:\\images\\8.jpg");
			m_Content.Load("d:\\images\\9.jpg");
		}
		
		private function RegisterContentEvents () : void
		{
			addEventListener(ContentLoadEvent, OnContentLoadEvent);
			m_ContentLoadEvent = new CustomEvent(ContentLoadEvent, this, this);
			m_Content.RegisterOnCompletionEvent(m_ContentLoadEvent);
			
			m_PageContainer.addEventListener (MouseEvent.MOUSE_DOWN, OnPageContainerMouseDown);
			m_PageContainer.addEventListener (MouseEvent.MOUSE_MOVE, OnPageContainerMouseMove);
			m_PageContainer.addEventListener (MouseEvent.MOUSE_UP, OnPageContainerMouseUp);
			m_PageContainer.addEventListener (MouseEvent.MOUSE_OUT, OnPageContainerMouseUp);
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
			imageToDraw.scaleX = new Number(m_AllotedWidth/imageToDraw.width);
			imageToDraw.scaleY = imageToDraw.scaleX;
			
			if (m_LastImageDrawn)
			{
				m_PageContainer.removeChild(m_LastImageDrawn);
				m_LastImageDrawn = null;
			}
			if (m_LastImageMask)
			{
				m_PageContainer.removeChild(m_LastImageMask);
				m_LastImageMask = null;
			}
			
			var imageMask:Sprite      = new Sprite();
			imageMask.graphics.beginFill( 0xFF6600, 0 );  
			imageMask.graphics.drawRoundRectComplex(0, 0, m_AllotedWidth, m_AllotedHeight, 6, 6, 6, 6);
			m_LastImageDrawn = m_PageContainer.addChildAt (imageMask, CHILD_IMAGEMASK_INDEX);
			
			imageToDraw.mask = imageMask;
			m_LastImageMask = m_PageContainer.addChildAt(imageToDraw, CHILD_IMAGECONTENT_INDEX);
		}
		
		private function AddNavigationButtons () : void
		{
			var buttonExist : Boolean = false;
			if (m_PageContainer.numChildren >= 4)
			{
				buttonExist =  m_PageContainer.getChildAt(CHILD_MOVETOPREVIOUSIMAGE_BUTTON_INDEX) &&
					m_PageContainer.getChildAt(CHILD_MOVETONEXTIMAGE_BUTTON_INDEX);
			}
					
			if (!buttonExist)
			{
				var previousButtonClip : MovieClip = new MovieClip();
				var previousPageButton:Bitmap = new MOVETOPREVIOUSPAGE_BUTTON();
				previousPageButton.x=0;
				previousPageButton.y=(m_AllotedHeight-previousPageButton.height)/2;
				previousButtonClip.addChild(previousPageButton);
				
				var  nextButtonClip : MovieClip = new MovieClip();
				var nextPageButton : Bitmap = new MOVETONEXTPAGE_BUTTON();
				nextPageButton.x=m_AllotedWidth-previousPageButton.width;
				nextPageButton.y=(m_AllotedHeight-previousPageButton.height)/2
				nextButtonClip.addChild(nextPageButton);
				
				previousButtonClip.addEventListener(MouseEvent.CLICK, OnGoToPreviousImage);
				nextButtonClip.addEventListener(MouseEvent.CLICK, OnGoToNextImage);

				m_PageContainer.addChildAt(previousButtonClip, CHILD_MOVETOPREVIOUSIMAGE_BUTTON_INDEX);
				m_PageContainer.addChildAt(nextButtonClip, CHILD_MOVETONEXTIMAGE_BUTTON_INDEX);
			}
		}
		
		public override function SetCoordinates (width : Number, height : Number) : void
		{
			m_AllotedWidth = width;
			m_AllotedHeight = height;
		}

		public function OnContentLoadEvent (contentLoadEvent : CustomEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
			if (bFirstTime)
				DisplayContentData ();
			bFirstTime = false;
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