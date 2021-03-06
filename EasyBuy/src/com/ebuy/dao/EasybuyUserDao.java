package com.ebuy.dao;

import java.util.List;

import com.ebuy.entity.EasybuyUser;

/**
 * 
 * @author linbingyang
 * @version 1.1 2017-10-30
 * 用户Dao接口
 *
 */
public interface EasybuyUserDao {
	/**
	 * 用户查找方法
	 * @param appendSql 添加查找条件
	 * @param params	参数列表
	 * @return			结果集对象集合
	 */
	public List<EasybuyUser> getEasybuyUserList(String appendSql,Object...params);
	
	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return 更新行数
	 */
	public int addEasybuyUser(EasybuyUser user);
	
}
