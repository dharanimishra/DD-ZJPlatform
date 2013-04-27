package com.ziksana.timeline
{
	public interface ITimeLinePosition
	{
		function GetNumberOfPosition () : Number;
		function SetNumberOfPosition (numberOfPosition : Number) : void;
		function GetCurrentPosition () : Number;		
		function SetCurrentPosition (currentPosition : Number) : void;		
	}
}