package com.ziksana.recorder
{
	import com.nocircleno.graffiti.GraffitiCanvas;
	import com.nocircleno.graffiti.display.Text;
	import com.nocircleno.graffiti.tools.ITool;
	import com.ziksana.content.Content;
	import com.ziksana.content.ScribbleContent;
	import com.ziksana.recorder.ScribbleTool;
	import com.ziksana.util.Logger;
	
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	import flash.text.TextField;
	import flash.text.TextFormat;

	public class ScribbleRecorder extends ContentRecorder
	{
		private var m_Container : MovieClip = new MovieClip();
		private var m_ScribbleContent : ScribbleContent;
		private var m_GraffitiTool : ScribbleTool = new ScribbleTool ();
		private var m_ToolBar : MovieClip = new MovieClip();
		private var m_ToolButtonsArray : Array = new Array ();
		private var m_ToolsArray : Array = new Array ();
		
		private var m_Canvas : GraffitiCanvas = null;
		
		private static const m_ToolTypesArray : Array = 
			new Array (ScribbleTool.SCRIBBLE_TOOL_BRUSH, ScribbleTool.SCRIBBLE_TOOL_ERASER, 
				ScribbleTool.SCRIBBLE_TOOL_LINE, ScribbleTool.SCRIBBLE_TOOL_CIRCLE,
				ScribbleTool.SCRIBBLE_TOOL_SQUARE, ScribbleTool.SCRIBBLE_TOOL_TEXT,
				ScribbleTool.SCRIBBLE_TOOL_SETTINGS);
		
		
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
		
		public function ScribbleRecorder (contentDisplayObject : MovieClip)
		{
			super (contentDisplayObject);
		}
		
		public override function Load () : Boolean
		{
			InitScribbler ();
			return true;
		}
		
		public override function Unload () : void
		{
		}
		
		public override function GetContent () : Content
		{
			return m_ScribbleContent;
		}
		
		public override function RegisterOnCompletionEvent (eventName : String) : void
		{
		}
		
		private function InitScribbler () : void
		{
			m_ContentDisplayObject.addChild(m_Container);
			
			CreateScribblingTools();
			CreateToolBar ();
			CreateToolsPanel();
			CreateAnnotationList ();
			CreateScriptPad ();
			
			DrawUI ();
		}
		
		private function CreateToolBar () : void
		{
			m_ToolBar = new MovieClip ();
			m_Container.addChild(m_ToolBar);
		}
		
		private function CreateToolsPanel () : void
		{
			var toolButton : MovieClip;
			var scribbleTool : ITool; 
			
			var toolButtonWidth : int = 55;
			var toolButtonHeight : int = 50;
			var left : int;
			var top : int;
			
			var opacity : Number = 0;
			var backgroundColor : uint = 0x0999999;
			var buttonColor : uint = 0x060101;
			
			left = 10;
			top = 10;
			
			m_ToolBar.graphics.beginFill(0x568ea9,1);
			m_ToolBar.graphics.drawRect(0, 3, toolButtonWidth, 20);
			m_ToolBar.graphics.beginFill(0x214254,1);
			m_ToolBar.graphics.drawRect(3, 3, toolButtonWidth-10, 18);
			m_ToolBar.graphics.endFill();
			var title:TextField = new TextField();
			title.text = "Tools";
			title.defaultTextFormat.bold = true;
			var format:TextFormat = new TextFormat();
			format.size = 18;
			format.color = 0xFFFFFF;
			title.setTextFormat(format);
			title.textColor = 0xFFFFFF;
			title.x = 4;
			title.y = -2;
			m_ToolBar.addChildAt(title,0);
			top = 25;
			
			for (var currentToolButton : int = 0; currentToolButton < m_ToolTypesArray.length; currentToolButton++)
			{
				toolButton = m_GraffitiTool.CreateToolButton (m_ToolTypesArray[currentToolButton], left, top, 0, 0);
				scribbleTool = m_GraffitiTool.CreateTool (m_ToolTypesArray[currentToolButton], left, top, 0, 0);
				
				m_ToolButtonsArray.push(toolButton);
				m_ToolsArray.push(scribbleTool);
				
				top += toolButtonHeight;
				toolButton.addEventListener(MouseEvent.CLICK, OnToolButtonClick);
				
				m_ToolBar.addChildAt(toolButton, currentToolButton+1);
			}
			
			//By default null
			m_Canvas.activeTool = null;
		}
		
		private function SetActiveTool (selectedToolButton : MovieClip) : void
		{
			var toolButton : MovieClip;
			var scribbleTool : ITool; 
			
			for (var currentTool : int = 0; currentTool < m_ToolButtonsArray.length; currentTool++)
			{
				toolButton = m_ToolButtonsArray[currentTool] as MovieClip;
				if (toolButton == selectedToolButton)
				{
					scribbleTool = m_ToolsArray[currentTool];
					if (scribbleTool)
						m_Canvas.activeTool = scribbleTool;
				}
			}
		}
		
		private function CreateScribblingTools () : void
		{
			m_Canvas = new GraffitiCanvas(m_Width, m_Height, 10);
			m_Canvas.x = m_Left;
			m_Canvas.y = m_Top;
			
			m_Container.addChild(m_Canvas);
		}
		
		private function DrawUI () : void
		{
			var toolButtonWidth : int = 55;
			var toolButtonHeight : int = 50;
			
			var opacity : Number = 0.8;
			var backgroundColor : uint = 0x214254;
			var buttonColor : uint = 0x214254;
			
			m_Container.graphics.clear();
			m_Container.graphics.beginFill(backgroundColor, opacity);
			m_Container.graphics.drawRect(m_Left, m_Top, toolButtonWidth, (toolButtonHeight * m_ToolButtonsArray.length));
			m_Container.graphics.endFill();
			
			for (var currentToolButton : int = 0; currentToolButton < m_ToolButtonsArray.length; currentToolButton++)
			{
				m_Container.graphics.beginFill(buttonColor, opacity);
				m_Container.graphics.drawRect(0, (currentToolButton * toolButtonHeight+25), toolButtonWidth, toolButtonHeight-2);
				m_Container.graphics.endFill();
			}
		}
		
		
		public function CreateAnnotationList () : void
		{
			
		}
		
		public function CreateScriptPad () : void
		{
			
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
			m_ToolBar.visible = visible;
		}
		
		private function OnToolButtonClick (mouseEvent : MouseEvent) : void
		{
			var selectedTool : MovieClip = null;
			
			Logger.instance.WriteMessage("ScribbleViewer::OnToolButtonClick ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
			if (mouseEvent.target)
			{
				selectedTool = (mouseEvent.target as MovieClip);
				SetActiveTool(selectedTool);
			}
		}
	}
}