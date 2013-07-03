


	//this function set the key/value in session storage if the key is not there
	function putInSessionStorage(key, value){
		if (!sessionStorage.getItem(key))
		  {
			sessionStorage.setItem(key, value);
		  }
	}
	
	// this function retrieves the value for the provided key
	//if not present returns null;
	function getFromSessionStorage(key){
		if (sessionStorage.getItem(key)){
			return sessionStorage.getItem(key);
		}
		else{
			return null;
		}
	}
	
	