package br.com.rafaelmurata.runner;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.rafaelmurata.config.ConfigurationBean;
import br.com.rafaelmurata.model.Employee;
import br.com.rafaelmurata.receiver.Receiver;
import br.com.rafaelmurata.repository.ExampleRepository;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
	
    @Autowired
	private ExampleRepository repository;
	

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
    	for (Iterator iterator = repository.findAll().iterator(); iterator.hasNext();) {
    		Employee employee = (Employee) iterator.next();
			   rabbitTemplate.convertAndSend(ConfigurationBean.topicExchangeName, "foo.bar.baz", employee);
		        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
			
		}
    	
     
    }

}