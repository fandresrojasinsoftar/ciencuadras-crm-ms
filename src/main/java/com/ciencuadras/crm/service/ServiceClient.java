package com.ciencuadras.crm.service;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class ServiceClient {

	
	private String headerContent;

	public Object consumirService(Object objectDTO, String url, String key, String value) throws IOException {

		String res = "";

		OkHttpClient client = new OkHttpClient();

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(objectDTO);

		MediaType content = MediaType.get(headerContent);

		RequestBody body = RequestBody.create(json, content);
		Request request = new Request.Builder().url(url).post(body).addHeader(key, value).build();

		try (Response resp = client.newCall(request).execute()) {
			res = resp.body().string();
		}
		
		return res;
	}
}
