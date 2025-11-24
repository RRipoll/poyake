//It encrypts a text using a public key
var encrypt = function (rawText, key){
	var jsEncrypt = new JSEncrypt();
	jsEncrypt.setPublicKey(key);
	return jsEncrypt.encrypt(rawText);
};

//Masks a credit card number: 
//if starMode == true then it returns stars plus last four digits. 
//Only last four digits are returned if false 
var getMaskedPan = function (ccNumber, starMode=false){
	if(ccNumber === null || ccNumber.length < 13){
		return null;
	}
	
	var lastDigits = ccNumber.substr(ccNumber.length - 4, ccNumber.length);
	
	if(starMode === true){
		return "************" + lastDigits;
	}else{
		return lastDigits;
	}
};


var getMaskedAccountNumber = function (acctNumber, starMode=false){
	if(acctNumber === null || acctNumber.length < 4 || acctNumber.length > 17){
		console.log('invalid length of accoutn number = ' + acctNumber.length);
		return null;
	}
	
	var lastDigits = acctNumber.substr(acctNumber.length - 4, acctNumber.length);
	
	if(starMode === true){
		//return "************" + lastDigits;
		if(acctNumber.length == 4){
			return "****";
		}else if(acctNumber.length > 4){
			var str = "";
			for(var i = 0 ; i < acctNumber.length - 4 ; i++){
				str = str + '*';
			}
			return str + lastDigits;
		}
	}else{
		return lastDigits;
	}
 };
 
 var getMaskedRoutingNumber = function (routingNumber, starMode=false){
		if(routingNumber === null || routingNumber.length != 9){
			console.log('invalid length of routing number = ' + routingNumber.length);
			return null;
		}
		
		var lastDigits = routingNumber.substr(routingNumber.length - 4, routingNumber.length);
		
		if(starMode === true){
			return "*****" + lastDigits;
		}else{
			return lastDigits;
		}
};