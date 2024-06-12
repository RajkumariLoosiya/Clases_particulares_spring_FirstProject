package com.migue.gestion_usuarios.utils;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component

public class MapperUtils {

	@Autowired
	ObjectMapper objectmapper;
	
	public <T> T map(Object o , Class<?> c) throws JsonProcessingException{
		
		if(o instanceof Collection<?>) {
			ArrayNode arraynode = parseJson((List)o);
			Object target = objectmapper.treeToValue(arraynode, c);
			return (T) target;
		}
		
		ObjectNode objN = parseJson(o);
		Object target = objectmapper.treeToValue(objN, c);
		return (T) target; 
		
	} 
	
	public ArrayNode parseJson(List list) {
		return objectmapper.convertValue(list, ArrayNode.class);
	}
	
	public ObjectNode parseJson(Object obj) {
		return objectmapper.convertValue(obj, ObjectNode.class);
	}
	
}
