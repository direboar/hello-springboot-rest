package hello.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {

	// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-resttemplate
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	public Quote quote() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return quote;
	}

}
