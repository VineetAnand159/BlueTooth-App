package com.pay2coin.screens;

import java.util.ArrayList;
import java.util.List;

import Domain.Merchant;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pay2coin.R;
import com.pay2coin.business.MerchantsController;
import com.pay2coin.screens.adapters.MerchantAdapter;



public class FragmentTabPayNow extends FragmentTab{

	MerchantsController merchantsController = new MerchantsController();
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        final ArrayList<Merchant> merchantList = (ArrayList<Merchant>) merchantsController.getMerchants();
        TextView tv = (TextView)v.findViewById(R.id.text_view_main);
        tv.setText("Merchants");
        ListView lv = (ListView)v.findViewById(R.id.list_view_main);
        MerchantAdapter merchantAdapter = new MerchantAdapter(getActivity(),R.layout.row,merchantList);
        lv.setAdapter(merchantAdapter);
        
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	Merchant m = merchantList.get(position);
                 Toast toast = Toast.makeText(getActivity(), m.getMerchant(), 2);
                 toast.show();
                 Intent newActivity = new Intent(getActivity(),PaymentActivity.class); 
                 newActivity.putExtra("merchant", m.getMerchant());
                 startActivity(newActivity);
            }
        });
        return v;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
