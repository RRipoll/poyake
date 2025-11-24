var handleCardZK = function(ccType, ccNumber, ccNumberInputId, cipherPayKey, ccNumberEncryptedTextboxId, ccNumberMaskedTextboxId, openMessageBox, isRecording){
	   
	//console.log("CC Type = " + ccType);
	//console.log("CC Number = " + ccNumber);
	if(ccNumber && ccType){
		if(checkCreditCard(ccNumber, ccType)){
			jq('#' + ccNumberInputId).val(getMaskedPan(ccNumber, true));
			var encryptedCC = getData(ccNumber, cipherPayKey, isRecording);
			if(encryptedCC){
				zk.Widget.$("$"+ccNumberEncryptedTextboxId).setValue(encryptedCC);
				zk.Widget.$("$"+ccNumberEncryptedTextboxId).smartUpdate('value', encryptedCC);
				
				//get maskedpan and set
				var maskedPan = getMaskedPan(ccNumber, false);
				zk.Widget.$("$"+ccNumberMaskedTextboxId).setValue(maskedPan);
				zk.Widget.$("$"+ccNumberMaskedTextboxId).smartUpdate('value', maskedPan);
			}else{
				resetCCNumberZK(ccNumberInputId, ccNumberEncryptedTextboxId, ccNumberMaskedTextboxId, openMessageBox, true);
			}
			//console.log("ccNumberEncryptedTextboxId: " + zk.Widget.$("$"+ccNumberEncryptedTextboxId).getValue());
			//console.log("ccNumberMaskedTextboxId: " + zk.Widget.$("$"+ccNumberMaskedTextboxId).getValue());
		}else{
			resetCCNumberZK(ccNumberInputId, ccNumberEncryptedTextboxId, ccNumberMaskedTextboxId, openMessageBox, true);
		}
	}else{
		resetCCNumberZK(ccNumberInputId, ccNumberEncryptedTextboxId, ccNumberMaskedTextboxId,  openMessageBox, false);
	}
};

var resetCCNumberZK = function(ccNumberInputId, ccNumberEncryptedTextboxId, ccNumberMaskedTextboxId, openMessageBox, showMessageBox){
	jq('#' + ccNumberInputId).val("");
	zk.Widget.$("$"+ccNumberEncryptedTextboxId).setValue("");
	zk.Widget.$("$"+ccNumberEncryptedTextboxId).smartUpdate('value', "");
	 
	zk.Widget.$("$"+ccNumberMaskedTextboxId).setValue("");
	zk.Widget.$("$"+ccNumberMaskedTextboxId).smartUpdate('value', "");
	
	//console.log("ccNumberEncryptedTextboxId: " + zk.Widget.$("$"+ccNumberEncryptedTextboxId).getValue());
	//console.log("ccNumberMaskedTextboxId: " + zk.Widget.$("$"+ccNumberMaskedTextboxId).getValue());
	//show alert that cc is not valid
	if(showMessageBox){
		zk.Widget.$("$" + openMessageBox).fire('onClick',{}, {toServer:true});
		//zk.Widget.$("$" + ccNumberInputId).setClass("z-textbox-invalid");
	}
	
};

var handleAcctNumberZK = function(acctNumberInputId, acctNumber, acctNumberEncryptedTextboxId, acctMaskedNumberTextboxId, cipherPayKey, openMessageBox, isRecording){
	//console.log('acctNumber = ' + acctNumber);
	if(acctNumber){
		if(validateDirectDebit(acctNumber)){ //valid account number
			jq('#' + acctNumberInputId).val(getMaskedAccountNumber(acctNumber, true));
			var encryptedAcctNumber = getData(acctNumber, cipherPayKey, isRecording);  
		    if(encryptedAcctNumber){
				zk.Widget.$("$"+acctNumberEncryptedTextboxId).setValue(encryptedAcctNumber);
				zk.Widget.$("$"+acctNumberEncryptedTextboxId).smartUpdate('value', encryptedAcctNumber);
				
				//get maskedpan and set
				var maskedAcctNumber = getMaskedAccountNumber(acctNumber, false);
				zk.Widget.$("$"+acctMaskedNumberTextboxId).setValue(maskedAcctNumber);
				zk.Widget.$("$"+acctMaskedNumberTextboxId).smartUpdate('value', maskedAcctNumber);
				
				//console.log('acctNumberPDDEncrypted = ' + zk.Widget.$("$"+acctNumberEncryptedTextboxId).getValue());
				//console.log('acctMaskedNumberTextboxId = ' + zk.Widget.$("$"+acctMaskedNumberTextboxId).getValue());
		    }else{
		      //reset account number	
		    	resetAccountNumberZK(acctNumberInputId, acctNumberEncryptedTextboxId, acctMaskedNumberTextboxId, openMessageBox, true);
		    }
		}else{
			//invalid aaccount number
			//reset account number
			resetAccountNumberZK(acctNumberInputId, acctNumberEncryptedTextboxId, acctMaskedNumberTextboxId, openMessageBox, true);
		}
	}else{
		//reset account number
		resetAccountNumberZK(acctNumberInputId, acctNumberEncryptedTextboxId, acctMaskedNumberTextboxId, openMessageBox, false);
	}
	
};

var resetAccountNumberZK = function(acctNumberInputId, acctNumberEncryptedTextboxId, acctMaskedNumberTextboxId, openMessageBox, showMessageBox){
	jq('#' + acctNumberInputId).val("");
	zk.Widget.$("$"+acctNumberEncryptedTextboxId).setValue("");
	zk.Widget.$("$"+acctNumberEncryptedTextboxId).smartUpdate('value', "");
	
	zk.Widget.$("$"+acctMaskedNumberTextboxId).setValue("");
	zk.Widget.$("$"+acctMaskedNumberTextboxId).smartUpdate('value', "");
	
	//console.log(acctNumberEncryptedTextboxId + " : " + zk.Widget.$("$"+acctNumberEncryptedTextboxId).getValue());
	//console.log(acctMaskedNumberTextboxId + " : " + zk.Widget.$("$"+acctMaskedNumberTextboxId).getValue());
	//show alert that cc is not valid
	if(showMessageBox){
		zk.Widget.$("$"+openMessageBox).fire('onClick',{}, {toServer:true});
		//zk.Widget.$("$" + acctNumberInputId).setClass("z-textbox-invalid");
	}
	
};

var handleRoutingNumberZK = function(routingNumberInputId, routingNumber, routingNumberEncryptedTextboxId, cipherPayKey, openMessageBox, isRecording){
	//console.log('routingNumber = ' + routingNumber);
	if(routingNumber){
		if(validateRoutingNumber(routingNumber)){ //valid routing number
			jq('#' + routingNumberInputId).val(getMaskedRoutingNumber(routingNumber, true));
			var encryptedRoutingNumber = getData(routingNumber, cipherPayKey, isRecording);  
		    if(encryptedRoutingNumber){
				zk.Widget.$("$"+routingNumberEncryptedTextboxId).setValue(encryptedRoutingNumber);
				zk.Widget.$("$"+routingNumberEncryptedTextboxId).smartUpdate('value', encryptedRoutingNumber);
				//console.log(routingNumberEncryptedTextboxId + ' = '  + zk.Widget.$("$"+routingNumberEncryptedTextboxId).getValue());
		    }else{
		      //reset account number	
		    	resetRoutingNumberZK(routingNumberInputId, routingNumberEncryptedTextboxId, openMessageBox, true);
		    }
		}else{
			//invalid aaccount number
			//reset account number
			resetRoutingNumberZK(routingNumberInputId, routingNumberEncryptedTextboxId, openMessageBox, true);
		}
	}else{
		//reset account number
		resetRoutingNumberZK(routingNumberInputId, routingNumberEncryptedTextboxId, openMessageBox, false);
	}
	
};

var resetRoutingNumberZK = function(routingNumberInputId, routingNumberEncryptedTextboxId, openMessageBox, showMessageBox){
	jq('#' + routingNumberInputId).val("");
	zk.Widget.$("$"+routingNumberEncryptedTextboxId).setValue("");
	zk.Widget.$("$"+routingNumberEncryptedTextboxId).smartUpdate('value', "");
	//console.log(routingNumberEncryptedTextboxId + " : " + zk.Widget.$("$"+routingNumberEncryptedTextboxId).getValue());
	//show alert that cc is not valid
	if(showMessageBox){
		zk.Widget.$("$"+openMessageBox).fire('onClick',{}, {toServer:true});
		//zk.Widget.$("$" + routingNumberInputId).setClass("z-textbox-invalid");
	}
	
};

var getData = function(ccNumber, cipherPayKey, isRecording){
	//console.log(isRecording);
	if(isRecording == "1"){
		return ccNumber;
	}else{
		return encrypt(ccNumber, cipherPayKey);
	}
};