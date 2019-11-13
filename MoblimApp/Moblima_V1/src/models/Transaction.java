package models;



public class Transaction {
	protected int id;
	protected String tid;
	protected Double total;
	protected String mobile;
	protected String email;
	protected String name;
	
	


	public Transaction(int id, String tid, String name, String email, String mobile, Double total) {
		this.name = name;
		this.mobile = mobile;
		this.id = id;
		this.tid = tid;
		this.total = total;
		this.email = email;
		
		
	}

	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public String getTid() {
		return tid;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
