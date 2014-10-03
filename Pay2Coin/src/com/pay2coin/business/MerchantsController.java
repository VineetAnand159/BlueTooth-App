package com.pay2coin.business;

import java.util.ArrayList;
import java.util.List;

import Domain.Merchant;

public class MerchantsController {

	public List<Merchant> getMerchants () {
		 List<Merchant> merchantsList = new ArrayList<Merchant>();
		 Merchant merchant1 =new Merchant();
		 merchant1.setUuid("ax123by");
		 merchant1.setMerchant("Dominos Andheri");
		 
		 Merchant merchant2 = new Merchant();
		 
		 merchant2.setUuid("AX234BY");
		 merchant2.setMerchant("Faasos Andheri East");
		 
		 merchantsList.add(merchant1);
		 merchantsList.add(merchant2);
		 return merchantsList;
	}
}
