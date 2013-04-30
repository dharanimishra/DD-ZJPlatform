package com.ziksana.content
{
	public interface ContentGenerator
	{
		function Load () : void;
		function Unload () : void;
		function GetContent () : Content;
	}
}