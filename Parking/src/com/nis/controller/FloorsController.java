package com.nis.controller;

import java.sql.ResultSet;
import java.util.Calendar;

import com.nis.dao.DbHelper;
import com.nis.model.Floors;

public class FloorsController {
public static boolean addNewRecord(Floors F){
try{
	String query="insert into floors values("+F.getFloorid()+",'"+F.getFloorname()+"',"+F.getNumberofspace()+")";
	System.out.println(query);
	boolean status=DbHelper.executeUpdate(query);
	 return(status);
}catch(Exception e){System.out.println("Error:addNewRecord:"+e);}
return(false);
}

public static ResultSet fetchFloors(){
try{
	String query="select * from floors";
	System.out.println(query);
	ResultSet rs=DbHelper.executeQuery(query);
	 return(rs);
}catch(Exception e){System.out.println("Error:fetchFloors:"+e);}
return(null);
}

public static ResultSet fetchTotalSpace(int fid){
try{  Calendar C=Calendar.getInstance();
String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
	String query="select f.totalspace,count(v.floorno) as totalvehicle,(f.totalspace-count(v.floorno)) as avl_space from floors f,vehicles v where v.floorno=f.floorno and  v.floorno="+fid+" and v.currentdate='"+cd+"' group by v.floorno";
	System.out.println(query);
	ResultSet rs=DbHelper.executeQuery(query);
	 return(rs);
}catch(Exception e){System.out.println("Error:fetchFloors:"+e);}
return(null);
}
 }








