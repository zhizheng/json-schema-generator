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
import java.io.Reader;
import java.net.URL;

/**
 * Json Schema 生成器接口
 *
 * @author Zhang Zhizheng <zhizheng118@gmail.com>
 * @since 0.0.1-SNAPSHOT
 */
public interface JsonSchemaGenerator {
	
	/**
	 * 由 Json 字符串生成 Json Schema
	 * 
	 * @param string Json 字符串
	 * @return Json Schema
	 * @throws Exception 异常
	 */
	public String fromString(String string) throws Exception;
	
	/**
	 * 由 Json 文本文件生成 Json Schema
	 * 
	 * @param file Json 文本文件
	 * @return Json Schema
	 * @throws Exception 异常
	 */
	public String fromFile(File file) throws Exception;
	
	/**
	 * 从 reader 读取 Json 文本生成 Json Schema
	 * 
	 * @param reader
	 * @return Json Schema
	 * @throws Exception 异常
	 */
	public String fromReader(Reader reader) throws Exception;
	
	/**
	 * 从 url 读取 Json 文本生成 Json Schema
	 * 
	 * @param url  Json 文本所在地址
	 * @return Json Schema
	 * @throws Exception 异常
	 */
	public String fromUrl(URL url) throws Exception;
	
}
