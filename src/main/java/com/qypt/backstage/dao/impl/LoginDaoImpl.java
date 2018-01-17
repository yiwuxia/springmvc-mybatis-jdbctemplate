package com.qypt.backstage.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qypt.backstage.entity.peadmin.PeAdmin;
import com.redare.devframework.common.spring.db.SpringJdbcHelper;
import com.sun.org.apache.regexp.internal.recompile;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	SpringJdbcHelper jdbcHelper;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public PeAdmin getPeAdminByUserNameAndPass(PeAdmin admin) {
		// TODO Auto-generated method stub
		/*String sql="SELECT NAME adminName,pass adminPass"
				+ " FROM sys_user  where name='"+admin.getAdminName()+"' and pass='"+admin.getAdminPass()+"'";
		return jdbcHelper.queryForBean(sql, PeAdmin.class);*/
		
		List<PeAdmin> list=	sqlSessionTemplate.selectList("com.qypt.backstage.entity.peadmin.PeAdmin.getUser");
		if (list!=null&&list.size()>0) {
			return list.get(0);
		}else {
			return new PeAdmin();
		}
		
	}
	
}
