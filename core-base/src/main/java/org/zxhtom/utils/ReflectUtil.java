package org.zxhtom.utils;

import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @ClassName: ReflectUtil
 * @Description: 操作反射简单封住类
 * @author zxhtom
 * @date 2018年1月29日
 */
public class ReflectUtil {

	private static Logger logger = LogManager.getLogger(ReflectUtil.class);
	/**
	 * 
	 * @Description: 获取类中属性的值
	 * @param clazz 类
	 * @param field 属性
	 * @return   属性值 。 不存在返回null
	 * @throws
	 * @author zxhtom
	 * @date 2018年1月30日
	 */
	public static Object getField(Class<?> clazz , String field){
		try {
			Object instance = clazz.newInstance();
			Field declaredField = clazz.getDeclaredField(field);
			/**private 等私有属性是不能直接访问到的，需要我们设置权限为true*/
			declaredField.setAccessible(true);
			return declaredField.get(instance);
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
}
