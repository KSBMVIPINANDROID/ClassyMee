package com.ksbm.ontu.foundation.drawing;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.drawing.Util.CanvasView;
import com.ksbm.ontu.R;
import com.ksbm.ontu.foundation.drawing.item.ColorList;
import com.ksbm.ontu.foundation.drawing.util.Constant;


import java.util.List;


public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private Activity activity;
    private CanvasView customCanvas;
    private List<ColorList> colorLists;
    int row_index = -1;

    public ColorAdapter(Activity activity, List<ColorList> colorLists, CanvasView customCanvas) {
        this.activity = activity;
        this.colorLists = colorLists;
        this.customCanvas = customCanvas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.color_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        try {
            holder.view.setBackgroundColor(colorLists.get(position).getColor());
        } catch (Exception e) {
            Log.d("error_color", e.toString());
        }

//        if (row_index == position) {
//            holder.iv_selected.setVisibility(View.VISIBLE);
//        } else {
//            holder.iv_selected.setVisibility(View.GONE);
//        }

        if (Constant.color_chose == colorLists.get(position).getColor()) {
            holder.iv_selected.setVisibility(View.VISIBLE);
        } else {
            holder.iv_selected.setVisibility(View.INVISIBLE);
        }

        holder.view.setOnClickListener(v -> {
            row_index = position;
            Constant.color_chose = colorLists.get(position).getColor();
            customCanvas.paintColor(Constant.color_chose);

            notifyDataSetChanged();
        });

    }

    @Override
    public int getItemCount() {
        return colorLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;
        ImageView iv_selected;

        public ViewHolder(View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view_color_adapter);
            iv_selected = itemView.findViewById(R.id.iv_selected);

        }
    }
}
