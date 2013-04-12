package com.Ziksana.Player
{
	import flash.display.Bitmap;
	import flash.display.MovieClip;
	import flash.display.Sprite;

	public class Scribbler
	{
		private static const TOOL_TYPE_NONE : uint = 0;
		private static const TOOL_TYPE_CIRCLE : uint = 1;
		private static const TOOL_TYPE_SQUARE : uint = 2;
		private static const TOOL_TYPE_PENCIL : uint = 3;
		private static const TOOL_TYPE_ERASER : uint = 4;
		private static const TOOL_TYPE_ARROW : uint = 5;
		private static const TOOL_TYPE_SETTINGS : uint = 6;
		
		private static const TOOL_INDEX_CIRCLE : uint = 0;
		private static const TOOL_INDEX_SQUARE : uint = 1;
		private static const TOOL_INDEX_PENCIL : uint = 2;
		private static const TOOL_INDEX_ERASER : uint = 3;
		private static const TOOL_INDEX_ARROW : uint = 4;
		private static const TOOL_INDEX_SETTINGS : uint = 5;
		
		//Circle
		[Embed(source='../../../../resources/CircleTool.png')]
		public static var TOOL_CIRCLE:Class;
		
		//Square
		[Embed(source='../../../../resources/SquareTool.png')]
		public static var TOOL_SQUARE:Class;

		//Pencil
		[Embed(source='../../../../resources/PencilTool.png')]
		public static var TOOL_PENCIL:Class;
		
		//Eraser
		[Embed(source='../../../../resources/CircleTool.png')]
		public static var TOOL_ERASER:Class;

		//Arrow
		[Embed(source='../../../../resources/CircleTool.png')]
		public static var TOOL_ARROW:Class;
		
		//Settings
		[Embed(source='../../../../resources/CircleTool.png')]
		public static var TOOL_SETTINGS:Class;
		
		private var m_Scribbler : MovieClip = new MovieClip();
		private var m_CircleTool : Sprite = null;
		private var m_SquareTool : Sprite = null;
		private var m_PencilTool : Sprite = null;
		private var m_EraserTool : Sprite = null;
		private var m_ArrowTool : Sprite = null;
		private var m_SettingsTool : Sprite = null;
		
		private var m_SelectedTool : uint =  TOOL_TYPE_NONE;
		
		public function Scribbler()
		{
		}
		
		public function InitScribbler () : void
		{
			//Create all the tools
			m_CircleTool = CreateTool (new TOOL_CIRCLE());
			m_SquareTool = CreateTool (new TOOL_SQUARE());
			m_PencilTool = CreateTool (new TOOL_PENCIL());
			m_EraserTool = CreateTool (new TOOL_ERASER());
			m_ArrowTool = CreateTool (new TOOL_ARROW());
			m_SettingsTool = CreateTool (new TOOL_SETTINGS());
			
			//Add these tools here.
			m_Scribbler.addChildAt(m_CircleTool, TOOL_INDEX_CIRCLE);
			m_Scribbler.addChildAt(m_SquareTool, TOOL_INDEX_SQUARE);
			m_Scribbler.addChildAt(m_PencilTool, TOOL_INDEX_PENCIL);
			m_Scribbler.addChildAt(m_EraserTool, TOOL_INDEX_ERASER);
			m_Scribbler.addChildAt(m_ArrowTool, TOOL_INDEX_ARROW);
			m_Scribbler.addChildAt(m_SettingsTool, TOOL_INDEX_SETTINGS);
		}
		
		private function CreateTool (buttonClass : Class) : Sprite
		{
			var buttonSprite : Sprite = new Sprite();
			var toolBitmap : Bitmap = Bitmap (buttonClass);
			
			toolBitmap.x=0;
			toolBitmap.y=0;
			
			buttonSprite.addChild(toolBitmap);
			
			return buttonSprite;
		}
		
		private function SelectTool (toolToSelect : uint) : void
		{
			m_SelectedTool = toolToSelect;
		}
	}
}