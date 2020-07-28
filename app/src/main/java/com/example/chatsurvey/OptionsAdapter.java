package com.example.chatsurvey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionsViewHolder> {

    private List<OptionsModel> questionList ;
    private OptionClickInterface optionClickInterface;

    public OptionsAdapter(List<OptionsModel> questionList, OptionClickInterface optionClickInterface) {
        this.questionList = questionList;
        this.optionClickInterface = optionClickInterface;
    }

    @NonNull
    @Override
    public OptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.options_list_item,parent,false);
        return new OptionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionsViewHolder holder, final int position) {
        holder.optionsTxtView.setText(questionList.get(position).getOptions());
        holder.optionsTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionClickInterface.optionClick(questionList.get(position).getOptions(),questionList.get(position).getQuestion());
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class OptionsViewHolder extends RecyclerView.ViewHolder {
        TextView optionsTxtView;
        public OptionsViewHolder(@NonNull View itemView) {
            super(itemView);
            optionsTxtView = itemView.findViewById(R.id.options_txt_view);
        }
    }

    public interface OptionClickInterface{
         void optionClick(String option,int position);
    }
}
