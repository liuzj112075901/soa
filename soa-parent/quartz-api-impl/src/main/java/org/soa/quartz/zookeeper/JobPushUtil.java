package org.soa.quartz.zookeeper;

import java.util.Map;

import org.soa.core.holder.SpringContextHolder;

public class JobPushUtil {
	static Map<String, String> param = SpringContextHolder.getBean("jobZookeeperMap");
	final static String path = param.get("path");
	final static String hosts = param.get("zkaddress");
	
	public static void push(String src){
		try {
			new JobListener(hosts,path).addOrUpdateData(path, src.getBytes());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}

}
