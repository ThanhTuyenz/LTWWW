package iuh.fit.se.entities;

public class Address {
	private int id;
	private String address;
	private Employee employee;

	public Address() {
	}

	public Address(int id, String address, Employee employee) {
		this.id = id;
		this.address = address;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", employee=" + employee + "]";
	}

}
