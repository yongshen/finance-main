package com.yong.finance.common.utils;

import java.util.UUID;

/**
 * UUID 工具类
 * @author yangshaodong
 *
 */
public class UUIDUtil {
	  /**
	   *  生成一个uuid
	   */
	  public static String getUUID(){
	        return UUID.randomUUID().toString().toUpperCase().replace("-","");
	  }
	  public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
