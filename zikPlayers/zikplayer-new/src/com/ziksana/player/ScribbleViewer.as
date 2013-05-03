package com.ziksana.player
{
	import com.nocircleno.graffiti.GraffitiCanvas;
	import com.ziksana.content.Content;
	import com.ziksana.player.ContentViewer;
	import com.ziksana.util.Logger;
	
	import flash.display.Bitmap;
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	import com.nocircleno.graffiti.tools.BrushTool;
	import com.nocircleno.graffiti.tools.BrushType;
	
	public class ScribbleViewer extends ContentViewer
	{
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
		
		private var m_Scribbler : MovieClip = new MovieClip();
		private var m_ToolBar : MovieClip = new MovieClip();
		private var m_ToolButtons : Array = new Array ();
		private var m_Canvas : GraffitiCanvas = null;
		
		
		private var m_ToolBar_left : uint = 0;
		private var m_ToolBar_top : uint = 0;
		private var m_ToolBar_width : uint = 0;
		private var m_ToolBar_height : uint = 0;

		private var m_AnnotationList_left : uint = 0;
		private var m_AnnotationList_top : uint = 0;
		private var m_AnnotationList_width : uint = 0;
		private var m_AnnotationList_height : uint = 0;

		private var m_ScriptPad_left : uint = 0;
		private var m_ScriptPad_top : uint = 0;
		private var m_ScriptPad_width : uint = 0;
		private var m_ScriptPad_height : uint = 0;
		
		
		public static const PANEL_TYPE_TOOLS : uint = 0;
		public static const PANEL_TYPE_ANOTATIONLIST : uint = 0;
		public static const PANEL_TYPE_SCRIPTPAD : uint = 0;
		
		private var m_BrushTool:BrushTool = null;

		public function ScribbleViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			RegisterEvents();
		}
		
		public override function Load () : void
		{
			InitScribbler ();
		}
		
		private function InitScribbler () : void
		{
			m_ContentDisplayObject.addChild(m_Scribbler);
			
			CreateToolBar ();
			CreateToolsPanel();
			CreateAnnotationList ();
			CreateScriptPad ();
			
			DrawUI ();
		}
		
		private function CreateToolBar () : void
		{
			m_ToolBar = new MovieClip ();
		}
		
		private function CreateToolsPanel () : void
		{
			var toolButton : MovieClip;
			var toolButtonWidth : int = 65;
			var toolButtonHeight : int = 50;
			var left : int;
			var top : int;
			
			left = 10;
			top = 10;
			
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
		}
		
		private function DrawUI () : void
		{
			var toolButtonWidth : int = 65;
			var toolButtonHeight : int = 50;
			
			var opacity : Number = 0;
			var backgroundColor : uint = 0x0999999;
			var buttonColor : uint = 0x060101;
			
			
			m_Canvas = new GraffitiCanvas(m_Width, m_Height, 10);
			m_Canvas.x = m_Left;
			m_Canvas.y = m_Top;
			
			m_BrushTool = new BrushTool(8, 0xFF0000, 1, 0, BrushType.DIAMOND);
			m_Canvas.activeTool = m_BrushTool;
			
			m_Scribbler.addChild(m_Canvas);
			
			//m_Scribbler.graphics.clear();
			//m_Scribbler.graphics.beginFill(backgroundColor, opacity);
			//m_Scribbler.graphics.drawRect(0, 0, m_Width, m_Height);
			//m_Scribbler.graphics.endFill();
			
			for (var currentToolButton : int = 0; currentToolButton < m_ToolButtons.length; currentToolButton++)
			{
				m_Scribbler.graphics.beginFill(buttonColor, opacity);
				m_Scribbler.graphics.drawRect(0, (currentToolButton * toolButtonHeight), toolButtonWidth, toolButtonHeight-2);
				m_Scribbler.graphics.endFill();
				
				m_ToolBar.addChildAt(m_ToolButtons[currentToolButton], currentToolButton);
			}
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
		
		public function CreateAnnotationList () : void
		{
			
		}
		
		public function CreateScriptPad () : void
		{
			
		}
		
		public override function RegisterEvents () : void
		{
			m_ToolBar.addEventListener (MouseEvent.MOUSE_DOWN, OnPageContainerMouseDown);
			m_ToolBar.addEventListener (MouseEvent.MOUSE_MOVE, OnPageContainerMouseMove);
			m_ToolBar.addEventListener (MouseEvent.MOUSE_UP, OnPageContainerMouseUp);
			m_ToolBar.addEventListener (MouseEvent.MOUSE_OUT, OnPageContainerMouseOut);
		}
		
		public function SetPanelCoordinates (panelType : uint, left : int, top : int, width : int, height : int) : void
		{
			if (panelType == PANEL_TYPE_TOOLS)
			{
				m_ToolBar_left = left;
				m_ToolBar_top = top;
				m_ToolBar_width = width;
				m_ToolBar_height = height;
			}
			else if (panelType == PANEL_TYPE_ANOTATIONLIST)
			{
				m_AnnotationList_left = left;
				m_AnnotationList_top = top;
				m_AnnotationList_width = width;
				m_AnnotationList_height = height;
			}
			else if (panelType == PANEL_TYPE_SCRIPTPAD)
			{
				m_ScriptPad_left = left;
				m_ScriptPad_top = top;
				m_ScriptPad_width = width;
				m_ScriptPad_height = height;
			}
		}
		
		public override function SetVisible (visible : Boolean) : void
		{
			m_Scribbler.visible = visible;
			//m_ToolBar.visible = visible; 
		}
		
		private function OnPageContainerMouseDown (mouseEvent : MouseEvent) : void 
		{
			//Logger.instance.WriteMessage("ScribbleViewer::OnMouseDown ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY); 
		}
		
		private function OnPageContainerMouseUp (mouseEvent : MouseEvent) : void 
		{
			//Logger.instance.WriteMessage("ScribbleViewer::OnMouseUp ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
		}
		
		private function OnPageContainerMouseMove (mouseEvent : MouseEvent) : void 
		{
			//Logger.instance.WriteMessage("ScribbleViewer::OnMouseMove ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
			//if (mouseEvent.localX <= 5)
			//	SetVisible(true);
		}
		
		private function OnPageContainerMouseOut (mouseEvent : MouseEvent) : void 
		{
			Logger.instance.WriteMessage("ScribbleViewer::OnMouseOut ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
			SetVisible(false);
		}
	}
}