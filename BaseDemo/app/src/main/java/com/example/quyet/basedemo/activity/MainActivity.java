package com.example.quyet.basedemo.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.example.quyet.basedemo.R;
import com.example.quyet.basedemo.adapter.DebtRecycleViewAdapter;
import com.example.quyet.basedemo.databinding.ActivityMainBinding;
import com.example.quyet.basedemo.viewmodel.BaseViewModel;
import com.example.quyet.basedemo.viewmodel.MainActivityViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> {
    @Override
    protected void onCreateActivity() {
        getBinding().rvDebts.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        getViewModel().setAdapter(new DebtRecycleViewAdapter(getApplicationContext(), R.layout.item_debt));
        getViewModel().getAdapter().setListItem(MainActivityViewModel.getList());
        getViewModel().getAdapter().setPresenter(new onItemClick());
        getBinding().rvDebts.setAdapter(getViewModel().getAdapter());
    }

    @Override
    protected int getVariableId() {
        return BR.viewmodel;
    }

    @Override
    protected MainActivityViewModel setViewModel() {
        return new MainActivityViewModel() ;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private class onItemClick implements com.example.quyet.basedemo.adapter.BaseRecycleViewApdapter.Presenter {
        @Override
        public void onClick(BaseViewModel baseViewModel) {
            Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
        }
    }
}
