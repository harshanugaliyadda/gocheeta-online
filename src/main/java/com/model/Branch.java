package com.model;

public class Branch {
     private int id;
     private String branchName;
     
     
       
	public Branch() {
		super();
	   
	}

	public Branch(int id, String branchName) {
		super();
		this.id = id;
		this.branchName = branchName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
     
	
     
     
	

}