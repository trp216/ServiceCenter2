package model;

import java.util.Comparator;

public class TurnType implements Comparator<TurnType>{

	private float duration;
	private String name;
	

	public TurnType(float duration, String name) {
		this.duration = duration;
		this.name = name;
	}
 

	public float getDuration() {
		return duration;
	}


	public void setDuration(float duration) {
		this.duration = duration;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int compare(TurnType o1, TurnType o2) {
		if(o1.getName().compareTo(o2.getName())==0)
			return 0;
		if(o1.getName().compareTo(o2.getName())>0)
			return 1;
		else
			return -1;
	}

}
