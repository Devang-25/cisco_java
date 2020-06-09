package com.cisco.prj.client;

import java.util.ServiceLoader;

import com.cisco.prj.dao.MobileDao;
import com.cisco.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args)   {
		Mobile m = new Mobile();
//		MobileDao mobileDao = new MobileDaoMySQLImpl();
		ServiceLoader<MobileDao> services =
                ServiceLoader.load(MobileDao.class);
		//load ==> checks entries in pkg.MobileDao file and creates objects
		 
		MobileDao mobileDao = services.findFirst().get();
		mobileDao.addMobile(m);
		// 1000 lines of client
		for(MobileDao mdao : services) {
			mdao.addMobile(m);
		}
	}

}
