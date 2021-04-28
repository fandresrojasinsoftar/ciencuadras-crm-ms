package com.ciencuadras.crm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@ApiModel
public class Request{
	
	@ApiModelProperty(
			value = "Indica el id del usuario",
			name = "userId",
			example = "1")
	private Integer userId;
	
}
