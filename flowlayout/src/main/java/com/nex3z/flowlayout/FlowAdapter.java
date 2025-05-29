package com.nex3z.flowlayout;

import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

public abstract class FlowAdapter<VH extends FlowAdapter.ViewHolder> {

    private WeakReference<FlowLayout> mFlowLayoutRef;

    public void setFlowLayout(FlowLayout layout) {
        mFlowLayoutRef = new WeakReference<>(layout);
    }

    public FlowLayout getFlowLayout() {
        return mFlowLayoutRef != null ? mFlowLayoutRef.get() : null;
    }

    public abstract int getItemCount();

    public abstract VH createViewHolder(ViewGroup parent, int viewType);

    public abstract void bindView(VH view, int position);

    public int getItemViewType(int position) {
        return position;
    }

    public void notifyDataSetChanged() {
        FlowLayout layout = getFlowLayout();
        if (layout != null) {
            layout.requestLayout();
        }
    }

    public static class ViewHolder {
        public View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }
    }
}