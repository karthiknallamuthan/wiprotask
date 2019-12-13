package com.wipro.task.util;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class Adapter<T extends ViewDataBinding, V> extends RecyclerView.Adapter<ViewHolder<T>> {

    protected List<V> data;

    public Adapter(List<V> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        T binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayout(), parent, false);
        return new ViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder<T> holder, int position) {
        bindData(holder.binding, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<V> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    protected abstract @LayoutRes
    int getLayout();

    protected abstract void bindData(T binding, V model);

}
