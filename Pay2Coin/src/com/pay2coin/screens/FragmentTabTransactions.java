package com.pay2coin.screens;

import java.util.ArrayList;

import Domain.Merchant;
import Domain.Transaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.pay2coin.R;
import com.pay2coin.business.TransactionsController;
import com.pay2coin.screens.adapters.TransactionAdapter;

public class FragmentTabTransactions extends FragmentTab{
	TransactionsController transactionsController;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        TextView tv = (TextView) v.findViewById(R.id.text);
        tv.setText("Available Transactions");
        final ArrayList<Transaction> transactionsList = transactionsController.getTransactions();
        ListView lv = (ListView)v.findViewById(R.id.list_view_main);
        TransactionAdapter transactionAdapter = new TransactionAdapter(getActivity(),R.layout.row,transactionsList);
        lv.setAdapter(transactionAdapter);
        
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	Transaction t = transactionsList.get(position);
                 Toast toast = Toast.makeText(getActivity(), t.getMerchant().getMerchant(), 2);
                 toast.show();
            }
        });
        Button b = (Button) v.findViewById(R.id.button1);
        b.setOnClickListener(this);
        return v;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
