package com.example.quyet.basedemo.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.quyet.basedemo.viewmodel.BaseViewModel;

public abstract class BaseActivity<T extends ViewDataBinding,V extends BaseViewModel> extends AppCompatActivity {
    private T binding;
    private V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
        onCreateActivity();
    }

    private void initActivity() {
        // set content view
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        //set view model
        viewModel = setViewModel();
        //set variable for binding
        binding.setVariable(getVariableId(), viewModel);

    }
    protected abstract void onCreateActivity();
    protected abstract int getVariableId();
    protected T getBinding() {
        return binding;
    }

    public V getViewModel() {
        return viewModel;
    }

    protected abstract V setViewModel();

    public abstract int getLayoutId();
}
