package com.example.chatsurvey;

import java.util.List;

public class SurveyModel {
    private String questions;
    private String answers;
    private List<OptionsModel> options;
    private boolean activeOrInactive;
    private boolean answerGiven;

    public SurveyModel(String questions, String answers, List<OptionsModel> options, boolean activeOrInactive,boolean answerGiven) {
        this.questions = questions;
        this.answers = answers;
        this.options = options;
        this.activeOrInactive = activeOrInactive;
        this.answerGiven = answerGiven;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public List<OptionsModel> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsModel> options) {
        this.options = options;
    }

    public boolean isActiveOrInactive() {
        return activeOrInactive;
    }

    public void setActiveOrInactive(boolean activeOrInactive) {
        this.activeOrInactive = activeOrInactive;
    }

    public boolean isAnswerGiven() {
        return answerGiven;
    }

    public void setAnswerGiven(boolean answerGiven) {
        this.answerGiven = answerGiven;
    }
}
