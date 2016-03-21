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
 * See e License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.zhizheng.json;

/**
 * Json Schema 生成器配置参数
 *
 * @author Zhang Zhizheng <zhizheng118@gmail.com>
 * @since 0.0.1-SNAPSHOT
 */
public class JsonSchemaConfig {

	/**
	 * 是否优雅打印
	 */
	private boolean prettyPrint = false;
	
	/**
	 * required 属性
	 */
	private boolean required = true;
	/**
	 * 是否打印 required 属性
	 */
	private boolean printRequired = true;
	
	/**
	 * id 属性
	 */
	private String id = "";
	/**
	 * 是否打印 id 属性
	 */
	private boolean printId = false;
	
	/**
	 * title 属性
	 */
	private String title = "";
	/**
	 * 是否打印 title 属性
	 */
	private boolean printTitle = false;
	
	/**
	 * description 属性
	 */
	private String description = "";
	/**
	 * 是否打印 description 属性
	 */
	private boolean printDescription = false;
	
	/**
	 * number 字段相关属性默认值
	 */
	private int minimum = 0;
	private int maximum = Integer.MAX_VALUE;
    private boolean exclusiveMinimum = false;
    private boolean exclusiveMaximum = false;
    /**
	 * 是否打印 number 字段相关属性
	 */
    private boolean printMinimum = false;
	private boolean printMaximum = false;
    private boolean printExclusiveMinimum = false;
    private boolean printExclusiveMaximum = false;
    
    /**
     * string 字段相关属性默认值
     */
    private int minLength = 0;
    private int maxLength = 4000;
	/**
	 * 是否打印 string 字段相关属性
	 */
    private boolean printMinLength = false;
    private boolean printMaxLength = false;
    
    /**
     * array 字段相关属性默认值
     */
    private int minItems = 0;
    private boolean uniqueItems = false;
	/**
	 * 是否打印 array 字段相关属性
	 */
    private boolean printMinItems = false;
    private boolean printUniqueItems = false;
    
	public boolean isPrettyPrint() {
		return prettyPrint;
	}

	public void setPrettyPrint(boolean prettyPrint) {
		this.prettyPrint = prettyPrint;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isPrintRequired() {
		return printRequired;
	}

	public void setPrintRequired(boolean printRequired) {
		this.printRequired = printRequired;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isPrintId() {
		return printId;
	}

	public void setPrintId(boolean printId) {
		this.printId = printId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isPrintTitle() {
		return printTitle;
	}

	public void setPrintTitle(boolean printTitle) {
		this.printTitle = printTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPrintDescription() {
		return printDescription;
	}

	public void setPrintDescription(boolean printDescription) {
		this.printDescription = printDescription;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public boolean isExclusiveMinimum() {
		return exclusiveMinimum;
	}

	public void setExclusiveMinimum(boolean exclusiveMinimum) {
		this.exclusiveMinimum = exclusiveMinimum;
	}

	public boolean isExclusiveMaximum() {
		return exclusiveMaximum;
	}

	public void setExclusiveMaximum(boolean exclusiveMaximum) {
		this.exclusiveMaximum = exclusiveMaximum;
	}

	public boolean isPrintMinimum() {
		return printMinimum;
	}

	public void setPrintMinimum(boolean printMinimum) {
		this.printMinimum = printMinimum;
	}

	public boolean isPrintMaximum() {
		return printMaximum;
	}

	public void setPrintMaximum(boolean printMaximum) {
		this.printMaximum = printMaximum;
	}

	public boolean isPrintExclusiveMinimum() {
		return printExclusiveMinimum;
	}

	public void setPrintExclusiveMinimum(boolean printExclusiveMinimum) {
		this.printExclusiveMinimum = printExclusiveMinimum;
	}

	public boolean isPrintExclusiveMaximum() {
		return printExclusiveMaximum;
	}

	public void setPrintExclusiveMaximum(boolean printExclusiveMaximum) {
		this.printExclusiveMaximum = printExclusiveMaximum;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public boolean isPrintMinLength() {
		return printMinLength;
	}

	public void setPrintMinLength(boolean printMinLength) {
		this.printMinLength = printMinLength;
	}

	public boolean isPrintMaxLength() {
		return printMaxLength;
	}

	public void setPrintMaxLength(boolean printMaxLength) {
		this.printMaxLength = printMaxLength;
	}

	public int getMinItems() {
		return minItems;
	}

	public void setMinItems(int minItems) {
		this.minItems = minItems;
	}
	
	public boolean isUniqueItems() {
		return uniqueItems;
	}

	public void setUniqueItems(boolean uniqueItems) {
		this.uniqueItems = uniqueItems;
	}

	public boolean isPrintMinItems() {
		return printMinItems;
	}

	public void setPrintMinItems(boolean printMinItems) {
		this.printMinItems = printMinItems;
	}

	public boolean isPrintUniqueItems() {
		return printUniqueItems;
	}

	public void setPrintUniqueItems(boolean printUniqueItems) {
		this.printUniqueItems = printUniqueItems;
	}

}
