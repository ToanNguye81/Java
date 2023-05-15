package com.learn5.split.sprlit;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SplitStringAPI {

    @CrossOrigin
    @GetMapping("/rainbow")
    public ArrayList<Rainbow> rainbows() {
        String[] colorList = { "red", "orange", "yellow", "green", "blue", "indigo", "violet" };
        ArrayList<Rainbow> rainbowColorList = new ArrayList<>();

        for (String color : colorList) {
            Rainbow rainbowColor = new Rainbow(color);
            rainbowColorList.add(rainbowColor);
        }
        return rainbowColorList;
    }

    // @GetMapping("/split")
    // public ArrayList<> first() {
    // return String.format("Nguyễn Trần Quốc Toàn");
    // }
}
