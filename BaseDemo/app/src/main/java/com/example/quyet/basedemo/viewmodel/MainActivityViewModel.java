package com.example.quyet.basedemo.viewmodel;

import android.databinding.Bindable;

import com.example.quyet.basedemo.adapter.DebtRecycleViewAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivityViewModel extends BaseViewModel {
    public static List<DebtViewModel> list = new ArrayList<DebtViewModel>();
    static  {
        for (int i = 0; i < 20; i++) {
            list.add(new DebtViewModel("quyet" + i, 1000 *i, new Date("20/2/1996"), "nothing"));
        }
    }

    private DebtRecycleViewAdapter adapter;

    public DebtRecycleViewAdapter getAdapter() {
        return adapter;
    }

    public static List<DebtViewModel> getList() {
        return list;
    }

    public void setAdapter(DebtRecycleViewAdapter adapter) {
        this.adapter = adapter;
    }
}
