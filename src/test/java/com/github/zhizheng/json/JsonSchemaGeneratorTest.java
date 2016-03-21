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
//		jsonSchemaConfig.setPrintRequired(true);
//		jsonSchemaConfig.setRequired(true);
//		jsonSchemaConfig.setPrintId(true);
//		jsonSchemaConfig.setPrintMinimum(true);
//		jsonSchemaConfig.setPrintMaximum(true);
//		jsonSchemaConfig.setPrintExclusiveMinimum(true);
//		jsonSchemaConfig.setPrintExclusiveMaximum(true);
//		jsonSchemaConfig.setPrintMinLength(true);
//		jsonSchemaConfig.setPrintMaxLength(true);
//		jsonSchemaConfig.setPrintMinItems(true);
//		jsonSchemaConfig.setPrintUniqueItems(true);
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
