package me.smudge.client.items.chessboard.pieces;

import me.smudge.client.game.ChessBoard;
import me.smudge.client.game.ChessColour;
import me.smudge.client.game.Tile;
import me.smudge.client.positions.TilePosition;

import java.util.ArrayList;

public class King extends Piece {

    /**
     * Create a new instance of {@link Piece}
     * Create a new instance of {@link King}
     * @param colour Colour of the chess piece
     */
    public King(ChessColour colour) {
        super(colour);
    }

    @Override
    public String getPathWhite() {
        return "src/main/resources/pieces/white_king.png";
    }

    @Override
    public String getPathBlack() {
        return "src/main/resources/pieces/black_king.png";
    }

    @Override
    public boolean canJump() {
        return false;
    }

    @Override
    public int getValue() {
        return 999;
    }

    @Override
    public ArrayList<Tile> getValidPositions(ChessBoard board, Tile tile) {
        ArrayList<Tile> tiles = new ArrayList<>();
        TilePosition position = tile.getTilePosition();

        tiles.add(board.getTile(position.addVector(0, 1, this.getColour())));
        tiles.add(board.getTile(position.addVector(0, -1, this.getColour())));
        tiles.add(board.getTile(position.addVector(1, 0, this.getColour())));
        tiles.add(board.getTile(position.addVector(-1, 0, this.getColour())));

        tiles.add(board.getTile(position.addVector(1, 1, this.getColour())));
        tiles.add(board.getTile(position.addVector(-1, 1, this.getColour())));
        tiles.add(board.getTile(position.addVector(1, -1, this.getColour())));
        tiles.add(board.getTile(position.addVector(-1, -1, this.getColour())));
        return tiles;
    }

    @Override
    public ArrayList<Tile> getTakePositions(ChessBoard board, Tile tile) {
        return this.getValidPositions(board, tile);
    }
}
