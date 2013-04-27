package com.ziksana.skin
{
	public class SkinParser
	{
		private static var m_BackgroundColor : uint = 0x333333;
		private static var m_SelectionColor : uint = 0xff6600;
		private static var m_BackgroundImage : String = null;
		private static var m_IconColorSet : uint = ICON_COLOR_SET_WHITE;
		private static var m_BorderColor : uint = 0x253257;
		
		public static const ICON_COLOR_SET_BLUE:int = 0;
		public static const ICON_COLOR_SET_BLACK:int = 1; 
		public static const ICON_COLOR_SET_WHITE:int = 2;
		
		public function SkinParser()
		{
		}
		
		public static function GetBackgroundColor () : uint
		{
			return m_BackgroundColor;
		}
		
		public static function GetBackgroundImage () : String
		{
			return m_BackgroundImage;
		}
		
		public static function GetSelectionColor () : uint
		{
			return m_SelectionColor;
		}
		
		public static function GetIconColorSet () : uint
		{
			return m_IconColorSet;
		}
		
		public static function GetBorderColor () : uint
		{
			return m_BorderColor;
		}
	}
}