package com.ccttic.cqytjgpt.webapi.interfaces.taskdriver;

import java.util.Map;

import com.ccttic.entity.drivers.Driver;
import com.ccttic.entity.drivers.vo.DriverIllegal;

public interface ITaskDriverService {
	
	Map<String,Object> getDriveIllega(DriverIllegal driver)  throws Exception;
	
	Map<String,Object> getDriverDanger(Driver driver)  throws Exception;

}
