/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.zhizheng.json;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

/**
 * 测试类
 *
 * @author Zhang Zhizheng <zhizheng118@gmail.com>
 * @since 0.0.1-SNAPSHOT
 * @see JsonSchemaGenerator
 */
public class JsonSchemaGeneratorTest {
	
	JsonSchemaConfig jsonSchemaConfig = new JsonSchemaConfig();
	JsonSchemaGenerator jsonSchemaGenerator = new JsonSchemaGeneratorImpl(jsonSchemaConfig);
	
	@Before
	public void before(){
		jsonSchemaConfig.setPrettyPrint(true);// 优雅打印格式
		
		//  最大化打印
//		jsonSchemaConfig.setPrintRequired(true); // 设置打印 required 属性
//		jsonSchemaConfig.setRequired(true); // 将 required 属性的值设置 true
//		jsonSchemaConfig.setPrintId(true); // 设置打印 id 属性
//		jsonSchemaConfig.setPrintMinimum(true); // 设置打印 minimum 属性
//		jsonSchemaConfig.setPrintMaximum(true); // 设置打印 maximum 属性
//		jsonSchemaConfig.setPrintExclusiveMinimum(true); // 设置打印 exclusiveMinimum 属性
//		jsonSchemaConfig.setPrintExclusiveMaximum(true); // 设置打印 exclusiveMaximum 属性
//		jsonSchemaConfig.setPrintMinLength(true); // 设置打印 minLength 属性
//		jsonSchemaConfig.setPrintMaxLength(true); // 设置打印 maxLength 属性
//		jsonSchemaConfig.setPrintMinItems(true); // 设置打印 minItems 属性
//		jsonSchemaConfig.setPrintUniqueItems(true); // 设置打印 uniqueItems 属性
//		jsonSchemaConfig.setPrintDefault(true); // 设置打印 default 属性
//		jsonSchemaConfig.setDefaultFromJson(true); // 设置 default 属性的值从 json 取
	}
	
	@Test
	public void testFromString() throws Exception {
		String jsonString = "{\"flag\":\"test\",\"log\":{\"logId\":1,\"logMsg\":\"hello world\"},\"tags\":[\"java\",\"json\",\"schema\",\"generator\"]}";
		String jsonSchemaString = jsonSchemaGenerator.fromString(jsonString);
		System.out.println(jsonSchemaString);
	}
	
	@Test
	public void testFromFile() throws Exception {
		URL jsonUrl = getClass().getClassLoader().getResource("test.json");
		File jsonFile = new File(jsonUrl.toURI());
		String jsonSchemaString = jsonSchemaGenerator.fromFile(jsonFile);
		System.out.println(jsonSchemaString);
	}
	
	@Test
	public void testFromReader() throws Exception {
		URL jsonUrl = getClass().getClassLoader().getResource("test.json");
		File jsonFile = new File(jsonUrl.toURI());
		FileReader jsonFileReader = new FileReader(jsonFile);
		String jsonSchemaString = jsonSchemaGenerator.fromReader(jsonFileReader);
		jsonFileReader.close();
		System.out.println(jsonSchemaString);
	}
	
	@Test
	public void testFromUrl() throws Exception {
		URL jsonUrl = getClass().getClassLoader().getResource("test.json");
		String jsonSchemaString = jsonSchemaGenerator.fromUrl(jsonUrl);
		System.out.println(jsonSchemaString);
	}

}
