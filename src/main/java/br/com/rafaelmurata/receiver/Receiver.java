package br.com.rafaelmurata.receiver;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import br.com.rafaelmurata.model.Employee;

@Component
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(Employee employee) {
      System.out.println("Received <" + employee.toString() + ">");
      latch.countDown();
  }

  public CountDownLatch getLatch() {
      return latch;
  }

}