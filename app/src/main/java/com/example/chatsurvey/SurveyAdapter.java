package com.example.chatsurvey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder> implements OptionsAdapter.OptionClickInterface {

    private List<SurveyModel> surveyModelList;
    private OptionsAdapter optionsAdapter;
    private Context context;
    private int holderPosition;

    public SurveyAdapter(List<SurveyModel> surveyModelList,Context context) {
        this.surveyModelList = surveyModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public SurveyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.survey_list_item,parent,false);
        return new SurveyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SurveyViewHolder holder, int position) {
        SurveyModel model = surveyModelList.get(position);
        holder.qstnTxtView.setText(model.getQuestions());
        holder.ansTxtView.setText(model.getAnswers());
        if (model.isActiveOrInactive() && !model.isAnswerGiven()){
            holder.ansTxtView.setVisibility(View.GONE);
            holder.qstnTxtView.setVisibility(View.VISIBLE);
            holder.optionsRecyclerView.setVisibility(View.VISIBLE);
        }else if (model.isAnswerGiven()){
            holder.ansTxtView.setVisibility(View.VISIBLE);
            holder.qstnTxtView.setVisibility(View.VISIBLE);
            holder.optionsRecyclerView.setVisibility(View.GONE);
        }else{
            holder.ansTxtView.setVisibility(View.GONE);
            holder.qstnTxtView.setVisibility(View.GONE);
            holder.optionsRecyclerView.setVisibility(View.GONE);
        }
        optionsAdapter = new OptionsAdapter(model.getOptions(),this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
        //layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        holder.optionsRecyclerView.setLayoutManager(layoutManager);
        holder.optionsRecyclerView.setAdapter(optionsAdapter);
        holderPosition = position;
    }

    @Override
    public int getItemCount() {
        return surveyModelList.size();
    }

    @Override
    public void optionClick(String option,int position) {
        surveyModelList.get(position-1).setAnswers(option);
        surveyModelList.get(position-1).setAnswerGiven(true);
        if (position<surveyModelList.size()) {
            surveyModelList.get(position).setActiveOrInactive(true);
        }
        notifyDataSetChanged();
    }


    public class SurveyViewHolder extends RecyclerView.ViewHolder{
        TextView qstnTxtView,ansTxtView;
        RecyclerView optionsRecyclerView;
        public SurveyViewHolder(@NonNull View itemView) {
            super(itemView);
            qstnTxtView = itemView.findViewById(R.id.question_txt_view);
            ansTxtView = itemView.findViewById(R.id.ans_txt_view);
            optionsRecyclerView = itemView.findViewById(R.id.options_recycler_view);
        }
    }
}
