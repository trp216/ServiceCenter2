package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
	
	private ArrayList<Turn> turns;
	
	private ArrayList<User> users;
	
	public Company() {
		turns = new ArrayList<Turn>();
		users = new ArrayList<User>();
	}

	
	public void sortUsersById() {//by bubble sort
		for(int i=users.size();i>0;i--) {
			for(int j=0;j<i-1;j++) {
				if(users.get(j).compareTo(users.get(j+1).getId())==1) {
					User temp = users.get(j);
					users.set(j, users.get(j+1));
					users.set(j+1, temp);
				}
			}
		}
	}
	
	public void sortUsersByFirstName() {//using collections.sort and Comparator
		Collections.sort(users, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				if(o1.getFirstName().compareTo(o2.getFirstName())==0)
					return 0;
				if(o1.getFirstName().compareTo(o2.getFirstName())>0)
					return 1;
				else
					return -1;
			}
			
		});
	}
	
	public String getTurnsReport(String id) {
		User u = searchUser(id);
		int rand = (int)(Math.random() * 2)+1; 
		if(rand ==1) 
			u.sortTurnsByDuration();
		else {
			u.sortTurnsByType();;
		}
		return u.getTurnsReport();
	}

}
