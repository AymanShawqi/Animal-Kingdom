package com.example.androidl.quizeapp;

/**
 * Created by me on 14/10/2017.
 */

class Animal {
    private String mAnimalName;
    private int mResID;
    private boolean checkboxQ1;
    private boolean checkboxQ2;
    private boolean checkboxQ3;
    private boolean checkboxQ4;

    public boolean isCheckboxQ1() {
        return checkboxQ1;
    }

    public boolean isCheckboxQ2() {
        return checkboxQ2;
    }

    public boolean isCheckboxQ3() {
        return checkboxQ3;
    }

    public boolean isCheckboxQ4() {
        return checkboxQ4;
    }

    public Animal(String animalName, int resID, boolean checkboxQ1, boolean checkboxQ2, boolean checkboxQ3, boolean checkboxQ4) {
        mAnimalName = animalName;
        mResID = resID;
        this.checkboxQ1 = checkboxQ1;
        this.checkboxQ2 = checkboxQ2;
        this.checkboxQ3 = checkboxQ3;
        this.checkboxQ4 = checkboxQ4;
    }

    public String getAnimalName() {
        return mAnimalName;
    }

    public int getResID() {
        return mResID;
    }
}
