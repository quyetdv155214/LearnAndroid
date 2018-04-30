package com.example.quyet.basedemo.viewmodel;

import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class DebtViewModel extends BaseViewModel {
    private String debtId;
    private String creditor;
    private double debts;
    private Date dateOfPayment;
    private String debtNote;

    public DebtViewModel(String debtId, String creditor, double debts, Date dateOfPayment, String debtNote) {
        this.debtId = debtId;
        this.creditor = creditor;
        this.debts = debts;
        this.dateOfPayment = dateOfPayment;
        this.debtNote = debtNote;
    }

    public DebtViewModel(String creditor, double debts, Date dateOfPayment, String debtNote) {
        this(UUID.randomUUID().toString().replace("-", ""), creditor, debts, dateOfPayment, debtNote);
    }

    @Bindable
    public String getDebtId() {
        return debtId;
    }

    public void setDebtId(String debtId) {
        this.debtId = debtId;
    }

    @Bindable
    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
        notifyPropertyChanged(BR.creditor);
    }

    @Bindable
    public double getDebts() {
        return debts;
    }

    public void setDebts(double debts) {
        this.debts = debts;
        notifyPropertyChanged(BR.debts);
    }

    @Bindable
    public String getDateOfPayment() {
        return new SimpleDateFormat("dd-MM-yyyy",   Locale.getDefault()).format(dateOfPayment);
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
        notifyPropertyChanged(BR.dateOfPayment);
    }

    public String getDebtNote() {
        return debtNote;
    }

    public void setDebtNote(String debtNote) {
        this.debtNote = debtNote;
    }
}
