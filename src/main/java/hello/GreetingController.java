package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	// @PostMapping("/greeting") //POSTに限定する場合
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		String content = String.format(template, name);

		// オブジェクトデータはJSONとしてHTTPレスポンスに直接書き込まれます。
		// DefaultではJackson。カスタマイズする場合は、MappingJackson2HttpMessageConverterを入れ替えないとダメか。
		return new Greeting(counter.incrementAndGet(), content);
	}

}
