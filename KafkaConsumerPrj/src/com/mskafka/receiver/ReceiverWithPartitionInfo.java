package com.mskafka.receiver;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class ReceiverWithPartitionInfo {
public static void main(String[] args) {
	Properties props=new Properties();
	props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
	
	KafkaConsumer<String, String> consumer=new KafkaConsumer<>(props);
	
	List<String> topicList=Collections.singletonList("first-topic");
	
	consumer.subscribe(topicList);
	
	while(true) {
		ConsumerRecords<String, String> records=consumer.poll(Duration.ofSeconds(20));
		records.forEach(record->System.out.println("key: "+record.key()+"\tvalue: "+record.value()
		+"\tpartition: "+record.partition()));
	}
	
	
}
}
