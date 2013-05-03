package com.ziksana.exception
{
	public class NetworkException extends Exception
	{
		private static const ERR_TAG:String = "(NETWORK)";
		
		public function NetworkException()
		{
			super(ERR_TAG+message, errorID);
		}
	}
}