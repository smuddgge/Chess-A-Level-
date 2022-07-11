package me.smudge.client.items.chessboard;

import me.smudge.client.items.Item;
import me.smudge.client.positions.ModularPosition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the interface for the chessboard
 */
public abstract class ChessBoardInterface extends Item {

    /**
     * The chessboard panel
     */
    private JButton panel = new JButton();

    /**
     * Used to create a new chessboard interface
     * @param modularPosition The position of the chessboard
     */
    public ChessBoardInterface(ModularPosition modularPosition) {
        super(modularPosition);
    }

    /**
     * Creates the chessboard based on its position
     */
    private void create() {
        this.panel = new JButton();

        this.panel.setBounds(
                this.getItemRegion().getMin().getX(),
                this.getItemRegion().getMin().getY(),
                this.modularPosition.getWidth(), this.modularPosition.getHeight()
        );

        this.panel.setBackground(Color.white);
        this.getBoard().render(this.panel);

        for (Component component : this.panel.getComponents()) {
            if (!(component instanceof JButton button)) continue;
            button.addActionListener(event -> this.onClick(this.getBoard().getTileAt(this.getMouseLocation())));
        }
    }

    /**
     * Used to get the board
     */
    public abstract Board getBoard();

    /**
     * When the mouse is hovering over a tile
     */
    public abstract void onTileHover(Tile tile);

    /**
     * When the mouse clicks a tile
     */
    public abstract void onClick(Tile tile);

    @Override
    public void updateItem() {
        if (this.getBoard() == null) return;
        this.onTileHover(this.getBoard().getTileAt(this.getMouseLocation()));
    }

    @Override public void onHover() {}
    @Override public void onNotHover() {}

    @Override
    public void render(JPanel frame) {
        this.create();
        frame.add(this.panel);
    }

    @Override
    public Component getComponent() {
        return this.panel;
    }
}
