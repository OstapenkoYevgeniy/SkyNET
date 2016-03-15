package com.gmail.ostapenkoyevgeniy.skynet.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.ostapenkoyevgeniy.skynet.R;
import com.gmail.ostapenkoyevgeniy.skynet.entity.Robot;

import java.util.List;

public class RobotAdapter extends RecyclerView.Adapter<RobotAdapter.RobotViewHolder> {
    private List<Robot> robots;

    public RobotAdapter() {}

    public RobotAdapter(List<Robot> robots) {
        this.robots = robots;
    }

    @Override
    public RobotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        RobotAdapter.RobotViewHolder vh = new RobotAdapter.RobotViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RobotViewHolder holder, int position) {
        holder.robotId.setText(String.valueOf(robots.get(position).getId()));
        holder.robotName.setText(robots.get(position).getName());
        holder.robotType.setText(robots.get(position).getType());
        holder.robotYear.setText(String.valueOf(robots.get(position).getYear()));
    }

    @Override
    public int getItemCount() {
        return robots.size();
    }



    public static class RobotViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv;
        TextView robotId;
        TextView robotName;
        TextView robotType;
        TextView robotYear;

        public RobotViewHolder(View itemView) {
            super(itemView);
            rv = (RecyclerView) itemView.findViewById(R.id.rvAllRobots);
            robotId = (TextView) itemView.findViewById(R.id.tv_recycler_item_id);
            robotName = (TextView) itemView.findViewById(R.id.tv_recycler_item_name);
            robotType = (TextView) itemView.findViewById(R.id.tv_recycler_item_type);
            robotYear = (TextView) itemView.findViewById(R.id.tv_recycler_item_type);
        }
    }
}

