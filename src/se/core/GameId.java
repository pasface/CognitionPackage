/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.util.Scanner;

/**
 *
 * @author nikki
 */
public class GameId {
    public static int gameId;

    public static int getGameId() {
        return gameId;
    }

    public static void setGameId(String file) {
        XMLReader x = new XMLReader(file);
        Scanner scanner = new Scanner(x.toString());
        scanner.useDelimiter("<game id=\"|\\\">");
        gameId = Integer.parseInt(scanner.next());
    }
    
}
