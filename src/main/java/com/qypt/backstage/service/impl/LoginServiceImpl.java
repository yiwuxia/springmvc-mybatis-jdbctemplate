package com.qypt.backstage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qypt.backstage.dao.impl.LoginDao;
import com.qypt.backstage.entity.peadmin.PeAdmin;
import com.qypt.backstage.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	public PeAdmin getPeAdminByUserNameAndPass(PeAdmin admin) {
		
		return loginDao.getPeAdminByUserNameAndPass(admin);
	}

}
