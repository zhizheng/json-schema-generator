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

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

/**
 * Json 数据类型
 *
 * @author Zhang Zhizheng <zhizheng118@gmail.com>
 * @since 0.0.1-SNAPSHOT
 */
public enum JsonValueTypes {

	OBJECT("object"),
	ARRAY("array"),
	STRING("string"),
	NUMBER("number"),
	INTEGER("integer"),// JSON Schema
	BOOLEAN("boolean"),
	NULL("null");
	
	private String type;

	/**
	 * @param type
	 */
	private JsonValueTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type;
	}
	
	/**
	 * 判断 Json 元素的类型
	 * 
	 * @param jsonElement
	 * @return
	 */
	public static String getJsonValueType(JsonElement jsonElement) {
		if (jsonElement.isJsonObject()) {
			return OBJECT.toString();
		}
		if (jsonElement.isJsonArray()) {
			return ARRAY.toString();
		}
		if (jsonElement.isJsonPrimitive()) {
			JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
			if (asJsonPrimitive.isBoolean()) {
				return BOOLEAN.toString();
			}
			if (asJsonPrimitive.isNumber()) {
				// integer 类型判断 begin
				try{
					if(String.valueOf(asJsonPrimitive.getAsBigInteger()).equals(asJsonPrimitive.getAsString())){
						return INTEGER.toString();
					}
				}catch(Exception e){
				}
				// integer 类型判断 end
				return NUMBER.toString();
			}
			return STRING.toString();
		}
		return NULL.toString();
	}
}
