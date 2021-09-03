package com.nis.controller;

import java.sql.ResultSet;

import com.nis.dao.DbHelper;
import com.nis.model.Vehicles;

public class VehiclesController {
	public static boolean addNewRecord(Vehicles V)
	{try{
	 String query="insert into vehicles(employeeid,referenceid,mobileno,currentdate,currenttime,amount,time,status,floorno,registrationno)values("+V.getEmployeeid()+","+V.getRefernceid()+",'"+V.getMobileno()+"','"+V.getCurrentdate()+"','"+V.getCurrenttime()+"',"+V.getAmount()+",'"+V.getTime()+"','"+V.getStatus()+"',"+V.getFloorno()+",'"+V.getRegistrationno()+"')";
	 System.out.println(query);
	 boolean status=DbHelper.executeUpdate(query);
	 return(status);
		
	}catch(Exception e)
	{ System.out.println("Error:addNewRecord()"+e);
		}
	return(false);	

	}
	
	
	public static boolean deleteRecord(int vid)
	{
		try{
			String query="delete from vehicles where vehicleid="+vid;
			boolean status=DbHelper.executeUpdate(query);
			return(status);
			
		}catch(Exception e){System.out.println("Error:deleteRecord"+e);}
	return(false);	
	}
	
	public static boolean editRecord(Vehicles V)
	{
		try{
			String query="update vehicles set employeeid="+V.getEmployeeid()+",vehicleid="+V.getVehicleid()+",referenceid='"+V.getRefernceid()+"',mobileno='"+V.getMobileno()+"',currentdate='"+V.getCurrentdate()+"',currenttime='"+V.getCurrenttime()+"',amount="+V.getAmount()+",time='"+V.getTime()+"',status='"+V.getStatus()+"',floorno="+V.getFloorno()+" where vehicleid="+V.getVehicleid();
			
			//System.out.println(query);
			boolean status=DbHelper.executeUpdate(query);
			return(status);
		}catch(Exception e){System.out.println("Error:editRecord"+e);}
		return(false);
	}
	
	
	public static ResultSet displayAll()
	{try{
	 String query="select * from vehicles";
	 ResultSet rs=DbHelper.executeQuery(query);
	 return(rs);
		
	}catch(Exception e)
	{ System.out.println("Error:displayAll()"+e);
		}
	return(null);	

	}
	
	
	
	public static Vehicles displayByID(int vid)
	{try{
	 String query="select * from vehicles where vehicleid="+vid;
	 ResultSet rs=DbHelper.executeQuery(query);
	 if(rs.next())
	 {Vehicles V=new Vehicles();
	 V.setEmployeeid(rs.getString(1));
	 V.setVehicleid(rs.getString(2));
	 V.setRefernceid(rs.getString(3));
	 V.setMobileno(rs.getString(4));
	 V.setCurrentdate(rs.getString(5));
	 V.setCurrenttime(rs.getString(6));
	 V.setAmount(rs.getString(7));
	 V.setTime(rs.getString(8));
	 V.setStatus(rs.getString(9));
	 V.setFloorno(rs.getString(10));
	 return(V);
	 }
	 return(null);
	 
	}catch(Exception e)
	{ System.out.println("Error:displayByID()"+e);
		}
	return(null);




	}


public static ResultSet displayByRFID(String rfid)
{try{
 String query="select * from vehicles where referenceid='"+rfid+"' and status='in'";
 ResultSet rs=DbHelper.executeQuery(query);
 return(rs);
 
  
 
}catch(Exception e)
{ System.out.println("Error:displayByID()"+e);
	}
return(null);
}
public static boolean updateStatus(int vid)
{
	try{
		String query="update vehicles set status='out' where vehicleid="+vid;
		
		//System.out.println(query);
		boolean status=DbHelper.executeUpdate(query);
		return(status);
	}catch(Exception e){System.out.println("Error:editRecord"+e);}
	return(false);
}
	
	public static boolean RemoveRFID()
	{
		try{
			String query="delete from rfid";
			
			//System.out.println(query);
			boolean status=DbHelper.executeUpdate(query);
			return(status);
		}catch(Exception e){System.out.println("Error:editRecord"+e);}
		return(false);
}

}



