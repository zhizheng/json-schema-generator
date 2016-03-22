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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *  Json Schema 生成器实现类
 *
 * @author Zhang Zhizheng <zhizheng118@gmail.com>
 * @since 0.0.1-SNAPSHOT
 * @see JsonSchemaGenerator
 */
public class JsonSchemaGeneratorImpl implements JsonSchemaGenerator {
	
	private JsonSchemaConfig jsonSchemaConfig;
	
	public JsonSchemaGeneratorImpl() {
		this.jsonSchemaConfig = new JsonSchemaConfig();
	}
	
	public JsonSchemaGeneratorImpl( JsonSchemaConfig jsonSchemaConfig) {
		this.jsonSchemaConfig = jsonSchemaConfig;
	}

	public String fromString(String string) throws Exception{
        JsonElement jsonElement = validateInput(string);
		return fromJsonElement(jsonElement);
	}

	public String fromFile(File file) throws Exception {
		JsonElement jsonElement = validateInput(file);
		return fromJsonElement(jsonElement);
	}

	public String fromReader(Reader reader) throws Exception{
		JsonElement jsonElement = validateInput(reader);
		return fromJsonElement(jsonElement);
	}

	public String fromUrl(URL url) throws Exception {
		JsonElement jsonElement = validateInput(url);
		return fromJsonElement(jsonElement);
	}
	
	/**
	 * 校验用户输入的是不是 Json，正常情况下返回 Json 的 JsonElement 格式，异常情况下抛出 ParseJsonException
	 * 
	 * @param string
	 * @return 
	 * @throws ParseJsonException 
	 */
	private JsonElement validateInput(String string) throws ParseJsonException{
		JsonElement jsonElement = null;
		try{
			JsonParser jsonParser = new JsonParser();
	        jsonElement = jsonParser.parse(string);
		}catch(Exception e){
			throw new ParseJsonException(e);
		}
		return jsonElement;
	}
	
	/**
	 * 校验用户输入的是不是 Json，正常情况下返回 Json 的 JsonElement 格式，异常情况下抛出 ParseJsonException
	 * 
	 * @param file
	 * @return
	 * @throws ParseJsonException
	 */
	private JsonElement validateInput(File file) throws ParseJsonException{
		JsonElement jsonElement = null;
		FileReader fileReader = null;
		try{
			fileReader = new FileReader(file);
			JsonParser jsonParser = new JsonParser();
	        jsonElement = jsonParser.parse(fileReader);
		}catch(Exception e){
			throw new ParseJsonException(e);
		} finally {
			if(fileReader != null){
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonElement;
	}
	
	/**
	 * 校验用户输入的是不是 Json，正常情况下返回 Json 的 JsonElement 格式，异常情况下抛出 ParseJsonException
	 * 
	 * @param reader
	 * @return
	 * @throws ParseJsonException
	 */
	private JsonElement validateInput(Reader reader) throws ParseJsonException{
		JsonElement jsonElement = null;
		try{
			JsonParser jsonParser = new JsonParser();
	        jsonElement = jsonParser.parse(reader);
		}catch(Exception e){
			throw new ParseJsonException(e);
		}
		return jsonElement;
	}
	
	/**
	 * 校验用户输入的是不是 Json，正常情况下返回 Json 的 JsonElement 格式，异常情况下抛出 ParseJsonException
	 * 
	 * @param url
	 * @return
	 * @throws ParseJsonException
	 */
	private JsonElement validateInput(URL url) throws ParseJsonException{
		JsonElement jsonElement = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		try{
			inputStream = url.openStream();
			inputStreamReader = new InputStreamReader(inputStream);
			JsonParser jsonParser = new JsonParser();
			jsonElement = jsonParser.parse(inputStreamReader);
		}catch(Exception e){
			throw new ParseJsonException(e);
		} finally {
			if(inputStreamReader != null){
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonElement;
	}
	
	/**
	 * Json to Json Schema
	 * 
	 * @param jsonElement
	 * @return
	 */
	private String fromJsonElement(JsonElement jsonElement){
		GsonBuilder gsonBuilder = new GsonBuilder();
		if(jsonSchemaConfig.isPrettyPrint()){
			gsonBuilder.setPrettyPrinting();
		}
		gsonBuilder.disableHtmlEscaping();
		Gson gson = gsonBuilder.create();
		JsonObject jsonSchemaElement = makeSchemaElement(jsonElement, null, true);
		String jsonSchemaString = gson.toJson(jsonSchemaElement);
		return jsonSchemaString;
	}

	/**
	 * 递归处理 JsonElement，生成 Json Schema 对象
	 * 
	 * @param jsonElement
	 * @param elementName
	 * @param isFirstLevel
	 * @return
	 */
	private JsonObject makeSchemaElement(JsonElement jsonElement, String elementName, boolean isFirstLevel) {
		JsonObject jsonSchemaObject = new JsonObject();
		
		// id, $schema
		if (isFirstLevel) {
			if(jsonSchemaConfig.isPrintId()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.ID.toString(), jsonSchemaConfig.getId());
			}
			jsonSchemaObject.addProperty(JsonSchemaKeywords.SCHEMA.toString(), JsonSchemaVersions.VC.toString());
		} else {
			if(jsonSchemaConfig.isPrintId()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.ID.toString(), "/" + elementName);
			}
		}
		
		// title
		if(jsonSchemaConfig.isPrintTitle()){
			jsonSchemaObject.addProperty(JsonSchemaKeywords.TITLE.toString(), elementName);// jsonSchemaConfig.getTitle()
		}
		
		// description
		if(jsonSchemaConfig.isPrintDescription()){
			jsonSchemaObject.addProperty(JsonSchemaKeywords.DESCRIPTION.toString(), jsonSchemaConfig.getDescription());
		}
		
		// type
		String jsonElementType = JsonValueTypes.getJsonValueType(jsonElement);
		jsonSchemaObject.addProperty(JsonSchemaKeywords.TYPE.toString(), jsonElementType);
		if(jsonElementType.equals(JsonValueTypes.STRING.toString())){// string
			if(jsonSchemaConfig.isPrintMinLength()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.MINLENGTH.toString(), jsonSchemaConfig.getMinLength());
			}
			if(jsonSchemaConfig.isPrintMaxLength()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.MAXLENGTH.toString(),  jsonSchemaConfig.getMaxLength());
			}
		}
		if(jsonElementType.equals(JsonValueTypes.NUMBER.toString())){// number
			if(jsonSchemaConfig.isPrintMinimum()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.MINIMUM.toString(), jsonSchemaConfig.getMinimum());
			}
			if(jsonSchemaConfig.isPrintMaximum()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.MAXIMUM.toString(),  jsonSchemaConfig.getMaximum());
			}
			if(jsonSchemaConfig.isPrintExclusiveMinimum()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.EXCLUSIVEMINIMUM.toString(), jsonSchemaConfig.isExclusiveMinimum());
			}
			if(jsonSchemaConfig.isPrintExclusiveMaximum()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.EXCLUSIVEMAXIMUM.toString(), jsonSchemaConfig.isExclusiveMaximum());
			}
		}
		
		// required
		if(jsonSchemaConfig.isPrintRequired()){
			jsonSchemaObject.addProperty(JsonSchemaKeywords.REQUIRED.toString(), jsonSchemaConfig.isRequired());
		}
		
		// properties, items
		if (jsonElement.isJsonObject() && !jsonElement.getAsJsonObject().entrySet().isEmpty()) {
			JsonObject propertiesObject = new JsonObject();
			for (Map.Entry<String, JsonElement> propertyElemement : jsonElement.getAsJsonObject().entrySet()) {
				propertiesObject.add(propertyElemement.getKey(), makeSchemaElement(propertyElemement.getValue(), propertyElemement.getKey(), false));
			}
			jsonSchemaObject.add(JsonSchemaKeywords.PROPERTIES.toString(), propertiesObject);
		} else if (jsonElement.isJsonArray() && jsonElement.getAsJsonArray().size() > 0) {
			JsonArray jsonArray = jsonElement.getAsJsonArray();
			jsonSchemaObject.add(JsonSchemaKeywords.ITEMS.toString(), makeSchemaElement(jsonArray.get(0), "0", false));
			
		}
		
		// type
		if(jsonElementType.equals(JsonValueTypes.ARRAY.toString())){// array
			if(jsonSchemaConfig.isPrintMinItems()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.MINITEMS.toString(), jsonSchemaConfig.getMinItems());
			}
			if(jsonSchemaConfig.isPrintUniqueItems()){
				jsonSchemaObject.addProperty(JsonSchemaKeywords.UNIQUEITEMS.toString(),  jsonSchemaConfig.isUniqueItems());
			}
		}
		
		return jsonSchemaObject;
	}
}
