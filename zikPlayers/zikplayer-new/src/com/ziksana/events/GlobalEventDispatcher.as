package com.ziksana.events
{
	import com.ziksana.util.Logger;
	import flash.utils.Dictionary;
	import flash.events.EventDispatcher;
	
	public class GlobalEventDispatcher extends EventDispatcher
	{
		private static var _instance:GlobalEventDispatcher;
		
		public static function get instance():GlobalEventDispatcher
		{
			if (_instance == null)
			{
				_instance = new GlobalEventDispatcher();
			}
			return _instance;
		}
		
		public function GlobalEventDispatcher():void
		{
			if (_instance != null) throw new Error("You can't create Singleton twice!");
		}
		
		private var _globalListeners:Object = new Object();
		
		public function addGlobalListener(eventName:String, listener:Function):void {
			_globalListeners[eventName] = listener;
		}
		
		public function removeGlobalListener(listener:Function):void {
			delete _globalListeners[listener];
		}
		
		public function dispatch(event:ZEvent) : void {
			var eventTargetObject : Object = _globalListeners[event.GetEventName()];
			if (eventTargetObject)
			{
				var listener:Function = eventTargetObject as Function;
				listener(event);
			}
			
			//return super.dispatchEvent(event);
		} 
		
	}
}