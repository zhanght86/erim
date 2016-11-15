package com.erim.sz.web.util;

import java.util.HashMap;
import java.util.Map;

public class Flag {
	
	public static Map<String,Object> getFlag(){
		Map<String,Object> map = new HashMap<String, Object>();
		for (int i = 0; i < 300; i++) {
			
			map.put("$staticRoot/image/.png", "0" + i);
		}
		return map;
	}
}
