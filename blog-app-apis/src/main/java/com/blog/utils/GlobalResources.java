package com.blog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalResources {
	public static Logger getlLogger(Class classname) {
		return LoggerFactory.getLogger(classname);
	}

}
