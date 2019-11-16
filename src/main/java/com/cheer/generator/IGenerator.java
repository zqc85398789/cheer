package com.cheer.generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class IGenerator {

	public static void main(String[] args) throws Exception {
		//警告信息
		List<String> warnings = new ArrayList<String>();
		//重复代码覆盖旧代码
		boolean overwrite = false;
		//读取配置文件
		InputStream is = IGenerator.class.getResourceAsStream("/generator-config.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(is);
		is.close();

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		//创建generator对象
		MyBatisGenerator mbg = new MyBatisGenerator(config, callback, warnings);
		//执行生成代码
		mbg.generate(null);
		//输出警告信息
		for (String s : warnings) {
			System.out.println(s);
		}
	}

}