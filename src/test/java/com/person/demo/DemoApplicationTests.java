package com.person.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static io.restassured.RestAssured.given;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.Matchers.containsString;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private ResourceLoader resourceLoader;

	@Test
	public void wsdl() {
		given()
				.when()
				.get("http://localhost:" + port + "/soap/service/person?wsdl")
				.then()
				.assertThat();
	}

	@Test
	public void listOfServices(){
		given()
				.when()
				.get("http://localhost:" + port +"/soap")
				.then()
				.assertThat()
				.body(containsString("Available SOAP services:"));
	}

	@Test
	public void getPersonById(){
		Resource res = resourceLoader.getResource("classpath:getPersonById.xml");
		given()
				.contentType("text/xml;charset=UTF-8")
				.body(asString(res))
				.when()
				.post("http://localhost:" + port +"/soap/service/person")
				.then()
				.assertThat()
				.body(containsString("PersonResponse"));
	}

	@Ignore
	@Test
	public void getPersonByPesel(){
		Resource res = resourceLoader.getResource("classpath:getPersonByPesel.xml");
		given()
				.contentType("text/xml;charset=UTF-8")
				.body(asString(res))
				.when()
				.post("http://localhost:" + port +"/soap/service/person")
				.then()
				.assertThat()
				.body(containsString("PersonResponse"));
	}

	@Test
	public void getPersonByName(){
		Resource res = resourceLoader.getResource("classpath:getPersonByName.xml");
		given()
				.contentType("text/xml;charset=UTF-8")
				.body(asString(res))
				.when()
				.post("http://localhost:" + port +"/soap/service/person")
				.then()
				.assertThat()
				.body(containsString("PersonsResponse"));
	}


	public static String asString(Resource resource) {
		try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
			return FileCopyUtils.copyToString(reader);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

}
