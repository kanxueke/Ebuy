package com.ebuy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ebuy.dao.BaseDao;
import com.ebuy.dao.EasybuyUserDao;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.util.DatabaseUtil;
/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-29
 * 用户Dao实现类
 *
 */
public class EasybuyUserDaoImpl extends BaseDao<EasybuyUser> implements EasybuyUserDao {
	/**
	 * 基础父类的构造方法
	 * @param conn
	 */
	public EasybuyUserDaoImpl(Connection conn) {
		super(conn);
	}
	
	/**
	 * 用户查找方法(返回所有记录的集合)
	 */
	@Override
	public List<EasybuyUser> getEasybuyUserList(String appendSql,Object...params) {
		List<EasybuyUser> list=null;
		StringBuffer sql = new StringBuffer("select * from easybuy_user ");
		sql.append(appendSql);
		list = super.executeQuery(sql.toString(), params);
		return list;
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public int addEasybuyUser(EasybuyUser user) {
		String sql ="insert into easybuy_user(loginName,userName,password,email,mobile) values(?,?,?,?,?)";
		int update = super.executeUpdate(sql, user.getLoginName(),user.getLoginName(),user.getPassword(),user.getEmail(),user.getMobile());
		return update;
	}
	
	
	/**
	 * 获取相应的用户对象
	 */
	@Override
	public EasybuyUser getEntity(ResultSet rs) {
		EasybuyUser user = null;
		if(rs != null){
			try {
				int id = rs.getInt("id");
				String loginName = rs.getString("loginName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int sex = rs.getInt("sex");
				String identityCode = rs.getString("identityCode");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				int type = rs.getInt("type");
				
				user = new EasybuyUser(id, userName, loginName, password, sex, identityCode, email, mobile, type);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
