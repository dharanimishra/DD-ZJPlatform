package com.Ziksana.Player
{
	import flash.display.Graphics;
	import flash.display.MovieClip;
	
	public class PlayerSkin
	{
		public static const DEFAULT_MARGIN : int = 5;
	
		public function PlayerSkin()
		{
		}
		
		public static function DrawRectangle (displayObject : MovieClip, backgroundColor : uint, x : int, y : int, width : int, height : int) : void
		{
			var g : Graphics = displayObject.graphics;
			g.beginFill (backgroundColor, 1);
			g.drawRect (x, y, width, height);
			g.endFill ();
		}
		
		public static function DrawRoundRectangle (displayObject : MovieClip, backgroundColor : uint, borderColor : uint, x : int, y : int, width : int, height : int, 
											  leftMargin : int = DEFAULT_MARGIN, topMargin : int = DEFAULT_MARGIN) : void
		{
			var g : Graphics = displayObject.graphics;
			g.beginFill (borderColor, 1);
			//g.drawRoundRectComplex(x, y, width, height, 5, 5, 5, 5);
			g.endFill ();
			
			
			g.beginFill (backgroundColor, 1);
			//g.drawRoundRectComplex  (leftMargin, topMargin, width-2*leftMargin, height - 2*topMargin, 5, 5, 5, 5);
			g.endFill ();
		}
	}
}