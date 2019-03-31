package hello.restservice;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//モデルクラスに対するSwagger出力設定。
@ApiModel(description = "挨拶情報")
public class Greeting {

	// モデルプロパティに対するSwagger出力設定。
	@ApiModelProperty(value = "挨拶を一意にする番号", example = "123", required = true) // requiredは直接設定しないと、アノテーションからうまく読み取ってくれない模様
	@Min(10)
	private final long id;

	@ApiModelProperty(value = "挨拶のメッセージ", example = "Hello,World!")
	@NotNull
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}
