package com.ziksana.util
{
	/** 
	 * XMLParser is the utility class which when given the XML data in the native AS3 format
	 * can parse it into tree data structure and return the same. This can also be extended to use dictionary 
	 * representation of the XML data.
	 * 
	 * @tag XMLParser XML
	 */
	
	public class XMLParser
	{
		private var xmlData:XML = null;
		private var aArray:Object = null;
		
		/**
		 * The constructor takes in a XML data object (Native AS3 XML datatype) and stores it in the property 'xmlData'.
		 */
		public function XMLParser(xmlDataToBeUsed:XML):void
		{
			xmlData = xmlDataToBeUsed;	
		}
		
		/**
		 * Parse() will start parsing the xml data that is being given to the XMLParser. Returns the 
		 * Associative array in the form of rootNode.childNode.ChildValue... etc. If multiple children
		 * of the same name exist it will return the same rootNode.ChildNode, but it will be an array. 
		 */		
		public function parse():Object
		{
			aArray = new Object();
			populateAssociativeArray(aArray, xmlData);
			return aArray;
		}
		
		/**
		 * The internal function used to recursively traverse the XML and add the data and nodes to the
		 * associative array.
		 */
		private function populateAssociativeArray(obj:Object, xml:XML):void
		{
			//Logger.instance.WriteMessage(xml.children().length(), Logger.LOG_LEVEL_ERROR);
			for(var i:int=0; i<xml.children().length(); i++)
			{
				//Logger.instance.WriteMessage("CHILD"+xml.name().toString(), Logger.LOG_LEVEL_ERROR);
				if(xml.child(i).hasComplexContent())
				{
					var childXML:XML = new XML(xml.child(i).toXMLString());
					var tempObj:Object = new Object();
					populateAssociativeArray(tempObj, childXML);
					if(obj[childXML.name()] != null && obj[childXML.name()] is Array)
					{
						obj[childXML.name()].push(tempObj);
					}
					else if (obj[childXML.name()]!=null)
					{
						var temp:Object = obj[childXML.name()];
						obj[childXML.name()] = new Array();
						obj[childXML.name()].push(temp);
						obj[childXML.name()].push(tempObj);						
					}
					else
					obj[childXML.name()] = tempObj;
				}
				else obj[xml.child(i).name()] = xml.child(i);
			}
		}
	}
}