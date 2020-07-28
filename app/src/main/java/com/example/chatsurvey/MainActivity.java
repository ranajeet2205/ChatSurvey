package com.example.chatsurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<SurveyModel> surveyList = new ArrayList<>();

    private List<OptionsModel> optionModelList1 = new ArrayList<>();
    private List<OptionsModel> optionModelList2 = new ArrayList<>();
    private List<OptionsModel> optionModelList3 = new ArrayList<>();
    private List<OptionsModel> optionModelList4 = new ArrayList<>();
    private List<OptionsModel> optionModelList5 = new ArrayList<>();
    private SurveyAdapter surveyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        optionModelList1.add(new OptionsModel(1,"option1 Hint1"));
        optionModelList1.add(new OptionsModel(1,"option1 Hint2"));
        optionModelList1.add(new OptionsModel(1,"option1 Hint3"));

        optionModelList2.add(new OptionsModel(2,"option2 Hint1"));
        optionModelList2.add(new OptionsModel(2,"option2 Hint2"));
        optionModelList2.add(new OptionsModel(2,"option2 Hint3"));
        optionModelList2.add(new OptionsModel(2,"option2 Hint4"));

        optionModelList3.add(new OptionsModel(3,"option3 Hint1"));
        optionModelList3.add(new OptionsModel(3,"option3 Hint2"));
        optionModelList3.add(new OptionsModel(3,"option3 Hint3"));

        optionModelList4.add(new OptionsModel(4,"option4 Hint1"));
        optionModelList4.add(new OptionsModel(4,"option4 Hint2"));
        optionModelList4.add(new OptionsModel(4,"option4 Hint3"));
        optionModelList4.add(new OptionsModel(4,"option4 Hint4"));

        optionModelList5.add(new OptionsModel(5,"option5 Hint1"));
        optionModelList5.add(new OptionsModel(5,"option5 Hint2"));
        optionModelList5.add(new OptionsModel(5,"option5 Hint3"));
        optionModelList5.add(new OptionsModel(5,"option5 Hint4"));
        optionModelList5.add(new OptionsModel(5,"option5 Hint5"));

        surveyList.add(new SurveyModel("Question1","Answer1",optionModelList1,true,false));
        surveyList.add(new SurveyModel("Question2","Answer2",optionModelList2,false,false));
        surveyList.add(new SurveyModel("Question3","Answer3",optionModelList3,false,false));
        surveyList.add(new SurveyModel("Question4","Answer4",optionModelList4,false,false));
        surveyList.add(new SurveyModel("Question5","Answer5",optionModelList5,false,false));

        surveyAdapter = new SurveyAdapter(surveyList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(surveyAdapter);
    }
}