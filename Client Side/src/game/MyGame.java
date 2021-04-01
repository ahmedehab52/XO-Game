/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author ELROWAD
 */
public class MyGame {

    String gameId;
    String gameName;
    String gameTimeEnded;
    String moves;
    String playerId1;
    String playerId2;

    public MyGame(String gameId, String gameName, String gameTimeEnded, String moves, String playerId1, String playerId2) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameTimeEnded = gameTimeEnded;
        this.moves = moves;
        this.playerId1 = playerId1;
        this.playerId2 = playerId2;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setGameTimeEnded(String gameTimeEnded) {
        this.gameTimeEnded = gameTimeEnded;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public void setPlayerId1(String playerId1) {
        this.playerId1 = playerId1;
    }

    public void setPlayerId2(String playerId2) {
        this.playerId2 = playerId2;
    }

    public String getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameTimeEnded() {
        return gameTimeEnded;
    }

    public String getMoves() {
        return moves;
    }

    public String getPlayerId1() {
        return playerId1;
    }

    public String getPlayerId2() {
        return playerId2;
    }

}
