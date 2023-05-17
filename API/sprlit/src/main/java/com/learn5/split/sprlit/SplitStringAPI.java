package com.learn5.split.sprlit;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SplitStringAPI {

    @GetMapping("/split")
    public ArrayList<Character> split() {
        String newString = "Nguyễn Trần Quốc Toàn";
        char[] charArray = newString.toCharArray();

        ArrayList<Character> arrayList = new ArrayList<>();
        for (char ch : charArray) {
            arrayList.add(ch);
        }
        return arrayList;
    }
}
