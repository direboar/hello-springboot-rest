package hello.webpservice.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

//着信SOAPメッセージを処理するための候補としてSpring WSにクラスを登録します
@Endpoint
public class CountryEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	// Spring WSによって、メッセージの名前空間とlocalPartに基づいてハンドラメソッドを選択するために使用されます。
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")

	// 応答ペイロードに返された値をマッピングします。
	@ResponsePayload

	// @RequestPayload …着信メッセージがメソッドのrequestパラメータにマッピングされることを示します。
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}

}
