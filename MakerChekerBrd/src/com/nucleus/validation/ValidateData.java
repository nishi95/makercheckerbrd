package com.nucleus.validation;

import java.util.HashSet;
import java.util.Set;

public class ValidateData 
{
		Set hs=new HashSet();
	
	public boolean checkCode(String CustomerCode)
	{
		if(hs.add(CustomerCode)&&!CustomerCode.isEmpty()&&CustomerCode.length()<=10)
		{
			return true;
		}
		else
		{
			System.out.println("Error in Customer Code");
			return false;
		}
	}
	public boolean checkName(String CustomerName)
	{
		if(CustomerName.matches("[a-zA-Z0-9 \\s]+") && !CustomerName.isEmpty()&&CustomerName.length()<=30)
		{
			return true;
		}
		else
		{
			System.out.println("Error in Customer name");
			return false;
		}
	}

	public boolean checkAddress(String CustomerAddress1)
	{
		if(!CustomerAddress1.isEmpty())
		{
			return true;
		}
		else 
		{
			System.out.println("Error in Customer address1");
					return false;
		}
	}
	public boolean checkContact(String ContactNumber)
	{
		if(ContactNumber.equals(null)|| ContactNumber.length()==10)
		{
			return true;
		}
		else
		{
			System.out.println("Error in contact number");
			return false;
		}
	}
	public boolean checkPincode(String CustomerPinCode)
	{
		if(!CustomerPinCode.isEmpty() && CustomerPinCode.length()==6)
		{
			return true;
		}
		else if(CustomerPinCode.length()<6)
		{
			System.out.println("Error in Pincode");
			return false;
		}
		else
		{
			
			return false;
		}
		
	}
	
	
	//CheckPincode validation
	
	
	
	
	public boolean checkEmail(String Emailaddress)
	{
		if(!Emailaddress.isEmpty()&& Emailaddress.contains("@") && (Emailaddress.endsWith(".com")|| Emailaddress.endsWith("co.in")||Emailaddress.endsWith(".COM")))
		{
			return true;
		}
		else
		{
			System.out.println("Error in emailaddress");
			return false;
		}
	}
	public boolean checkPrimarycp(String PrimaryContactPerson)
	{
		if(!PrimaryContactPerson.isEmpty())
		{
			return true;
		}
		else
		{
			System.out.println("Error in primarycontactperson");
			return false;
		}
	}
	public boolean checkRecord(String RecordStatus)
	{
		if(RecordStatus.length()==1 && (RecordStatus.equals("N")||RecordStatus.equals("M")||RecordStatus.equals("D")||RecordStatus.equals("A")||RecordStatus.equals("R")))
		{
			return true;
		}
		else 
		{
			System.out.println("Error in recordStatus");
			return false;
		}
	}
	public boolean checkFlag(String Flag)
	{
		if(Flag.length()==1 && (Flag.equals("A")|| Flag.equals("I")))
		{
			return true;
		}
		else
		{
			System.out.println("Error in Flag");
			return false;
		}
	}
	public boolean checkCreatedDate(String CreatedDate)
	{
		if(!CreatedDate.isEmpty())
		{
			return true;
		}
		else
		{
			System.out.println("Error in CreatedDate");
			return false;
		}
	}
	public boolean checkCreatedBy(String CreatedBy)
	{
		if(!CreatedBy.isEmpty())
		{
			return true;
		}
		else
		{
			System.out.println("Error in CreatedBy");
			return false;
		}
	}
	}


