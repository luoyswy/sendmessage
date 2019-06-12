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
 * @file YyMessageLogPojo.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.pojo
 * @summary java类
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YyMessageLogPojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1836460783486721320L;
	
	private Long id;
	private String content;
	private String destination;
	private Integer status;
	private String tag;
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
