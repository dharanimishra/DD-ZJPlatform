package com.ziksana.recorder
{
	import com.ziksana.content.Content;

	public interface ContentGenerator
	{
		function Load () : Boolean;
		function Unload () : void;
		function GetContent () : Content;
		function RegisterOnCompletionEvent (eventName : String) : void
	}
}