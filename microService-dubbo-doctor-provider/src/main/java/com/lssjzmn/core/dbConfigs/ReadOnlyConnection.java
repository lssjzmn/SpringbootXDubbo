package com.lssjzmn.core.dbConfigs;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: ReadOnlyConnection
 * @Description: 开启读写分离的注解名称
 * @Author 谢川立
 * @Copyright: Copyright (c) 2018
 * @Company:成都信通网易医疗科技发展有限公司
 * @Date 2018年7月11日 上午11:41:02
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnlyConnection {
}

