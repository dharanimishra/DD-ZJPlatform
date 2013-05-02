package com.ziksana.content
{
	public interface ContentGenerator
	{
		function Load () : Boolean;
		function Unload () : void;
		function GetContent () : Content;
		function RegisterOnCompletionEvent (eventName : String) : void
	}
}