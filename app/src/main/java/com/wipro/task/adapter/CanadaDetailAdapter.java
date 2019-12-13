package com.wipro.task.adapter;

import com.wipro.task.R;
import com.wipro.task.databinding.CanadadetailListItemBinding;
import com.wipro.task.model.CanadaDetailModel;
import com.wipro.task.util.Adapter;

import java.util.List;

public class CanadaDetailAdapter extends Adapter<CanadadetailListItemBinding, CanadaDetailModel> {

    public CanadaDetailAdapter(List<CanadaDetailModel> data) {
        super(data);
    }

    @Override
    protected int getLayout() {
        return R.layout.canadadetail_list_item;
    }

    @Override
    protected void bindData(CanadadetailListItemBinding binding, CanadaDetailModel model) {
        binding.setCanadaDetail(model);
    }
}
