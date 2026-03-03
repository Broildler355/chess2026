package com.example;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private boolean king = false;
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
         
        try {
            if (this.img == null) {
                System.out.println("trying to open "+img_file);
                this.img = ImageIO.read(new File(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    public void crown(boolean b) {
        king = b;
    }
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square> controls = new ArrayList<>();
        private Square s;
        s = start;
        int m = 0;
        int y = 0;
        while(m=0) {
        if (king) {
//down to the right is in bounds for jumps for takes
            if(s.getRow()+2<=7 && s.getCol()+2<=7){
                //there is a piece of opposite color down and to the right of us and no piece preventing a jump
                if(b.getSquareArray()[s.getRow()+1][s.getCol()+1].isOccupied() && b.getSquareArray()[s.getRow()+1][s.getCol()+1].getOccupyingPiece().getColor()!=color && !b.getSquareArray()[s.getRow()+2][s.getCol()+2].isOccupied()) {
                    for (int x = 0; x < controls.size(); x++) {
                        if(b.getSquareArray()[s.getRow()+2][s.getCol()+2]==controls.get(x)) {
                            y++;
                        }
                        else if(b.getSquareArray()[s.getRow()+2][s.getCol()+2]==b.getSquareArray()[start.getRow()][start.getCol()]) {
                            y++;
                        }
                    }
                    if (y = 0) {
                        controls.add(b.getSquareArray()[s.getRow()+2][s.getCol()+2]);
                    }
                    y =0;
                }
            }

            //down and to the left is in bounds for taking jumps
            if(s.getRow()+2<=7 && s.getCol()-2<=7){
                //there is a piece of opposite color down and to the right of us and no piece preventing a jump
                if(b.getSquareArray()[s.getRow()+1][s.getCol()-1].isOccupied() && b.getSquareArray()[s.getRow()+1][s.getCol()-1].getOccupyingPiece().getColor()!=color && !b.getSquareArray()[s.getRow()+2][s.getCol()-2].isOccupied()) {
                    for (int x = 0; x < controls.size(); x++) {
                        if(b.getSquareArray()[s.getRow()+2][s.getCol()-2]==controls.get(x)) {
                            y++;
                        }
                        else if(b.getSquareArray()[s.getRow()+2][s.getCol()-2]==b.getSquareArray()[start.getRow()][start.getCol()]) {
                            y++;
                        }
                    }
                    if (y = 0) {
                        controls.add(b.getSquareArray()[s.getRow()+2][s.getCol()-2]);
                    }
                    y =0;
                }
            }
        }

            //start of always moves
            //up to the right is in bounds for jumps for takes
            if(s.getRow()-2<=7 && s.getCol()+2<=7){
                //there is a piece of opposite color down and to the right of us and no piece preventing a jump
                if(b.getSquareArray()[s.getRow()-1][s.getCol()+1].isOccupied() && b.getSquareArray()[s.getRow()-1][s.getCol()+1].getOccupyingPiece().getColor()!=color && !b.getSquareArray()[s.getRow()-2][s.getCol()+2].isOccupied()) {
                    for (int x = 0; x < controls.size(); x++) {
                        if(b.getSquareArray()[s.getRow()-2][s.getCol()+2]==controls.get(x)) {
                            y++;
                        }
                        else if(b.getSquareArray()[s.getRow()-2][s.getCol()+2]==b.getSquareArray()[start.getRow()][start.getCol()]) {
                            y++;
                        }
                    }
                    if (y = 0) {
                        controls.add(b.getSquareArray()[s.getRow()-2][s.getCol()+2]);
                    }
                    y =0;
                }
            }
            
            //up and to the left is in bounds for taking jumps
            if(s.getRow()-2<=7 && s.getCol()-2<=7){
                //there is a piece of opposite color down and to the right of us and no piece preventing a jump
                if(b.getSquareArray()[s.getRow()-1][s.getCol()-1].isOccupied() && b.getSquareArray()[s.getRow()-1][s.getCol()-1].getOccupyingPiece().getColor()!=color && !b.getSquareArray()[s.getRow()-2][s.getCol()-2].isOccupied()) {
                    for (int x = 0; x < controls.size(); x++) {
                        if(b.getSquareArray()[s.getRow()-2][s.getCol()-2]==controls.get(x)) {
                            y++;
                        }
                        else if(b.getSquareArray()[s.getRow()+2][s.getCol()-2]==b.getSquareArray()[start.getRow()][start.getCol()]) {
                            y++;
                        }
                    }
                    if (y = 0) {
                        controls.add(b.getSquareArray()[s.getRow()-2][s.getCol()-2]);
                    }
                    y =0;
                }
            }
        }
     return controls;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        ArrayList<Square> moves = new ArrayList<>();
        //crowned only moves
        if (king) {
//down to the right is in bounds for jumps for takes
            if(start.getRow()+2<=7 && start.getCol()+2<=7){
                //there is a piece of opposite color down and to the right of us and no piece preventing a jump
                if(b.getSquareArray()[start.getRow()+1][start.getCol()+1].isOccupied() && b.getSquareArray()[start.getRow()+1][start.getCol()+1].getOccupyingPiece().getColor()!=color && !b.getSquareArray()[start.getRow()+2][start.getCol()+2].isOccupied()) {
                    moves.add(b.getSquareArray()[start.getRow()+2][start.getCol()+2]);
                }
            }
            //down and to the right is in bounds for non taking jumps
            if(start.getRow()+1<=7&&start.getCol()+1<=7) {
                if(!b.getSquareArray()[start.getRow()+1][start.getCol()+1].isOccupied() ) {
                    moves.add(b.getSquareArray()[start.getRow()+1][start.getCol()+1]);
                }
            }

            //down and to the left is in bounds for taking jumps
            if(start.getRow()+2<=7 && start.getCol()-2>=0){
                //there is a piece of opposite color down and to the left of us and no piece preventing a jump
                if(b.getSquareArray()[start.getRow()+1][start.getCol()-1].isOccupied() && b.getSquareArray()[start.getRow()+1][start.getCol()-1].getOccupyingPiece().getColor()!=color && !b.getSquareArray()[start.getRow()+2][start.getCol()-2].isOccupied()) {
                    moves.add(b.getSquareArray()[start.getRow()+2][start.getCol()-2]);
                }
            }
            //down and to the left is in bounds for non taking jumps
            if(start.getRow()+1<=7 && start.getCol()-1>=0 && !b.getSquareArray()[start.getRow()+1][start.getCol()-1].isOccupied()) {
                 moves.add(b.getSquareArray()[start.getRow()+1][start.getCol()-1]);
            }
        }

            //start of always moves
            //up to the right is in bounds for jumps for takes
            if(start.getRow()-2>=0 && start.getCol()+2<=7){
                //there is a piece of opposite color up and to the right of us and no piece preventing a jump
                if(b.getSquareArray()[start.getRow()-1][start.getCol()+1].isOccupied() && b.getSquareArray()[start.getRow()-1][start.getCol()+1].getOccupyingPiece().getColor()!=color && !b.getSquareArray()[start.getRow()-2][start.getCol()+2].isOccupied()) {
                    moves.add(b.getSquareArray()[start.getRow()-2][start.getCol()+2]);
                }
            }
            //up and to the right is in bounds for non taking jumps
            if(start.getRow()-1>=0&&start.getCol()+1<=7) {
                if(!b.getSquareArray()[start.getRow()-1][start.getCol()+1].isOccupied() ) {
                    moves.add(b.getSquareArray()[start.getRow()-1][start.getCol()+1]);
                }
            }

            //up and to the left is in bounds for taking jumps
            if(start.getRow()-2>=0 && start.getCol()-2>=0){
                //there is a piece of opposite color up and to the left of us and no piece preventing a jump
                if(b.getSquareArray()[start.getRow()-1][start.getCol()-1].isOccupied() && b.getSquareArray()[start.getRow()-1][start.getCol()-1].getOccupyingPiece().getColor()!=color && !b.getSquareArray()[start.getRow()-2][start.getCol()-2].isOccupied()) {
                    moves.add(b.getSquareArray()[start.getRow()-2][start.getCol()-2]);
                }
            }
            //up and to the left is in bounds for non taking jumps
            if(!b.getSquareArray()[start.getRow()-1][start.getCol()+1].isOccupied() && start.getRow()-1>=0 && start.getCol()-1>=0) {
                 moves.add(b.getSquareArray()[start.getRow()-1][start.getCol()-1]);
            }
    	return moves;
    }
}