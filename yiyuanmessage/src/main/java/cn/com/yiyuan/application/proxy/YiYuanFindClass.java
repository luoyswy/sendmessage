/**
 * 
 */
package cn.com.yiyuan.application.proxy;

import java.io.File;
import java.net.URLDecoder;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.com.yiyuan.annoandenum.anno.TagSendMessageAnno;
import cn.com.yiyuan.config.PackagesPojo;
import cn.com.yiyuan.util.JustifyValue;

/**
 * @author 罗雨顺
 * @project yiyuanmessage
 * @file YiYuanFindClass.java
 * @date 2019年5月10日
 * @package cn.com.yiyuan.application.proxy
 * @summary 扫描发送信息的组件
 * 
 */
@Component
public class YiYuanFindClass {
	@SuppressWarnings("rawtypes")
	@Resource(name = "sendMessageBean")
	private Map sendMessageBean;
	@Resource
	private PackagesPojo packagesPojo;
	
	/**
	 * 通过tag查询对应的发送信息的组件
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	public Class<?> findClassByType(String type) throws Exception{
		Class<?> cla = (Class<?>) sendMessageBean.get(type);
		if(cla != null) return cla;
		String path = this.getClass().getResource("/").getPath();
		path = URLDecoder.decode(path,"UTF-8");
		path = path.substring(1);
		for(String packages : packagesPojo.getPackages()) {
			cla = findClassByPath(path, packages,type);
			if(cla != null) {
				sendMessageBean.put(type, cla);
				return cla;
			}
		}
		return cla;
	}
	
	private Class<?> findClassByPath(String path,String packages,String type) throws Exception{
		String dirPath = path + packages.replace(".", "/");
		File file = new File(dirPath);
		if(!file.exists()) return null;
		File[] listFile = file.listFiles();
		for(File item : listFile) {
			if(item.isDirectory()) {
				findClassByPath(path, packages + "." + item.getName(),type);
			}
			if(item.isFile()) {
				Class<?> cla = Class.forName(packages+ "." + item.getName().substring(0, item.getName().lastIndexOf(".")));
				if(JustifyValue.justifyTypeEqClaTag(cla, type)) return cla;
			}
		}
		return null;
	}
	
	/**
	 * 注册信息发送的组件
	 * @throws Exception
	 */
	public void registerClass() throws Exception{
		String path = this.getClass().getResource("/").getPath();
		path = URLDecoder.decode(path,"UTF-8");
		path = path.substring(1);
		for(String packages : packagesPojo.getPackages()) {
			registerClass(path, packages);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void registerClass(String path,String packages) throws Exception{
		String dirPath = path+ packages.replace(".", "/");
		File file = new File(dirPath);
		if(!file.exists()) return;
		File[] listFile = file.listFiles();
		for(File item : listFile) {
			if(item.isDirectory()) {
				registerClass(path, packages + "." + item.getName());
			}
			if(item.isFile()) {
				Class<?> cla = Class.forName(packages+ "." + item.getName().substring(0, item.getName().lastIndexOf(".")));
				TagSendMessageAnno messageAnno = cla.getAnnotation(TagSendMessageAnno.class);
				if(messageAnno == null) continue;
				sendMessageBean.put(messageAnno.tag(), cla);
			}
		}
	}
}
