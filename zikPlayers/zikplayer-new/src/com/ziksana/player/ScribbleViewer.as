package com.ziksana.player
{
	import com.nocircleno.graffiti.GraffitiCanvas;
	import com.nocircleno.graffiti.tools.ITool;
	import com.ziksana.content.Content;
	import com.ziksana.player.ContentViewer;
	import com.ziksana.recorder.ScribbleTool;
	import com.ziksana.util.Logger;
	
	import flash.display.MovieClip;
	
	public class ScribbleViewer extends ContentViewer
	{
		private var m_Container : MovieClip = new MovieClip();
		
		public function ScribbleViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			RegisterEvents();
		}
		
		public override function Load () : void
		{
		}
		
		
		public override function RegisterEvents () : void
		{
		}
		
		public function SetPanelCoordinates (panelType : uint, left : int, top : int, width : int, height : int) : void
		{
		}
		
	}
}