package com.ziksana.util
{
	import flash.utils.Timer;
	import flash.events.TimerEvent;
	import flash.utils.getTimer;

	public class ActivityMonitor
	{
		//2 Seconds beat interval
		public static const HEARTBEAT_INTERVAL : Number = (2000 * 60);
		public var m_LastActivityTime : Number = 0;
		private var m_HeartBeatTimer:Timer = new Timer(HEARTBEAT_INTERVAL, 0);
		

		public function ActivityMonitor()
		{
			m_HeartBeatTimer.addEventListener(TimerEvent.TIMER, OnTimerEvent);
			m_HeartBeatTimer.addEventListener(TimerEvent.TIMER_COMPLETE, OnTimerComplete);
		}
		
		public function StartHeartBeat() : void
		{
			m_LastActivityTime = getTimer();
			m_HeartBeatTimer.start();
		}
		
		public function StopHeartBeat () : void
		{
			m_HeartBeatTimer.stop();
			m_LastActivityTime = 0;
		}
		
		public function HeartBeat () : void
		{
			//
			var currentTime : Number;
			currentTime = getTimer();
			var dwDelta : Number;
			
			dwDelta = currentTime - m_LastActivityTime;
			
			if (dwDelta > HEARTBEAT_INTERVAL)
			{
				m_LastActivityTime = currentTime;
				//Decide here to update to java..
			}
		}
		
		
		private function OnTimerEvent (event:TimerEvent) : void
		{
			HeartBeat ();
		}
		
		private function OnTimerComplete (event:TimerEvent):void
		{
		}	
	}
}