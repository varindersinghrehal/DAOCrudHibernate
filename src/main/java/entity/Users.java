package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="users")

	public class Users {
	    @Id
		private int id;
	   
		private String name;
	   
		private String address;
	   
		private String phone;
	   
		private String email;
	
	public Users(int id, String name, String address, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Users(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void printUser() {
		
		System.out.println("ID: "  + this.getId());
		System.out.println("Name: " + this.getName());
		System.out.println("Address: " + this.getAddress());
		System.out.println("Email: " + this.getEmail());
		System.out.println("Phone: " + this.getPhone());
		System.out.println("----------------------------\n");
	}
}
