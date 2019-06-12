/**
 * 
 */
package cn.com.yiyuan.server.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yiyuan.mapper.YyMessageAccountMapper;
import cn.com.yiyuan.pojo.YyMessageAccountPojo;
import cn.com.yiyuan.server.api.YyMessageAccountService;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YyMessageAccountServiceImpl.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.server.impl
 * @summary 通过类型和标签来获取账号
 * 
 */
@Service("YyMessageAccountService")
public class YyMessageAccountServiceImpl implements YyMessageAccountService {

	@Resource
	private YyMessageAccountMapper yyMessageAccountMapper;
	
	@Override
	public YyMessageAccountPojo selectMessageAccountByTag(String tag,String type) throws Exception {
		// TODO Auto-generated method stub
		YyMessageAccountPojo result = yyMessageAccountMapper.selectYyMessageAccountByTag(tag,type);
		if(result == null) {
			result = yyMessageAccountMapper.selectYyMessageAccountByTag("mdefault", type);
		}
		return result;
	}

}
