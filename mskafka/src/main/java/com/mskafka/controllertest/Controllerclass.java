package com.mskafka.controllertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllerclass {

	
	@Autowired
	private KafkaTemplate<String, String>  kafkTemp;
	
	@RequestMapping("/send" )
	//http://localhost:9000/send?val=abc
	public void  send(@RequestParam String val )
	{
		////topicname and message
		kafkTemp.send("first-topic", "We are happy and more happy "+val);
		
		
	}
	
	
	@RequestMapping("/key/{key}" )
	public void  path(@PathVariable String key )
	{
		//topicname, key and message
		kafkTemp.send("first-topic",key ,"We are happy and more happy ");
	
		
	}
	
	
	@KafkaListener (topics= "first-topic")
    //Can this COnsumer read key also 
	public void consumer(String value,String key)
	{
		System.out.println("Key --"+key+"  Spring boot Consumer  "+value+"_________----");
		
	}
	
	
}
