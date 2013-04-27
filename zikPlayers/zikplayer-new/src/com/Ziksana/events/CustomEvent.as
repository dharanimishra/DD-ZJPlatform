package com.ziksana.events
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	public class CustomEvent extends Event
	{
		private var m_EventOwner : EventDispatcher;
		private var m_EventNameToRegister : String;
		private var m_EventParam : Object;
		
		public function CustomEvent(eventNameToRegister : String, eventOwner : EventDispatcher, eventParam : Object)
		{
			super(eventNameToRegister, false, false);
			
			m_EventNameToRegister = eventNameToRegister;
			m_EventOwner = eventOwner;
			m_EventParam = eventParam;
		}
		
		public function DispatchEvent () : void
		{
			m_EventOwner.dispatchEvent(new CustomEvent(m_EventNameToRegister, m_EventOwner, m_EventParam));
		}
		
		public function GetEventName () : String
		{
			return m_EventNameToRegister;
		}
		
		public function GetEventParam () : Object
		{
			return m_EventParam;
		}
		
		public function GetEventOwner () : EventDispatcher
		{
			return m_EventOwner;
		}
	}
}