package hello.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "タグ1", "タグ2" }, produces = "ｘｘｘ", consumes = "ｙｙｙ", protocols = "http")
public class QuoteServiceInvokeService {

	@Autowired
	private QuoteService quoteService;

	@RequestMapping("/quote")
	public Quote quote() {
		return quoteService.quote();
	}

}
