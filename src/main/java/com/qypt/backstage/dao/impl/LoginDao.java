package com.qypt.backstage.dao.impl;

import com.qypt.backstage.entity.peadmin.PeAdmin;

public interface LoginDao {

	PeAdmin getPeAdminByUserNameAndPass(PeAdmin admin);
	
}
