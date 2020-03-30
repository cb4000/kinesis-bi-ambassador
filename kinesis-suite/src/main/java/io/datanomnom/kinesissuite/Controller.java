package io.datanomnom.kinesissuite;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;

import java.nio.ByteBuffer;

import com.amazonaws.services.kinesis.producer.KinesisProducer;
@RestController
public class Controller {

	@RequestMapping("/test")
	public String index() {
		return "Greetings from Spring Boot!";
	}

    
  @PostMapping("/facts")
  String newFact(@RequestBody Fact newFact) {
    
    System.out.println(newFact.toString());
    factWriter(newFact.toString());
    return "got it"+newFact.toString();
  }
void factWriter(String newFact){
KinesisProducerConfiguration config = new KinesisProducerConfiguration()
        .setRecordMaxBufferedTime(3000)
        .setMaxConnections(1)
        .setRequestTimeout(60000)
        .setRegion("us-east-1");
        
final KinesisProducer kinesisProducer = new KinesisProducer(config);

    // KinesisProducer gets credentials automatically like 
// DefaultAWSCredentialsProviderChain. 
// It also gets region automatically from the EC2 metadata service. 
KinesisProducer kinesis = new KinesisProducer();  
// Put some records 
    ByteBuffer data = ByteBuffer.wrap("myData".getBytes());
    // doesn't block       
    kinesis.addUserRecord("fact-bi-poc", "myPartitionKey", data); 
// Do other stuff ...
}


}