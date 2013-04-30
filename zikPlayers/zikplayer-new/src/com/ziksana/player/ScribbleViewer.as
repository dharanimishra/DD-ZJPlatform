package com.ziksana.player
{
	import com.nocircleno.graffiti.GraffitiCanvas;
	import com.ziksana.content.Content;
	import com.ziksana.player.ContentViewer;
	
	import flash.display.Bitmap;
	import flash.display.MovieClip;
	
	public class ScribbleViewer extends ContentViewer
	{
		private var m_Scribbler : MovieClip = new MovieClip();
		private var m_ToolBar : MovieClip = new MovieClip();
		private var m_ToolButtons : Array = new Array ();
		
		//Selection
		[Embed(source='../../../../resources/SelectionTool.png')]
		public static var TOOL_SELECTION:Class;

		//Brush
		[Embed(source='../../../../resources/BrushTool.png')]
		public static var TOOL_BRUSH:Class;
		
		//Eraser
		[Embed(source='../../../../resources/EraserTool.png')]
		public static var TOOL_ERASER:Class;

		//Line
		[Embed(source='../../../../resources/LineTool.png')]
		public static var TOOL_LINE:Class;

		//Circle
		[Embed(source='../../../../resources/CircleTool.png')]
		public static var TOOL_CIRCLE:Class;
		
		//Square
		[Embed(source='../../../../resources/SquareTool.png')]
		public static var TOOL_SQUARE:Class;
		
		//Text
		[Embed(source='../../../../resources/TextTool.png')]
		public static var TOOL_TEXT:Class;
		
		//Settings
		[Embed(source='../../../../resources/SettingsTool.png')]
		public static var TOOL_SETTINGS:Class;

		public function ScribbleViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			InitScribbler ();
		}
		
		private function InitScribbler () : void
		{
			m_ContentDisplayObject.addChild(m_Scribbler);
			AddNavigationButtons ();
		}
		public function AddNavigationButtons () : void
		{
			var buttonExist : Boolean = false;
			//if (m_Scribbler.numChildren >= 2)
			//{
			//	buttonExist =  m_Scribbler.getChildAt(TOOL_INDEX_CIRCLE) &&
			//		m_Scribbler.getChildAt(TOOL_INDEX_SQUARE);
			//}
			
			if (!buttonExist)
			{
				CreateToolBar ();
				var toolButton : MovieClip;
				var toolButtonWidth : int = 65;
				var toolButtonHeight : int = 50;
				var left : int;
				var top : int;
				
				
				left = 10;
				top = 57;
				
				m_ToolButtons.push(CreateToolBoxButton(left, top, 0, 0, new TOOL_SELECTION()));
				top += toolButtonHeight;
				m_ToolButtons.push(CreateToolBoxButton(left, top, 0, 0, new TOOL_BRUSH()));
				top += toolButtonHeight;
				m_ToolButtons.push(CreateToolBoxButton(left, top, 0, 0, new TOOL_ERASER()));
				top += toolButtonHeight;
				m_ToolButtons.push(CreateToolBoxButton(left, top, 0, 0, new TOOL_LINE()));
				top += toolButtonHeight;
				m_ToolButtons.push(CreateToolBoxButton(left, top, 0, 0, new TOOL_CIRCLE()));
				top += toolButtonHeight;
				m_ToolButtons.push(CreateToolBoxButton(left, top, 0, 0, new TOOL_SQUARE()));
				top += toolButtonHeight;
				m_ToolButtons.push(CreateToolBoxButton(left, top, 0, 0, new TOOL_TEXT()));
				top += toolButtonHeight;
				m_ToolButtons.push(CreateToolBoxButton(left, top, 0, 0, new TOOL_SETTINGS()));
				top += toolButtonHeight;

				m_Scribbler.addChild(m_ToolBar);
				
				var opacity : Number = 0.8;
				var backgroundColor : uint = 0x0999999;
				var buttonColor : uint = 0x060101;
				
				m_Scribbler.graphics.clear();
				m_Scribbler.graphics.beginFill(backgroundColor, opacity);
				m_Scribbler.graphics.drawRect(0, 0, m_Width, m_Height);
				m_Scribbler.graphics.endFill();
				
				for (var currentToolButton : int = 0; currentToolButton < m_ToolButtons.length; currentToolButton++)
				{
					m_Scribbler.graphics.beginFill(buttonColor, opacity);
					m_Scribbler.graphics.drawRect(0, ((currentToolButton + 1) * toolButtonHeight), toolButtonWidth, toolButtonHeight-2);
					m_Scribbler.graphics.endFill();
					
					m_ToolBar.addChildAt(m_ToolButtons[currentToolButton], currentToolButton);
				}
			}
		}		
		
		private function CreateToolBar () : void
		{
			m_ToolBar = new MovieClip ();
		}
		
		private function CreateToolBoxButton (left : int, top : int, width : int, height : int, buttonBitmap : Bitmap) : MovieClip
		{
			var buttonClip : MovieClip = new MovieClip();
			var buttonBitmpa:Bitmap = buttonBitmap;
			buttonClip.x = left;
			buttonClip.mouseEnabled=true;
			buttonClip.buttonMode=true;
			buttonClip.y=top;
			buttonClip.addChild(buttonBitmap);
			
			return buttonClip;
		}
	}
}