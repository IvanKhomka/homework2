package jbdctask.oldprojectclasses;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String name;
    private LocalDateTime creationDate;

    public User(int id, String name, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }


    public int getId() {
        return id; }
    public String getName() {
        return name; }
    public LocalDateTime getCreationDate() {
        return creationDate; }
}
