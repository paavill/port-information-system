package ru.rsreu.RonzhinChistyakov09.commandlayer.commands.captain;

import com.google.gson.annotations.SerializedName;

public class ProductForm {

    @SerializedName("title")
    private String title;

    @SerializedName("number")
    private int number;

    public ProductForm(String title, int number) {
        this.title = title;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
