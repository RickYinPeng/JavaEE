package yp.itcast.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import yp.itcast.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao ad;
	private TransactionTemplate tt;
	
	public void setAd(AccountDao ad) {
		this.ad = ad;
	}
	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
	
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(final Integer from, final Integer to, final Double money) {
			
				//减钱
				ad.decreaseMoney(from, money);
				
				//int i = 1/0;
				//加钱
				ad.increaseMoney(to, money);

	}
	
/*	public void transfer(final Integer from, final Integer to, final Double money) {
		tt.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				//减钱
				ad.decreaseMoney(from, money);
				
				int i = 1/0; 
				
				//加钱
				ad.increaseMoney(to, money);
			}
		});
		//1.打开事务
		//2.调用doInTransactionWithoutResult方法，（并且会在这个方法上加try-catch，如果出现异常会回滚）
		//3.提交事务
	}*/

}
