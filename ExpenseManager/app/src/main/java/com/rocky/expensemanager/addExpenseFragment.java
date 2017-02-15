package com.rocky.expensemanager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class addExpenseFragment extends DialogFragment {


    public addExpenseFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_add_expense,container,false);
        final EditText expense=(EditText)v.findViewById(R.id.expense_value);
        Button b=(Button)v.findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n=Integer.parseInt(expense.getText().toString());
                MainActivity calling=(MainActivity)getActivity();
                calling.value(n);
                getDialog().dismiss();
            }
        });
        return v;
    }
}
