package com.ziksana.recorder
{
	import flash.display.Bitmap;
	import flash.display.MovieClip;
	import flash.text.TextFormat;
	import flash.text.Font;
	
	import com.nocircleno.graffiti.tools.ITool;
	import com.nocircleno.graffiti.tools.BitmapTool;
	import com.nocircleno.graffiti.tools.BrushTool;
	import com.nocircleno.graffiti.tools.BrushType;
	import com.nocircleno.graffiti.tools.LineTool;
	import com.nocircleno.graffiti.tools.LineType;
	import com.nocircleno.graffiti.tools.ShapeTool;
	import com.nocircleno.graffiti.tools.ShapeType;
	import com.nocircleno.graffiti.tools.ToolMode;
	import com.nocircleno.graffiti.tools.TextSettings;
	import com.nocircleno.graffiti.tools.TextTool;

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

		private var _brushSize:Number = 2;
		private var _strokeColor:uint = 0x00FF00;
		private var _fillColor:uint = 0xFF0000;
		private var _strokeAlpha:Number = 1;
		private var _fillAlpha:Number = 1;
		private var _brushBlur:Number = 0;
		private var _fontColor:uint = 0x00FF00;
		private var _fontSize:uint = 14;
		//private var _fontList:DataProvider;
		
		public static const SCRIBBLE_TOOL_BRUSH : int = 0;
		public static const SCRIBBLE_TOOL_ERASER : int = 1; 
		public static const SCRIBBLE_TOOL_LINE :  int = 2;
		public static const SCRIBBLE_TOOL_CIRCLE : int = 3;
		public static const SCRIBBLE_TOOL_SQUARE : int = 4;
		public static const SCRIBBLE_TOOL_TEXT : int = 5;
		public static const SCRIBBLE_TOOL_SETTINGS : int = 6;
		
		public function ScribbleTool()
		{
			/*_fontList = new DataProvider();
			
			var embeddedFonts:Array = Font.enumerateFonts(true);
			embeddedFonts.sortOn("fontName", Array.CASEINSENSITIVE);
			
			for (var i:int = 0; i < embeddedFonts.length; i++) {
				_fontList.addItem( {label: embeddedFonts[i].fontName, data: embeddedFonts[i] } );
			}*/
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
					grafitiTool = new BrushTool(_brushSize, _fillColor, _fillAlpha, _brushBlur, BrushType.ROUND);
					break;
				case SCRIBBLE_TOOL_ERASER :
					grafitiTool = new BrushTool(_brushSize, _fillColor, 1, _brushBlur, BrushType.ROUND, ToolMode.ERASE);
					break;
				case SCRIBBLE_TOOL_LINE : 
					grafitiTool = new LineTool(2, _strokeColor, _strokeAlpha, LineType.SOLID);
					break;
				case SCRIBBLE_TOOL_CIRCLE : 
					grafitiTool = new ShapeTool(2, _strokeColor, _fillColor, _strokeAlpha, _fillAlpha, ShapeType.CIRCLE);
					break;
				case SCRIBBLE_TOOL_SQUARE : 
					grafitiTool = new ShapeTool(2, _strokeColor, _fillColor, _strokeAlpha, _fillAlpha, ShapeType.SQUARE);
					break;
				case SCRIBBLE_TOOL_TEXT :
					//grafitiTool = new TextTool(new TextSettings(Font(_fontList.getItemAt(0).data), new TextFormat(null, _fontSize, _fontColor)));
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