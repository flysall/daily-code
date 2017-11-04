package sample.tomcat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {
	@Value("${name: world and flysall!}")
	private String name;

	public String getHelloMessage(){
		return "Hello " + this.name;
	}
}