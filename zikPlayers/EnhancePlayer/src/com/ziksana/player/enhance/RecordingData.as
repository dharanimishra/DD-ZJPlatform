package com.ziksana.player.enhance
{
	import flash.utils.getTimer;
	
	public class RecordingData
	{
		public function RecordingData()
		{
		}
		
		private var startTime:Number ;
		private var recording:Boolean = false;
		private var slidesArray:Array = new Array();
		private var eventsArray:Array = new Array();
		public var imagePath:String;
		private var numberOfImages:Number;
		public var startSlideNumber:Number;
		public var hasRecordingData:Boolean = false;
		public var totalTime:Number = 0;
		public var pausedTime:Number = 0;
		public var lastPausedTime:Number = 0;
		private var videoFeedList:Array = new Array();
		protected var lastRestartTime:Number = 0;
		protected var lastRestartSlide:Number = 0;
		protected var videoEndTimes:Array = new Array();
		
		
		public function startRecording(time:Number):void
		{
			trace("Starting to Record");
			startTime = time;
			recording = true;
			hasRecordingData = false;
			eventsArray.length = 0;
		}
		
		public function get StartTime():Number {
			return startTime;
		}
		public function reRecordFrom(slideNumber:Number, reStartTime:Number, lRT:Number):void
		{
			eventsArray.length=slideNumber;
			recording = true;
			hasRecordingData = false;
			lastRestartSlide = slideNumber-1;
			lastRestartTime = lRT;
			totalTime =  reStartTime;
		}
		
		public function addEndTime(endTime:Number):Number
		{
			trace("Added END TIME:" + endTime);
			videoEndTimes[videoEndTimes.length] = endTime;
			return (videoEndTimes.length-1);
		}
		
		public function getEndTime(number:Number):Number
		{
			if(number<videoEndTimes.length)
			return videoEndTimes[number];
			else return null;
		}
		
		public function addVideoFeed(videoName:String):Number
		{
			videoFeedList[videoFeedList.length] = videoName;
			trace("ADDED VIDEO"+videoName );
			return (videoFeedList.length-1);
		}
		
		public function getVideoFeed(number:Number):String
		{
			if(number<videoFeedList.length)
				return videoFeedList[number];
			else return null;
		}
		
		public function startSlide(sn:Number):void
		{
			startSlideNumber = sn;
		}
		public function stopRecording(tT:Number):void
		{
			recording = false;
			hasRecordingData = true;
			//if(lastRestartTime > 0 )
			//totalTime +=  getTimer()-lastRestartTime;
			//else totalTime = getTimer() - startTime;
			totalTime = tT;
			trace(totalTime);
			lastRestartTime = 0;
		}
		
		public function stopRecordingFromFile(tT:Number):void
		{
			recording = false;
			hasRecordingData = true;
			totalTime=tT;
			//trace(totalTime);
			lastRestartTime = 0;
		}
		
		public function pauseRecording():void
		{
			 lastPausedTime = getTimer();	
			 recording = false;
			 hasRecordingData = true;
			 if(lastRestartTime > 0 )
				totalTime += getTimer() - lastRestartTime;
			 else
			 	totalTime += getTimer() - startTime;
		}
		
		public function resumeRecording():void
		{
			lastRestartTime = getTimer();	
			recording = true;
			hasRecordingData = false;
			lastRestartSlide = eventsArray.length - 1 ;
		}
		public function ImagePath(ip:String):void
		{
			imagePath = ip;
		}
		
		public function  NumberOfImages(noi:Number):void
		{
			numberOfImages = noi;
		}
		
		public function get isRecording():Boolean {
			return recording;
		}

		public function AddEventFromFile(re:RecordEvent):void {
			eventsArray[eventsArray.length] = re;
		}

		public function AddEvent(re:RecordEvent):void {
			//trace("Added Event" + re.eventX);
			//re.eventTime -= pausedTime;
			/*if(lastRestartTime>0)
			{
				re.eventTime=totalTime+(re.eventTime - lastRestartTime);
			}
			else 
			{ 
				re.eventTime=(re.eventTime - startTime);
			}*/
			//trace(re.eventTime);
			eventsArray[eventsArray.length] = re;
		}
		
		public   function getEvent(index:Number):RecordEvent {
			if(index<eventsArray.length)
				return eventsArray[index] as RecordEvent;
			return null;
		}
		
	}
}