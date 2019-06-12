/**
 * 
 */
package cn.com.yiyuan.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YyMessageAccountPojo.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.pojo
 * @summary java类
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YyMessageAccountPojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8420751605729534762L;
	
	private Long id;
	private String tag;//标识
	private String account;//账号
	private String password;//账号的密码
	private String orgaccount;//单位
	private String sign;//签名编码
	private String addserival;//序列
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private String attribute6;
	private String attribute7;
	private String attribute8;
	private String attribute9;
	
}
