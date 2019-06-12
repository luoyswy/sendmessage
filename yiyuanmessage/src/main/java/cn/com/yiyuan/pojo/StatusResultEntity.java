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
 * @file StatusResultEntity.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.pojo
 * @summary java类
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusResultEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2306800652190162722L;
	
	private String code;
	private String reqe;
	private String success;
	private String content;
	
}
