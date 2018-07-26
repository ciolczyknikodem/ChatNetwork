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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("destination: ");
        for (int id : destination){
            String number = Integer.toString(id) + " ";
            result.append(number);
        }
        return "destination : " + result + "at: " + dateTime + " " + sender + " send: " + text;
    }

}
