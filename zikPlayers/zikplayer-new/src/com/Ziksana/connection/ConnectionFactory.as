package com.ziksana.connection
{

	public class ConnectionFactory
	{
		public function ConnectionFactory()
		{
			//Do some initialization here
		}
		
		static public function CreateConnection (typeOfConnection : int) : IConnection
		{
			var connectionObj : IConnection = null;
			if (typeOfConnection == ConnectionType.CONNECTION_TYPE_RTMP)
				connectionObj = new RTMPConnection();
			
			if (!connectionObj)
				return null;
			
			return connectionObj;
		}
	}
}