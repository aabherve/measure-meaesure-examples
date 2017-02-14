package org.measure.packager;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.measure.smm.measure.model.MeasureType;
import org.measure.smm.measure.model.MeasureUnite;
import org.measure.smm.measure.model.SMMMeasure;
import org.measure.smm.measure.model.ScopeProperty;
import org.measure.smm.service.MeasurePackager;

public class PackageMeasure {

	public static void main(String[] args) {
		SMMMeasure measure = new SMMMeasure();
		measure.setName("SVNCommit");
		measure.setDescription("List SVN Commit sins the last update");
		measure.setType(MeasureType.DIRECT);
		measure.setUnite(MeasureUnite.Numeric);

		ScopeProperty uri = new ScopeProperty();
		uri.setName("URI");
		uri.setDescription("SVN Repository URI");
		uri.setDefaultValue("");

		ScopeProperty login = new ScopeProperty();
		login.setName("LOGIN");
		login.setDescription("Login of the SVN server");
		login.setDefaultValue("");
		
		ScopeProperty password = new ScopeProperty();
		password.setName("PASSWORD");
		password.setDescription("Password of the SVN Server");
		password.setDefaultValue("");
		
		ScopeProperty lastDate = new ScopeProperty();
		lastDate.setName("LastUpdate");
		lastDate.setDescription("Last Execution Date of this measure");
		lastDate.setDefaultValue("0");
		

		measure.getScopeProperties().add(uri);
		measure.getScopeProperties().add(login);
		measure.getScopeProperties().add(password);
		measure.getScopeProperties().add(lastDate);

		
		try {
			MeasurePackager.packageMeasure(
					new File(
							"C:/Users/aabherve/Desktop/Platform/work/SVNCommit/target/SVNCommit-1.0.0.jar")
									.toPath(),
					measure,
					new File("C:/Users/aabherve/Desktop/Platform/work/SVNCommit/SVNCommit.zip").toPath());
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

}
