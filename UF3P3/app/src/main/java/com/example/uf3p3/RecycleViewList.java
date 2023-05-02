package com.example.uf3p3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class RecycleViewList extends RecyclerView.Adapter<RecycleViewList.ViewHolder> {
    private ArrayList<String> text;
    public RecycleViewList(ArrayList<String> dataSet) {
        text = dataSet;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleBook;
        public ViewHolder(View view) {
            super(view);
            titleBook = (TextView) view.findViewById(R.id.chatText);
        }
        public TextView titleBook() {
            return titleBook;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_chat, viewGroup, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.titleBook().setText(text.get(position));
    }
    @Override
    public int getItemCount() {
        return text.size();
    }
}
