package com.ziksana.content
{
	import com.ziksana.events.CustomEvent;
	
	public interface ContentGenerator
	{
		function Load () : Boolean;
		function Unload () : void;
		function GetContent () : Content;
		function RegisterOnCompletionEvent (contentLoadEvent : CustomEvent) : void
	}
}