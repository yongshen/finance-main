package com.yong.finance.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil extends StringUtils {

	public static boolean notEmpty(Object o) {
		return o != null && !o.toString().trim().equals("");
	}

	public static boolean empty(Object o) {
		return o == null || o.toString().trim().equals("");
	}

	/***************************************************************************
	 * 使用split连接count个c字符,返回连接后的字符串
	 * 
	 * @param c
	 *            字符
	 * @param split
	 *            分隔符
	 * @param count
	 *            个数
	 * @return 返回字符串
	 * @author jiangfl
	 */
	public static String getJoinSplitChar(String c, String split, Integer count) {
		String[] chars = new String[count];
		for (int i = 0; i < count; i++) {
			chars[i] = c;
		}
		return join(chars, split);
	}

	/**
	 * 将集合转为字符串 并且[] 替换成();
	 * 
	 * @param list
	 * @return
	 */
	public static String listToIN(List<?> list) {
		return JSON.toJSONString(list.toArray()).replace('[', '(')
				.replace(']', ')');
	}

	/***
	 * 把字符串str根据split字符分割，然后返回对应的cls类型数据
	 * 
	 * @param str
	 *            字符串
	 * @param split
	 *            分隔符
	 * @param cls
	 *            被分割后的值的类型
	 * @return
	 * @author jiangfl
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object[] split(String str, String split, Class cls) {
		if (str != null) {
			try {
				Object[] splits = str.split(split);
				// 如果是字符串
				if (cls != String.class) {
					Object result[] = new Object[splits.length];
					Constructor constructor;
					constructor = cls.getConstructor(String.class);
					for (int i = 0; i < splits.length; i++) {
						result[i] = constructor.newInstance(splits[i]);
					}
					return result;
				} else {
					return splits;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/***
	 * 将数组 array 使用 split连接 成 字符串
	 * 
	 * @param array
	 * @param split
	 * @return
	 * @author jiangfl
	 */
	public static String join(Object[] array, String split) {
		StringBuffer sb = new StringBuffer();
		for (Object o : array) {
			sb.append(o).append(split);
		}
		if (sb.length() > 1) {
			return sb.substring(0, sb.length() - 1);
		}
		return null;
	}

	/***
	 * 将数组 array 的内容添加到集合list中去
	 * 
	 * @param list
	 * @param array
	 * @author jiangfl
	 */
	public static void ListAddArray(List<Object> list, Object array[]) {
		for (Object obj : array) {
			list.add(obj);
		}
	}

	/**
	 * 传入 val值 这个值于list对象中的model(或者Map)实体的field属性相比较 看是否已经存在
	 * 
	 * @param list
	 *            list集合保存的是model实体(或者Map)
	 * @param field
	 *            model实体的某字段
	 * @param val
	 *            值
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean exists(List list, String field, Object val) {

		Method m = null;
		Object result = null;
		Map map = null;
		for (Object o : list) {
			try {
				if (o instanceof Map) {
					map = (Map) o;
					result = map.get(field);
				} else {
					if (!field.startsWith("get")) {
						field = "get" + field.substring(0, 1).toUpperCase()
								+ field.substring(1);
					}
					m = o.getClass().getMethod(field);
					result = m.invoke(o);
				}
				if (result == null && val == null) {
					return true;
				}
				if (result == null || val == null) {
					continue;
				}
				if (val.toString().equals(result.toString())) {
					return true;
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static Integer getInvite() {
		return (int) (Math.random() * 9000 + 1000);
	}

	public static String getSql(String[] sUUid) {
		StringBuilder sb = new StringBuilder();
		for (String s : sUUid) {
			sb.append(",\"").append(s).append("\"");
		}
		return sb.substring(1);
	}

	/**
	 * 随机获取会员邀请码(首字母不能是a)
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getInviteCode() throws Exception {
		try {
			String name = "";
			for (int i = 0; i < 5; i++) {
				if (i == 0) {
					int intValue = (int) (Math.random() * 26 + 97);
					if (intValue == 97) {
						getInviteCode();
					}
					name = name + (char) intValue;
				} else {
					int intValue = (int) (Math.random() * 26 + 97);
					name = name + (char) intValue;
				}
			}
			return name.trim();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 获取推广优惠码
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getSpreadCode() throws Exception {
		try {
			String name = "a";
			for (int i = 0; i < 4; i++) {
				int intValue = (int) (Math.random() * 26 + 97);
				name = name + (char) intValue;
			}
			return name.trim();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static List<Integer> getNumberListByStr(String str) {
		List<Integer> digitList = new ArrayList<Integer>();
		Pattern p = Pattern.compile("[0-9\\.]+");
		Matcher m = p.matcher(str);

		while (m.find()) {
			digitList.add(Integer.parseInt(m.group()));
		}
		return digitList;
	}

	public static String getStr(Integer i) {
		DecimalFormat f = new DecimalFormat("0000");
		String str = f.format(i);
		return str;
	}

	/**
	 * 元转换为分并保留两位小数
	 * 
	 * @param num
	 * @return
	 */
	public static String getStringByDecimal(Integer num) {
		if (notEmpty(num)) {
			double f = (double) num / 100;
			BigDecimal b = new BigDecimal(f);
			double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			return f1 + "";
		}
		return null;
	}

	public static String removeZero(String s) {
		if (notEmpty(s)) {
			if (s.indexOf(".") > 0) {
				// 正则表达
				s = s.replaceAll("0+?$", "");// 去掉后面无用的零
				s = s.replaceAll("[.]$", "");// 如小数点后面全是零则去掉小数点
			}
		}
		return s;
	}

	/**
	 * 本机IP
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static void main(String[] args) {
		try {
			// System.out.println(getStringByDecimal(3));
			// String s = "1.01";
			// if(s.indexOf(".") > 0){
			// //正则表达
			// s = s.replaceAll("0+?$", "");//去掉后面无用的零
			// s = s.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
			// }
			// System.out.println(getInviteCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
