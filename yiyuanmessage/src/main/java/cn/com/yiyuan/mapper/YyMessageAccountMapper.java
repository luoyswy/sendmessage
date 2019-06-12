/**
 * 
 */
package cn.com.yiyuan.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.com.yiyuan.pojo.YyMessageAccountPojo;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YyMessageAccountMapper.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.mapper
 * @summary java类
 * 
 */
@Mapper
public interface YyMessageAccountMapper {
	
	@Insert("insert into yy_message_account(id,tag,account,password,orgaccount,sign,addserival,attribute1,attribute2,attribute3,attribute4,"
			+ "attribute5,attribute6,attribute7,attribute8,attribute9)"
			+ " values(#{id},#{tag},#{account},#{password},#{orgaccount},#{sign},#{addserival},#{attribute1},#{attribute2},#{attribute3},"
			+ "#{attribute4},#{attribute5},#{attribute6},#{attribute7},#{attribute8},#{attribute9})")
	public int insertYyMessageAccountOne(YyMessageAccountPojo accountPojo) throws Exception;
	
	@Select("select * from yy_message_account where tag=#{tag} and attribute1=#{type}")
	public YyMessageAccountPojo selectYyMessageAccountByTag(@Param("tag") String tag,@Param("type")String type) throws Exception;
	
}
