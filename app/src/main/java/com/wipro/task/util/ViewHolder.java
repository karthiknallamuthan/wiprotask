package com.wipro.task.util;

import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    T binding;

    ViewHolder(@NonNull T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}

