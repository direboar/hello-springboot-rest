package hello.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteServiceInvokeService {

	@Autowired
	private QuoteService quoteService;

	@RequestMapping("/quote")
	public Quote quote() {
		return quoteService.quote();
	}

}
