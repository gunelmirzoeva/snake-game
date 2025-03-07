package logic;

import java.awt.*;
import java.util.ArrayList;
import utils.Direction;

public class Snake {
    private ArrayList<Point> snakeBody;
    private Direction direction;

    public Snake(int startX, int startY) {
        snakeBody = new ArrayList<>();
        snakeBody.add(new Point(startX, startY));
        direction = Direction.UP;
    }
    public void move() {
        Point head = snakeBody.get(0);
        Point newHead = new Point(head);


        switch (direction) {
            case UP -> newHead.y--;
            case DOWN -> newHead.y++;
            case LEFT -> newHead.x--;
            case RIGHT -> newHead.x++;
        }

        snakeBody.add(0, newHead);

        snakeBody.remove(snakeBody.size() - 1);
    }

    public void grow() {
        snakeBody.add(new Point(snakeBody.get(snakeBody.size() - 1)));
    }

    public boolean checkSelfCollision() {
        Point head = snakeBody.get(0);
        for(int i = 1; i < snakeBody.size(); i++) {
            if(head.equals(snakeBody.get(i))) {
                return true;
            }
        }
        return false;
    }
}
