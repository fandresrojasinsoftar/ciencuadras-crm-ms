package com.ciencuadras.crm.service;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ciencuadras.crm.model.RequestHubspot;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class CrmServiceImp implements CrmService {

	@Value("${url.capital}")
	private String urlHubspot;

	@Value("${builderCapital.id}")
	private Integer builderIdCapital;

	@Value("${content.name}")
	private String headerContent;

	@Value("${content.value}")
	private String keyContent;

	@Override
	public Object saveContacts(@Valid RequestHubspot requestHubspot) {
		String res = "";
		Object object = null;
		try {
			if (requestHubspot.getUserId() == 1) {
				OkHttpClient client = new OkHttpClient();

				ObjectMapper mapper = new ObjectMapper();

				String json = mapper.writeValueAsString(requestHubspot);

				MediaType content = MediaType.get(keyContent);
				RequestBody body = RequestBody.create(json, content);

				Request request = new Request.Builder().url(urlHubspot).post(body).addHeader(headerContent, keyContent)
						.build();

				try(Response resp = client.newCall(request).execute()) {
					res = resp.body().string();
					object = mapper.readValue(res, Object.class);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return object;
	}

}
