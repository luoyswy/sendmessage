/**
 * 
 */
package cn.com.yiyuan.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file PackagesPojo.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.pojo
 * @summary java类
 * 
 */
@Component
@ConfigurationProperties(prefix="list")
public class PackagesPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5389965953009407911L;
	
	private List<String> packages = new ArrayList<String>();

	/**
	 * @return the packages
	 */
	public List<String> getPackages() {
		return packages;
	}

	/**
	 * @param packages the packages to set
	 */
	public void setPackages(List<String> packages) {
		this.packages = packages;
	}
	
	
	
}
