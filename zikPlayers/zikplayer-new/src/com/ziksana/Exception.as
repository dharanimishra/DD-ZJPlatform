package com.ziksana.player
{
	public class Exception extends Error
	{
		private static const ERR_TAG:String = "(ZIKSANA)";
		
		public function Exception(message:String, errorID:int)
		{
			super(ERR_TAG+message, errorID);
		}
	}
}