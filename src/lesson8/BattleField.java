package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;

    private int size;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.white);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.gameFinished) {
                    Logic.humanTurn(cellX, cellY);
                }
            }
        });
    }

    public static void check(int[][] boardArray) {
        for (int i = 0; i < 3; i++) {
            if (boardArray[i][0] == boardArray[i][1] && boardArray[i][0] == boardArray[i][2]) {
                System.out.println("The winner is: " + boardArray[i][0]);
                return;
            } else if (boardArray[0][i] == boardArray[1][i] && boardArray[0][i] == boardArray[2][i]) {
                System.out.printf("The winner is: " + boardArray[0][i]);
                return;
            }
        }

        if (boardArray[0][0] == boardArray[1][1] && boardArray[0][0] == boardArray[2][2]) {
            System.out.println("The winner is: " + boardArray[0][0]);
        } else if (boardArray[0][2] == boardArray[1][1] && boardArray[0][2] == boardArray[2][0]) {
            System.out.println("The winner is: " + boardArray[1][1]);
        } else {
            System.out.println("ITS A DRAW");
        }
    }

    void startNewGame(int size, int winningLength) {
        this.size = size;
        this.winningLength = winningLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        cellWidth = getWidth() / size;
        cellHeight = getHeight() / size;


        g.setColor(Color.black);
        ((Graphics2D) g).setStroke(new BasicStroke(2f));

        for (int i = 0; i < size; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);

        }
        for (int i = 0; i < size; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[j][i] == Logic.DOT_X) {
                    drawX(g, i, j);
                }
            }
        }
        repaint();

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[j][i] == Logic.DOT_0) {
                    draw0(g, i, j);
                }
            }
        }

    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(2f));
        g.setColor(Color.blue);
        g.drawLine(cellX * cellWidth, cellY * cellHeight, cellX * cellWidth + cellWidth, cellY * cellHeight + cellHeight);
        g.drawLine(cellX * cellWidth + cellWidth, cellY * cellHeight,
                cellX * cellWidth, cellY * cellHeight + cellHeight);

    }

    void draw0(Graphics g, int cellX, int cellY) {
        g.setColor(Color.blue);
        ((Graphics2D) g).setStroke(new BasicStroke(2f));
        g.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);
    }
}
