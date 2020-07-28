package com.example.chatsurvey;

import java.util.List;

public class OptionsModel {
    private int questionNo;
    private String options;

    public OptionsModel(int question, String options) {
        this.questionNo = question;
        this.options = options;
    }

    public int getQuestion() {
        return questionNo;
    }

    public void setQuestion(int question) {
        this.questionNo = question;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
