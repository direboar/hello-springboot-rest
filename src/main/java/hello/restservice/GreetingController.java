package hello.restservice;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Validated // GETパラメータに対するバリデーションを行う場合は必要。

//API単位のSwagger出力。
@Api(tags = "タグ1", protocols = "http") // produce,consumeは自動設定っぽい //ここにタグつけとかないと、GreetingControllerが表示されてしまう…設定の問題かも？
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	// @RequestMapping("/greeting")
	@GetMapping("/greeting") // GETに限定する場合

	// 操作単位のSwagger出力。
	@ApiOperation(value = "挨拶を行います。", notes = "挨拶を行います。仕様の詳細を記載します。")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "登録した会員情報", response = Greeting.class) })
	// 引数nameが必須。デフォルトではリターンコード400 bad requestが返却される。

	// @ApiParamは引数のSwagger出力。
	public Greeting greeting(
			@RequestParam(value = "name") @Valid @Size(max = 3) @NotNull @ApiParam(value = "挨拶する相手の名前", required = true) String name) {
		String content = String.format(template, name);

		// オブジェクトデータはJSONとしてHTTPレスポンスに直接書き込まれます。
		// DefaultではJackson。カスタマイズする場合は、MappingJackson2HttpMessageConverterを入れ替えないとダメか。
		return new Greeting(counter.incrementAndGet(), content);
	}

	@GetMapping("/hoge") // GETに限定する場合
	public void hoge(@RequestParam(value = "hoge") @Valid @NotNull @Max(200) Integer value) {
	}

}
