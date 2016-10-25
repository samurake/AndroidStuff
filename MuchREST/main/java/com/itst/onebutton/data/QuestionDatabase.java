package com.itst.onebutton.data;

import java.util.ArrayList;

/**
 * Created by andrei on 06/03/16.
 */
public class QuestionDatabase {
    public ArrayList<Question> questions;

    public QuestionDatabase(){
        questions = new ArrayList<>();
        questions.add(new Question(35823495, "RecyclerView get the clicked item details - Android",true, 0, 1));
        questions.add(new Question(35823815, "Android set Activity size",false, 0, 0));
        questions.add(new Question(35823590, "Implementing an android service that reads a button sensor input on Arduino through bluetooth",false, 0, 0));
        questions.add(new Question(24944925, "Background image jumps when address bar hides iOS/Android/Mobile Chrome",true, 57, 13));
        questions.add(new Question(20830504, "Android, Chrome. URL address bar affecting image with max-width, in landscape",true, 3, 2));
        questions.add(new Question(35819803, "Android Studio 2.0. Changes in code dont take effect",false, -2, 1));
        questions.add(new Question(35823495, "I was lazy. RecyclerView get the clicked item details - Android",true, 0, 1));
        questions.add(new Question(35823815, "I was lazy. Android set Activity size",false, 0, 0));
        questions.add(new Question(35823590, "I was lazy. Implementing an android service that reads a button sensor input on Arduino through bluetooth",false, 0, 0));
        questions.add(new Question(24944925, "I was lazy. Background image jumps when address bar hides iOS/Android/Mobile Chrome",true, 57, 13));
        questions.add(new Question(20830504, "I was lazy. Android, Chrome. URL address bar affecting image with max-width, in landscape",true, 3, 2));
        questions.add(new Question(35819803, "I was lazy. Android Studio 2.0. Changes in code dont take effect",false, -2, 1));
        questions.add(new Question(35823495, "I was still lazy. RecyclerView get the clicked item details - Android",true, 0, 1));
        questions.add(new Question(35823815, "I was still lazy. Android set Activity size",false, 0, 0));
        questions.add(new Question(35823590, "I was still lazy. Implementing an android service that reads a button sensor input on Arduino through bluetooth",false, 0, 0));
        questions.add(new Question(24944925, "I was still lazy. Background image jumps when address bar hides iOS/Android/Mobile Chrome",true, 57, 13));
        questions.add(new Question(20830504, "I was still lazy. Android, Chrome. URL address bar affecting image with max-width, in landscape",true, 3, 2));
        questions.add(new Question(35819803, "I was still lazy. Android Studio 2.0. Changes in code dont take effect",false, -2, 1));
    }
}
