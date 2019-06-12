/**
 * 
 */
package cn.com.yiyuan.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.com.yiyuan.pojo.YyMessageLogPojo;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YyMessageLogMapper.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.mapper
 * @summary java类
 * 
 */
@Mapper
public interface YyMessageLogMapper {
	
	@Insert("insert into yy_message_log(id,content,destination,status,tag,attribute1,attribute2,attribute3,attribute4,"
			+ "attribute5,attribute6,attribute7,attribute8,attribute9) "
			+ "values(#{id},#{content},#{destination},#{status},#{tag},#{attribute1},#{attribute2},#{attribute3},"
			+ "#{attribute4},#{attribute5},#{attribute6},#{attribute7},#{attribute8},#{attribute9})")
	public int insertMessageLog(YyMessageLogPojo yyMessageLogPojo) throws Exception;
	
	@Update("update yy_message_log set status=#{status} where id=#{id}")
	public int updateMessageLogStatusById(YyMessageLogPojo yyMessageLogPojo) throws Exception;
	
	@Select("select * from yy_message_log where id=#{id}")
	public YyMessageLogPojo selectMessageLogById(Long id) throws Exception;
	
}
