package Homework.CalabashBrothers.Patterns;

import Homework.CalabashBrothers.*;
import Homework.CalabashBrothers.Creatures.*;

public final class YuLin extends Pattern {
    public YuLin() {
        this.row = 5;
        this.column = 5;
        this.type = Type.YULIN;
        this.points = new Point[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.points[i][j] = new Point(i, j);
            }
        }
    }

    @Override
    public void setpattern() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 2 && i != 1) {
                    this.points[i][j].isempty = false;
                }
                if (i == 3){
                    this.points[i][j].isempty = false;
                }
            }
        }
        this.points[1][3].isempty = false;
        this.points[2][1].isempty = false;
        this.points[2][3].isempty = false;
    }

    @Override
    public void putmaincreature() {
        //First, let the Scorpion take the lead.
        points[0][2].putcreature(new Scorpion(), Species.SCORPION);
        //Then, the underlings gather together to support the Scorpion.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (points[i][j].isempty == false && points[i][j].species == Species.FLOWER) {
                    points[i][j].putcreature(new Underling(), Species.UNDERLING);
                }
            }
        }

    }
}
