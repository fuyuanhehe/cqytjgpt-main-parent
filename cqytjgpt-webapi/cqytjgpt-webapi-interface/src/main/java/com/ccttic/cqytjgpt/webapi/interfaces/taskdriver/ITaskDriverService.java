package com.ccttic.cqytjgpt.webapi.interfaces.taskdriver;

import com.ccttic.entity.drivers.Driver;

public interface ITaskDriverService {
	
	void addDriveIllega(Driver driver)  throws Exception;
	
	void addDriverDanger(Driver driver)  throws Exception;

}
