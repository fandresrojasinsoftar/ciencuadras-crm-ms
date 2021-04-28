package com.ciencuadras.crm.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ResponseBody<T> implements Serializable{

	private boolean success;
	
	private transient T response;
}
