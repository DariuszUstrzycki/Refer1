package pl.school.controller;

	import org.junit.Test;
	import org.junit.runner.RunWith;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
	import org.springframework.boot.test.web.client.TestRestTemplate;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.test.context.junit4.SpringRunner;

	import static org.assertj.core.api.Assertions.assertThat; //!!

	@RunWith(SpringRunner.class)
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	public class JSPControllerTest {

		@Autowired
		private TestRestTemplate restTemplate;

		@Test
		public void testJspWithEl() {
			ResponseEntity<String> entity = this.restTemplate.getForEntity("/jsptest2", String.class);
			assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(entity.getBody()).contains("/resources/text.txt");
		}

	}
