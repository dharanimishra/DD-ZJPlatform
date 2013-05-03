package com.ziksana.recorder
{
	import com.nocircleno.graffiti.tools.BitmapTool;
	import com.nocircleno.graffiti.tools.BrushTool;
	import com.nocircleno.graffiti.tools.BrushType;
	import com.nocircleno.graffiti.tools.ITool;
	import com.nocircleno.graffiti.tools.LineTool;
	import com.nocircleno.graffiti.tools.LineType;
	import com.nocircleno.graffiti.tools.ShapeTool;
	import com.nocircleno.graffiti.tools.ShapeType;
	import com.nocircleno.graffiti.tools.TextSettings;
	import com.nocircleno.graffiti.tools.TextTool;
	import com.nocircleno.graffiti.tools.ToolMode;
	import com.ziksana.util.Util;
	
	import flash.display.Bitmap;
	import flash.display.MovieClip;
	import flash.text.Font;
	import flash.text.TextFormat;
	
	
	
	public class ScribbleTool
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

		private var m_BrushSize:Number = 4;
		private var m_StrokeColor:uint = uint(Util.RGBToHex(239, 228, 176));
		private var m_FillColor:uint = 0;
		private var m_StrokeAlpha:Number = 1;
		private var m_FillAlpha:Number = 0;
		private var m_BrushBlur:Number = 0;
		private var m_FontColor:uint = uint(Util.RGBToHex(255, 255, 255));;
		private var m_FontSize:uint = 20;
		private var m_FontsList:Array = null;
		
		public static const SCRIBBLE_TOOL_BRUSH : int = 0;
		public static const SCRIBBLE_TOOL_ERASER : int = 1; 
		public static const SCRIBBLE_TOOL_LINE :  int = 2;
		public static const SCRIBBLE_TOOL_CIRCLE : int = 3;
		public static const SCRIBBLE_TOOL_SQUARE : int = 4;
		public static const SCRIBBLE_TOOL_TEXT : int = 5;
		public static const SCRIBBLE_TOOL_SETTINGS : int = 6;
		
		public function ScribbleTool()
		{
			m_FontsList = Font.enumerateFonts(true);
			m_FontsList.sortOn("fontName", Array.CASEINSENSITIVE);
		}
		
		public function CreateToolButton (toolType : int, left : int, top : int, width : int, height : int) : MovieClip
		{
			var toolButton : MovieClip;
			
			switch (toolType)
			{
				case SCRIBBLE_TOOL_BRUSH :
					toolButton = CreateToolBoxButton(left, top, width, height, new TOOL_BRUSH());
					break;
				case SCRIBBLE_TOOL_ERASER :
					toolButton = CreateToolBoxButton(left, top, width, height, new TOOL_ERASER());
					break;
				case SCRIBBLE_TOOL_LINE : 
					toolButton = CreateToolBoxButton(left, top, width, height, new TOOL_LINE());
					break;
				case SCRIBBLE_TOOL_CIRCLE : 
					toolButton = CreateToolBoxButton(left, top, width, height, new TOOL_CIRCLE());
					break;
				case SCRIBBLE_TOOL_SQUARE : 
					toolButton = CreateToolBoxButton(left, top, width, height, new TOOL_SQUARE());
					break;
				case SCRIBBLE_TOOL_TEXT :
					toolButton = CreateToolBoxButton(left, top, width, height, new TOOL_TEXT());
					break;
				case SCRIBBLE_TOOL_SETTINGS : 
					toolButton = CreateToolBoxButton(left, top, width, height, new TOOL_SETTINGS());
					break;
			}
			
			return toolButton;
		}
		
		public function CreateTool (toolType : int, left : int, top : int, width : int, height : int) : ITool
		{
			var grafitiTool : ITool = null;
			
			switch (toolType)
			{
				case SCRIBBLE_TOOL_BRUSH :
					grafitiTool = new BrushTool(m_BrushSize, m_FillColor, 1, m_BrushBlur, BrushType.ROUND);
					break;
				case SCRIBBLE_TOOL_ERASER :
					grafitiTool = new BrushTool(m_BrushSize, m_FillColor, 1, m_BrushBlur, BrushType.ROUND, ToolMode.ERASE);
					break;
				case SCRIBBLE_TOOL_LINE : 
					grafitiTool = new LineTool(2, m_StrokeColor, m_StrokeAlpha, LineType.SOLID);
					break;
				case SCRIBBLE_TOOL_CIRCLE : 
					grafitiTool = new ShapeTool(2, m_StrokeColor, m_FillColor, m_StrokeAlpha, m_FillAlpha, ShapeType.CIRCLE);
					break;
				case SCRIBBLE_TOOL_SQUARE : 
					grafitiTool = new ShapeTool(2, m_StrokeColor, m_FillColor, m_StrokeAlpha, m_FillAlpha, ShapeType.SQUARE);
					break;
				case SCRIBBLE_TOOL_TEXT :
					grafitiTool = new TextTool(new TextSettings(Font(m_FontsList[0]), new TextFormat(null, m_FontSize, m_FontColor)));
					break;
				case SCRIBBLE_TOOL_SETTINGS : 
					break;
			}
			
			return grafitiTool;
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