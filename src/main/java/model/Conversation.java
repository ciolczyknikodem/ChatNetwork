package model;

public class Conversation {

    private int[] usersID;
    private Message[] conversation;

    public Conversation(int[] usersID, Message[] conversation) {
        this.usersID = usersID;
        this.conversation = conversation;
    }

    
}
