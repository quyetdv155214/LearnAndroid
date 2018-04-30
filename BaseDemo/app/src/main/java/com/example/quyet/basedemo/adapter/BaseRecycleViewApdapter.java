package com.example.quyet.basedemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.android.databinding.library.baseAdapters.BR;

import com.example.quyet.basedemo.viewholder.BaseViewHolder;
import com.example.quyet.basedemo.viewmodel.BaseViewModel;

import java.util.List;

public class BaseRecycleViewApdapter<T extends BaseViewModel> extends RecyclerView.Adapter<BaseViewHolder> {
    protected List<T> listItem;
    protected Presenter presenter;
    protected final LayoutInflater layoutInflater;
    private int layoutId;

    public BaseRecycleViewApdapter(Context context, int layoutId) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseViewHolder(DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        T item = listItem.get(position);
        holder.getBinding().setVariable(BR.viewmodel, item);
        holder.getBinding().setVariable(BR.presenter, presenter);
        holder.getBinding().executePendingBindings();


    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public interface Presenter<T extends BaseViewModel> {
        void onClick(T t);
    }
    public void remove(int position) {
        listItem.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        listItem.clear();
        notifyDataSetChanged();
    }
    public void add(T viewmodel){
        listItem.add(viewmodel);
        notifyDataSetChanged();
    }
    public void add(T viewModel, int position){
        listItem.add(position, viewModel);
        notifyDataSetChanged();
    }
    public void addList(List<T> list){
        listItem.addAll(list);
        notifyDataSetChanged();
    }

    public void setListItem(List<T> listItem) {
        this.listItem = listItem;
        notifyDataSetChanged();
    }
}
