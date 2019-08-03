/**
 * 
 */
var custCodeReg = /[^a-zA-Z0-9]/;
var custNameReg = /[^a-z\sA-Z0-9.,-]/;
var numericReg = /[^0-9]/;
var emailReg =  /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
var primaryContactReg = /[^a-z\sA-Z]/;


function valCustomerCode(){
	var x = document.getElementById("customerCode");
	if(custCodeReg.test(x.value) || x.value.length>10)
	{
		document.getElementById("errorcustcode").innerHTML="Code Length Exceeds 10 characters!!";
		x.style.border= "2px solid red";
		return false;
	}
	else
	{
		x.style.border= "";
		sendInfo();
		return true;
	}
	
}

function valCustomerName(){
	var x = document.getElementById("name");
	if(custNameReg.test(x.value) ||x.value.length>30)
	{
		document.getElementById("errorname").innerHTML="Wrong Name";
		x.style.border= "2px solid red";
		return false;
	}
	x.style.border= "";
	 return true;
}
function valAddress(){
	var x = document.getElementById("address1");
	var y = document.getElementById("address2");
	if(x.value.length>100||y.value.length>100)
	{
		var z ;
		if(x.value.length>100)
		{	
			if(x.value.length>100) 
				z=x;
			else
				z=y;
			document.getElementById("erroraddress1").innerHTML="Wrong Address1";
		}
		else if(x.value.length==0)
		{
			document.getElementById("erroraddress1").innerHTML="Address1 cannot be empty";
		}
		z.style.border= "2px solid red";
		return false;
	}
	x.style.border= "";
	y.style.border= "";
	 return true;
}
function valPinCode(){
	var x = document.getElementById("pincode");
	if(numericReg.test(x.value)|| x.value.length!=6)
	{
		if(numericReg.test(x.value))
			document.getElementById("errorpincode").innerHTML="Only Digits are Allowed";
		else if(x.value.length!=10)
			document.getElementById("errorpincode").innerHTML="Length of Pincode be 6 digits";
		x.style.border= "2px solid red";
		return false;
	}
	x.style.border= "";
	return true;
}

function valEmail(){
	var x = document.getElementById("email");
	if (emailReg.test(x.value) == false || x.value.length>100) 
	{
		document.getElementById("erroremail").innerHTML="Wrong Email";
		x.style.border= "2px solid red";
		return (false);
	}
	x.style.border= "";
 return true;
}

function valContactNum(){
	var x = document.getElementById("contact");
	if(numericReg.test(x.value) || x.value.length!=10 || x.value.length!=0)
	{ 
		if(numericReg.test(x.value))
		{
			document.getElementById("errorcontact").innerHTML="Only Digits are Allowed";
			x.style.border= "2px solid red";
			return false;
		}
		else if(x.value.length!=10)
		{
			document.getElementById("errorcontact").innerHTML="Length of Contact Number must be 10 digits or null";
			x.style.border= "2px solid red";
			return false;
		}
	}
	x.style.border= "";
	return true;
}
function valPrimaryContact(){
	var x = document.getElementById("primarycp");
	if(primaryContactReg.test(x.value) || x.value.length>100)
	{
		document.getElementById("errorpriconper").innerHTML="Wrong Primary Contact Person";
		x.style.border= "2px solid red";
		
		return false;
	}
	x.style.border= "";
	 return true;
}

function validateForm(){	
	var a = valCustomerCode();	
	var b = valCustomerName();	
	var c = valAddress();
	var d = valPinCode();
	var e = valEmail();
	var f =  valContactNum();
	var g = valPrimaryContact();
	if(a && b && c && d && e && f && g){
		return true;
		}
	alert("Input field marked red are not correct. Fill the form again with correct details !!!");
	return false;
}