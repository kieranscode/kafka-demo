package com.example.kafkademo;

import com.example.kafkademo.entity.Student;
import com.example.kafkademo.entity.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/msg")
public class MsgController {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public MsgController(KafkaTemplate<String, Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/student")
    public void publish(@RequestParam("id") int id,
                        @RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName){

        Student student = new Student();
        student.setId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);

        kafkaTemplate.send("Topic2", student);
    }

    @PostMapping("/user")
    public void publish(@RequestParam("userId") long userId,
                        @RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName){
        User user = new User();
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        kafkaTemplate.send("Topic3", user);
    }

}
