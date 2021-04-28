package com.ciencuadras.crm.model;

import javax.validation.constraints.NotNull;

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
public class RequestHubspot extends Request{
	@ApiModelProperty(
			value = "Indica el nombre de la compañia",
			name = "company",
			example = "Biglytics")
	@NotNull(message="{company} ")
	 private String company;
	
	@ApiModelProperty(
			value = "Indica el email",
			name = "email",
			example = "bcooper@biglytics.net") 
	@NotNull(message="{email} ")
	 private String email;
	
	@ApiModelProperty(
			value = "Indica el primer nombre",
			name = "firstname",
			example = "Bryan") 	
	@NotNull(message="{firstname} ")
	 private String firstname;
	
	@ApiModelProperty(
			value = "Indica el primer apellido",
			name = "lastname",
			example = "Cooper") 
	@NotNull(message="{lastname} ")
	 private String lastname;
	
	@ApiModelProperty(
			value = "Indica el telefono",
			name = "phone",
			example = "(877) 929-0687") 
	@NotNull(message="{phone} ")
	 private String phone;
	
	@ApiModelProperty(
			value = "Indica el sitio web",
			name = "website",
			example = "biglytics.net") 
	@NotNull(message="{website} ")
	 private String website;
}
