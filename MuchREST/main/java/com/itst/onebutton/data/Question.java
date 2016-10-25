package com.itst.onebutton.data;

/**
 * ITst Android training March 2016
 */
public class Question {
    public String title;
    public boolean is_answered;
    public int question_id, answer_count, score;

    public Question() {
    }

    public Question(int question_id, String title, boolean is_answered, int score, int answer_count) {
        this.title = title;
        this.is_answered = is_answered;
        this.question_id = question_id;
        this.answer_count = answer_count;
        this.score = score;
    }
}
