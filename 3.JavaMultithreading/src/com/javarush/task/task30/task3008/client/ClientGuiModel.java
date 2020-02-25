package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClientGuiModel {
    private final Set<String> allUserNames = new HashSet<>();
    private String newMessage;

    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(this.allUserNames);
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void addUser(String name) {
        allUserNames.add(name);
    }

    public void deleteUser(String name) {
        allUserNames.remove(name);
    }
}
