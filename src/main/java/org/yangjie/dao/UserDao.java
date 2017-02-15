package org.yangjie.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.yangjie.entity.User;

@Mapper // 注解为mybatis的Mapper, 自动生成代理实现
public interface UserDao {
	
	@Select("select * from user where username=#{username} and password=#{password}")
	public User select(@Param("username")String username, @Param("password")String password);
	
	@Insert("insert into user (username, password) values (#{username}, #{password})")
	@SelectKey(keyProperty="userid",statement="SELECT LAST_INSERT_ID()", before=false, resultType=Integer.class)  
	public boolean insert(User user);
	
}
