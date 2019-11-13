package models;

import java.io.*;
import java.util.*;

public class Admin {
	private String adminID;
	private String adminPass;
	private String adminName;
	
	public Admin(String id, String pass, String name){
		this.adminID = id;
		this.adminPass = pass;
		this.adminName = name;
	}
	
	public String getAdminId(){
		return this.adminID;
	}
	public void setAdminId(String S){
		this.adminID = S;
	}
	
	public String getAdminPass(){
		return this.adminPass;
	}
	public void setAdminPass(String S){
		this.adminPass = S;
	}
	
	public String getAdminName(){
		return this.adminName;
	}
	public void setAdminName(String S){
		this.adminName = S;
	}
	
	
	

}
