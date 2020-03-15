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
	
	public User searchUserByIdBinary(String id) {//using binary search
		boolean found = false;
		User x = null;
		int start = 0;
		int end = users.size()-1;
		while(start<=end &!found) {
			int middle = (start+end)/2;
			if(users.get(middle).getId().compareTo(id)==0) {
				found = true;
				x = users.get(middle);
			}
			else if(users.get(middle).getId().compareTo(id)>0) {
				end = middle-1;
			}
			else {
				start = middle+1;
			}
		}
		return x;
	}
	
	public User searchUser(String id) {
		User x = null;
		boolean found = false;
		for(int i = 0;i<users.size() && !found;i++) {
			if(users.get(i).getId().equals(id)) {
				x = users.get(i);
				found = true;
			}
		}
		return x;
	}
	
	public String getTurnsReport(String id) {
		User u = null;
		String msg = "";
		
		int rs = (int)(Math.random() * 2)+1; 
		if(rs ==1) 
			u = searchUserByIdBinary(id);
		else {
			u = searchUser(id);
		}
		
		if(u!=null) {
			int rand = (int)(Math.random() * 2)+1; 
			if(rand ==1) 
				u.sortTurnsByDuration();
			else {
				u.sortTurnsByType();;
			}
			msg = u.getTurnsReport();
		}return msg;
	}
}
