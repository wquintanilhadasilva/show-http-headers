package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping("/api/testes")
@Slf4j
public class TestController {
	
	private static final String[] IP_HEADERS = {
			"X-Forwarded-For",
			"Proxy-Client-IP",
			"WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR",
			"HTTP_X_FORWARDED",
			"HTTP_X_CLUSTER_CLIENT_IP",
			"HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR",
			"HTTP_FORWARDED",
			"HTTP_VIA",
			"REMOTE_ADDR"
	};
	
	@GetMapping("/headers")
	public ResponseEntity<TestResponse> testar(HttpServletRequest request) {
		log.info("Requisição efetuada...");
		var response = TestResponse.builder().build();
		response.add("getRemoteAddr", request.getRemoteAddr());
		readValues(request, response);
		log.info("Retornando o conteúdo extraído... [{}]", response);
		return ResponseEntity.ok(response);
	}
	
	private void readValues(HttpServletRequest request, TestResponse response) {
		Arrays.stream(IP_HEADERS).forEach(v -> {
			response.add(v,request.getHeader(v));
		});
		var headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			var next = headers.nextElement();
			log.info("Valor do cabeçalho [{}]: [{}]", next, request.getHeader(next));
			response.add(next,request.getHeader(next));
		}
	}

}
