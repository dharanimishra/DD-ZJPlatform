package com.ziksana.content
{
	
	public class ScribbleContent extends Content
	{
		private var m_ScribbleData:Array = new Array();
		
		public function ScribbleContent()
		{
			super.SetContentType(ContentType.CONTENT_TYPE_SCRIBBLEDATA);
			super.SetContentDescription(ContentType.CONTENT_TYPE_SCRIBBLEDATA_STRING);
		}
		
		public override function Load() : Boolean
		{
			super.Load();
			return true;
		}
		
		public override function GetData () : Object
		{
			return m_ScribbleData[m_CurrentPosition];
		}
		
		//NAVIGATION STUFF
		public override function GetNumberOfPosition () : Number
		{
			return m_NumberOfPosition;
		}
		
		public override function SetNumberOfPosition (numberOfPosition : Number) : void
		{
			m_NumberOfPosition = numberOfPosition;
		}
		
		public override function GetCurrentPosition () : Number
		{
			return m_CurrentPosition;			
		}
		
		public override function SetCurrentPosition (currentPosition : Number) : void
		{
			if ((currentPosition >= 0) && (currentPosition < m_NumberOfPosition))
				m_CurrentPosition = currentPosition;
			
			//Move the current data pointer here.
		}
	}
}
