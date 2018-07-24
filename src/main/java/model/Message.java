package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Message {

    private int sender;
    private String text;
    private List<Integer> destination;
    private LocalDateTime dateTime;

    public Message(int sender, String text) {
        this.sender = sender;
        this.text = text;
        this.destination = new ArrayList<>();
        this.dateTime = LocalDateTime.now();
    }

    public void addReceiver(int userID) {
        destination.add(userID);
    }
}
