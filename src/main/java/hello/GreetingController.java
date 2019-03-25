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
	// @PostMapping("/greeting") //POST�Ɍ��肷��ꍇ
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		String content = String.format(template, name);

		// �I�u�W�F�N�g�f�[�^��JSON�Ƃ���HTTP���X�|���X�ɒ��ڏ������܂�܂��B
		// Default�ł�Jackson�B�J�X�^�}�C�Y����ꍇ�́AMappingJackson2HttpMessageConverter�����ւ��Ȃ��ƃ_�����B
		return new Greeting(counter.incrementAndGet(), content);
	}

}
