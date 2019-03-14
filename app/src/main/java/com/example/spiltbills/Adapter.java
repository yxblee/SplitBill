package com.example.spiltbills;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.splitbills.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder>{

    private Context context;

    private List<Activity> activityList;
    private static String MAIN_ADAPTER = "MAIN_ADAPTER";

    private List<Expense> expenseList;
    private static String EXPENSE_ADAPTER = "EXPENSE_ADAPTER";

    private String type;

    //Recycler onClick
    private OnItemClickListener myListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        myListener = listener;
    }

    public Adapter mainAdapter(Context context, List<Activity> activityList, String type) {
        this.context = context;
        this.activityList = activityList;
        this.type = type;
        return this;
    }
    public Adapter ExpenseAdapter(Context context, List<Expense> expenseList, String type) {
        this.context = context;
        this.expenseList = expenseList;
        this.type = type;
        return this;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_layout, null);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        if(type == MAIN_ADAPTER) {
            final Activity activity = activityList.get(position);
            holder.textViewInfo.setText(activity.getName());
        } else if(type == EXPENSE_ADAPTER){
            final Expense expense = expenseList.get(position);
            holder.textViewInfo.setText(expense.getName());
        }

        //image
        //holder.imageView.setImageDrawable(context.getResources().getDrawable(activity.getImage(), null));
    }

    @Override
    public int getItemCount() {
        if(type == MAIN_ADAPTER) {
            return activityList.size();
        } else if(type == EXPENSE_ADAPTER){
            return expenseList.size();
        }
        return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewInfo;
        RelativeLayout relativeLayout;
        public viewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewInfo = itemView.findViewById(R.id.textViewInfo);

            itemView.setOnClickListener(v -> {
                if(myListener != null) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        myListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
