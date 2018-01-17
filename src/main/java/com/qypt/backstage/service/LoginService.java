package com.qypt.backstage.service;

import com.qypt.backstage.entity.peadmin.PeAdmin;

public interface LoginService {
	public PeAdmin getPeAdminByUserNameAndPass(PeAdmin admin);
}
