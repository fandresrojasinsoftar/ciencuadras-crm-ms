package com.ciencuadras.crm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciencuadras.crm.model.RequestHubspot;
import com.ciencuadras.crm.model.ResponseBody;
import com.ciencuadras.crm.service.CrmService;

import io.swagger.annotations.Api;

@RestController
@Api(
		tags = "Integracion Api CRM",
		value = "Controlador Rest para integracion con CRM",
		produces = "application/json; charset=UTF-8"
	)
@RequestMapping("/crm/v3/objects")
public class CrmController {
	
	@Autowired
	private CrmService crmService;
	
	@PostMapping(value = "/contacts")
	public ResponseBody<Object> saveContacts(@RequestBody @Valid RequestHubspot requestHubspot) {
		return ResponseBody.builder()
				.success(true)
				.response(crmService.saveContacts(requestHubspot))
				.build();
	}

}
