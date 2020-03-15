package model;

import java.util.ArrayList;

public class User {
	
	public static String ONE =  "CEDULA_DE_CIUDADANIA";
	public static String TWO = "TARJETA_DE_IDENTIDAD";
	public static String THREE = "REGISTRO_CIVIL";
	public static String FOUR = "PASAPORTE";
	public static String FIVE = "CEDULA_DE_EXTRANJERIA";

	private String id;
	private String idtype;
	private String firstName;
	private String lastName;
	private String phone;
	private String dir;
	
	private boolean suspend;
	
	private ArrayList<Turn> absent;
	
	private ArrayList<Turn> uturn;
	
	public User(String id, int idtype, String firstName, String lastName, String phone, String dir) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.dir = dir;
		setIdtype(idtype);
		suspend = false;
		uturn = new ArrayList<Turn>();
		absent = new ArrayList<Turn>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(int idtype) {
		if(idtype == 1)
			this.idtype = ONE;
		else if(idtype == 2)
			this.idtype = TWO;
		else if(idtype == 3)
			this.idtype = THREE;
		else if(idtype == 4)
			this.idtype = FOUR;
		else if(idtype == 5)
			this.idtype = FIVE;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public boolean getSuspend() {
		return suspend;
	}
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}
	public ArrayList<Turn> getAbsent() {
		return absent;
	}
	public ArrayList<Turn> getUturn() {
		return uturn;
	}
	
	public void sortTurnsByType() {
		for(int i=0;i<uturn.size();i++) {
			Turn min = uturn.get(i);
			int which = i;
			for(int j = i+1;j<uturn.size();j++) {
				if(uturn.get(i).getTurntype().compare(uturn.get(j).getTurntype(), min.getTurntype())==-1) {
					min = uturn.get(j);
					which = j;
				}
			}
			Turn temp = uturn.get(i);
			uturn.set(i, min);
			uturn.set(which, temp);
		}
	}
	
	public void suspend() {
		if(absent.size()==2) {
			suspend=true;
			for(int i = 0;i<absent.size();i++) {
				absent.remove(i);
			}
		}
	}
	
	public String getTurnsReportByTurnType() {
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", idtype=" + idtype + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", dir=" + dir + ", uturn=" + uturn + "]";
	}
	
}