package com.ziksana.player.enhance
{
	public class RecordEvent
	{
		public static const MOUSE_DOWN:uint = 0;
		public static const MOUSE_MOVE:uint = 1;
		public static const MOUSE_UP:uint = 2;
		public static const SLIDE_NEXT:uint = 3;
		public static const SLIDE_PREV:uint = 4;
		public static const VIDEO_SWITCH:uint = 5;
		
		public var eventType:uint;
		public var eventX:Number;
		public var eventY:Number;
		public var ctrlKeyPressed:Boolean;
		public var eventTool:uint;
		public var eventTime:Number;
		
		
		public function RecordEvent(eT:uint, x:Number, y:Number, ctrlKey:Boolean, toolSelected:uint, time:Number)
		{
			eventType = eT;
			eventX = x;
			eventY = y;
			ctrlKeyPressed = ctrlKey;
			eventTool = toolSelected;
			eventTime = time;
		}
	}
}