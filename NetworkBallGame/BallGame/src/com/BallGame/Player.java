package com.BallGame;

import java.awt.Color;

public class Player {

    String username;
    Color teamname; // change to teamname and teamcolor
    long score;

    // take player id and set the color based on that. see ball -> setColor
    public Player(String username, Color teamname) {
        this.username = username;
        this.teamname = teamname;
        this.score = 0;
    }

}
