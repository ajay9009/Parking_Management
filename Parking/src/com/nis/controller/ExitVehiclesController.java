package com.nis.controller;

import com.nis.dao.DbHelper;
import com.nis.model.ExitVehicles;
import com.nis.model.Vehicles;

public class ExitVehiclesController {
	public static boolean addNewRecord(ExitVehicles V)
	{try{
	 String query="insert into exitvehicles(employeeid,vehicleid,exitdate,exittime)values("+V.getEmployeeid()+","+V.getVehicleid()+",'"+V.getExitdate()+"','"+V.getExittime()+"')";
			  
	 System.out.println(query);
	 boolean status=DbHelper.executeUpdate(query);
	 return(status);
		
	}catch(Exception e)
	{ System.out.println("Error:addNewRecord()"+e);
		}
	return(false);	

	}

}
