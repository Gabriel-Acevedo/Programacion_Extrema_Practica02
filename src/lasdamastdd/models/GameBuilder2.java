/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasdamastdd.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabri
 */
public class GameBuilder2 {
    
    private List<String> strings;
    private char[] piecesTypes = new char[]{'b', 'n', 'B', 'N'};
    private Piece[] pieces = new Piece[]{
        new Pawn(Color.WHITE),
        new Pawn(Color.BLACK),
        new Draught(Color.WHITE),
        new Draught(Color.BLACK)
    };

    public GameBuilder2() {
        this.strings = new ArrayList<String>();
    }

    public GameBuilder2 row(String string) {
        this.strings.add(string);
        return this;
    }

    public Game build() {
        Board board = new Board();
        char character;
        int ordinal;
        for (int i = 0; i < this.strings.size(); i++) {
            for (int j = 0; j < this.strings.size(); j++) {
                character = this.strings.get(i).charAt(j);
                for (int id = 0; id < piecesTypes.length; id++) {
                   if (piecesTypes[id] == character) {
                        board.put(new Coordinate(i, j), pieces[id]);
                   }
                }
            }
        }
        return new Game(board);
    }
    
}
