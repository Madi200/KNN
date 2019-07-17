package controller;

import java.util.Comparator;

import Model.irisObject;


public class DistanceComp implements Comparator<irisObject>{

	public int compare(irisObject obj1, irisObject obj2) {
		// TODO Auto-generated method stub
		if(obj1.getDistance() == obj2.getDistance()){
			return 0;
		}else if(obj1.getDistance() > obj2.getDistance()){
			return 1;
		}
		return -1;
	}

}
