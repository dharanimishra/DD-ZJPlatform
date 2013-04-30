package com.ziksana.player
{
	import com.ziksana.content.Content;
	import flash.display.MovieClip;

	public class ScribbleViewer extends ContentViewer
	{
		public function ScribbleViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			InitScribbler ();
		}
		
		private function InitScribbler () : void
		{
		}
	}
}