package com.itst.onebutton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itst.onebutton.data.Question;
import com.itst.onebutton.data.QuestionDatabase;

import java.util.ArrayList;

/**
 * Created by andrei on 06/03/16.
 */
public class SearchResultsAdaptor extends BaseAdapter {

    QuestionDatabase db = new QuestionDatabase();

    public SearchResultsAdaptor(ArrayList<Question> questions){
        db.questions = questions;
    }
    @Override
    public int getCount() {
        return db.questions.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_search_result, parent, false);
        }

        TextView titlu = (TextView) convertView.findViewById(R.id.title);
        Question question = db.questions.get(position);
        titlu.setText(question.title);

        return convertView;
    }
}
