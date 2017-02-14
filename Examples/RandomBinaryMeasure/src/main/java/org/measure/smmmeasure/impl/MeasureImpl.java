package org.measure.smmmeasure.impl;

import java.util.List;

import org.measure.smmmeasure.implementation.api.IMeasurement;
import org.measure.smmmeasure.implementation.defaultimpl.measurements.NumericMeasurement;
import org.measure.smmmeasure.implementation.defaultimpl.measures.DerivedMeasure;

public class MeasureImpl extends DerivedMeasure {
	
	@Override
	public IMeasurement calculateMeasurement() {
		Integer result = 0;
		
		List<IMeasurement> op1 = getMeasureInputByRole("RandomNumber A");
		List<IMeasurement> op2 = getMeasureInputByRole("RandomNumber B");
			
		if(op1.size() == 1 && op2.size() == 1){
			String oper = "+";
	
			oper = getProperty("Operation");	
		
			if(oper.equals("+")){
				result = (Integer)op1.get(0).getValue() + (Integer)op2.get(0).getValue();
			}else if(oper.equals("-")){
				result = (Integer)op1.get(0).getValue() - (Integer)op2.get(0).getValue();
			}else if(oper.equals("*")){
				result = (Integer)op1.get(0).getValue() * (Integer)op2.get(0).getValue();
			}else if(oper.equals("/")){
				result = (Integer)op1.get(0).getValue() / (Integer)op2.get(0).getValue();
			}	
		}
		
		NumericMeasurement measurement = new NumericMeasurement();
		measurement.setValue(result);
		
		return measurement;
	}
	
}
