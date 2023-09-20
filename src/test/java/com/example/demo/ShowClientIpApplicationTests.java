package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class ShowClientIpApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testBuildHas() throws IOException, NoSuchAlgorithmException {
		var arquivo1 = TestResourceUtils.fileAsInputStream("danfeA.jpg");
		var arquivo2 = TestResourceUtils.fileAsInputStream("danfeA.png");
		var arquivo3 = TestResourceUtils.fileAsInputStream("danfeA2.png");
		
		var hashArquivo1 = HashUtil.calcularHash(arquivo1.readAllBytes());
		var hashArquivo2 = HashUtil.calcularHash(arquivo2.readAllBytes());
		var hashArquivo3 = HashUtil.calcularHash(arquivo3.readAllBytes());
		
		var hash4 = HashUtil.calcularHash(null);
		
		assertThat(hashArquivo2).isEqualTo(hashArquivo3);
		assertThat(hashArquivo1).isEqualTo(hashArquivo2);
		assertThat(hashArquivo1).isEqualTo(hashArquivo3);
		
	}

}
