package com.nex3z.flowlayout.sample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nex3z.flowlayout.FlowAdapter;

import java.util.ArrayList;
import java.util.List;

public class SimpleFlowAdapter extends FlowAdapter<SimpleFlowAdapter.ViewHolder> {
    public SimpleFlowAdapter(List<String> datas) {
        this.datas = datas;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    private List<String> datas = new ArrayList<>();

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_label, null);
        return new ViewHolder(view);
    }

    @Override
    public void bindView(ViewHolder viewHolder, int position) {
        viewHolder.tvTitle.setText(datas.get(position));
    }


    class ViewHolder extends FlowAdapter.ViewHolder {
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}