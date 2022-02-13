package com.example.kafkademo;

import com.example.kafkademo.entity.Student;
import com.example.kafkademo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(
            topics="Topic2",
            groupId = "groupId",
            containerFactory = "studentListener"
    )
    public void
    publish(Student student)
    {
        System.out.println("New Entry: " + student);
        System.out.println("New Entry: " + student.getFirstName());
    }
    
    @org.springframework.kafka.annotation.KafkaListener(
                    topics="Topic3",
                    groupId = "groupId",
                    containerFactory = "userListener"
            )
    public void publishUser(User user){
        System.out.println("New Entry: " + user);
    }

}
