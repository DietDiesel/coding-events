package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name can't be blank. Sorry!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters. Please try again")
    private String name;

    @Size(max = 500, message = "Description too long, please try again")
    private String description;

    @NotBlank(message = "Email can't be blank. Sorry!")
    @Email(message = "Invalid email address, please try again")
    private String contactEmail;

    @NotBlank(message = "Location can't be blank. Sorry!")
    @NotNull(message = "Please provide a location for this event")
    private String location;

    @AssertTrue(message = "Please only submit events that require registration")
    private boolean regRequired;

    @DecimalMin(value = "1", message = "Please submit an event that actually has attendees, lol")
    private int attendees;

    @NotNull(message = "Please submit a future event")
    private String eventDate;

    public Event() {}

    public Event(String name, String description, String contactEmail, String location, boolean regRequired, int attendees, String eventDate) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.regRequired = regRequired;
        this.attendees = attendees;
        this.eventDate = eventDate;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() { return contactEmail; }

    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public boolean isRegRequired() { return regRequired; }

    public void setRegRequired(boolean regRequired) { this.regRequired = regRequired; }

    public int getAttendees() { return attendees; }

    public void setAttendees(int attendees) { this.attendees = attendees; }

    public String getEventDate() { return eventDate; }

    public void setEventDate(String eventDate) { this.eventDate = eventDate; }

    @Override
    public String toString() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
