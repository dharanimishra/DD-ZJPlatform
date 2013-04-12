package com.Ziksana.Player
{
	import flash.display.MovieClip;

	public class LiveViewer extends ContentViewer
	{
		public function LiveViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
		}
		
		public override function SetCoordinates (width : Number, height : Number) : void
		{
			
		}
	}
}