package org.measure.packager;

import java.util.HashMap;

import org.measure.randomgenerator.RandomGenerator;
import org.measure.smm.measure.api.IMeasurement;
import org.measure.smm.measure.defaultimpl.measurements.IntegerMeasurement;

public class Test {

	public static void main(String[] args) {
		RandomGenerator measure = new RandomGenerator();
		HashMap<String, String> properties = new HashMap<>();
		
		properties.put("MinRange", "0");
		properties.put("MaxRange", "100");
		properties.put("Delta", "5");
		properties.put("PreviousValue", "0");
		measure.setProperties(properties);
		try {
			for(IMeasurement measurement : measure.getMeasurement()){
				IntegerMeasurement intMeasurement = new IntegerMeasurement(measurement);
				System.out.println(intMeasurement.getValue());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
