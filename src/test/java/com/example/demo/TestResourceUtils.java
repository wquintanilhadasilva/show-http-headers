package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Controller para obter os dados de empresas ...
 *
 * @author Wedson Silva
 * @see <a href="https://dev.azure.com/oobj-devops/Engineering/_workitems/edit/1944">Azzure #1944</a>
 * @since 09/08/2023
 */
public class TestResourceUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	static {
		mapper.registerModule(new JavaTimeModule());
	}
	
	/**
	 * Carrega um recurso presente em resources como um {@link InputStream}
	 * @param resourceFile path do recurso a partir de resources/. Não deve utilizar a barra"/" no início.
	 * @return Referência do recurso como {@link InputStream} caso ele exista.
	 */
	public static InputStream fileAsInputStream(String resourceFile) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFile);
	}
	
	/**
	 * Carrega um recurso presente em resources como um {@link MultipartFile}
	 * @param resourceFile path do recurso a partir de resources/. Não deve utilizar a barra"/" no início.
	 * @return Referência do recurso como Multiart caso ele exista.
	 * @throws IOException
	 */
	public static MultipartFile fileAsMultipart(String resourceFile) throws IOException {
		var resource = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFile);
		MultipartFile multipartFile = new MockMultipartFile("file", resourceFile, MediaType.TEXT_HTML_VALUE, resource);
		return multipartFile;
	}
	
	/**
	 * Obtém o conteúdo string de um arquivo no resource
	 *
	 * @param resourceFile path do resource
	 * @return conteúdo obtido do arquivo em String UTF-8
	 * @throws IOException
	 */
	public static String openStringFileContent(String resourceFile) throws IOException {
		var resource = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFile);
		var reader = new InputStreamReader(resource, StandardCharsets.UTF_8);
		var content = new BufferedReader(reader).lines().collect(Collectors.joining("\n"));
		return content;
	}
	
	public static <T,V> Map<T,V> openJsonContent2Map(String resourceFile) throws IOException {
		var jsonContent = openStringFileContent(resourceFile);
		if (jsonContent != null) {
			Map<T,V> data = null;
			data = mapper.readValue(jsonContent, HashMap.class);
			return data;
		}
		return null;
	}
	
	public static <T> T loadJson2Object(String resource, Class<T> classz) throws IOException {
		String jsonContent = openStringFileContent(resource);
		return mapper.readValue(jsonContent, classz);
	}
	
	private static Map<String,Object> buildExtractions(String file) throws IOException {
		return  TestResourceUtils.openJsonContent2Map(file);
	}
	
}
