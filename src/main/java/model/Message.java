package model;

import java.time.LocalDateTime;
import java.util.List;

public class Message {

    private int sender;
    private String text;
    private List<Integer> destination;
    private LocalDateTime dateTime;
}
