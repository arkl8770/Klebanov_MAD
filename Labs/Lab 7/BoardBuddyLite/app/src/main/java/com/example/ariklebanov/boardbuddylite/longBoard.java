package com.example.ariklebanov.boardbuddylite;

public class longBoard {
    private String longboardName;

    public void setLongboardInfo(Integer styleChoice, Integer heightChoice) {
        if (styleChoice == 0){//cruiser
            if (heightChoice == 0) {//high off the ground - cruiser
                longboardName = "Pintail";
            } else {//low off the ground - cruiser
                longboardName = "Basic Cruiser";
            }
        } else {
            if (heightChoice == 0) {//high off the ground - downhill
                longboardName = "Top Mount";
            } else {//low off the ground - downhill
                longboardName = "Drop-deck";
            }
        }
    }

    public String getLongboardName() {
        return longboardName;
    }
}

