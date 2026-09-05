package org.example.LLDUseCase.movieTicketBooking.entities;

import java.util.List;



public class Theatre {
    private String theatreId;
    private String name;
    List<Screen> screens;

    public Theatre(String theatreId, String name, List<Screen> screens) {
        this.theatreId = theatreId;
        this.name = name;
        this.screens = screens;
    }
    //getters and setters
    public String getTheatreId() {
        return theatreId;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

}
