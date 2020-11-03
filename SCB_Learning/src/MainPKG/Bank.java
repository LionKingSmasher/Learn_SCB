package MainPKG;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bank {
	
	private final int MAX_ACCOUNT = 10;
	Date date;
	SimpleDateFormat format;
	
	private person[] accounts;
	private int size;
	private ArrayList<String> logs;
	
	public Bank() {
		accounts = new person[MAX_ACCOUNT];
		size = 0;
		logs = new ArrayList<>();
		
		date = new Date();
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		this.addLog("���� ����");

		System.out.println("[System]������ ������ �Ǿ����ϴ�!");
	}
	
	public boolean createAccount(person account) {
		if(size < 10) {
			this.accounts[size++] = account;
			this.addLog("���� �߰� ����-" + account.toString());
			
			return true;
		}
		else {
			if(account instanceof Vip) {
				for(int i = MAX_ACCOUNT-1; i>=0; i--) {
					if(!(this.accounts[i] instanceof Vip)) {
						this.addLog("���� ����- " + this.accounts[i].toString());
						this.accounts[i] = account;
						this.addLog("���� �߰� ���� - " + account.toString());
						
						return true;
					}
				}
				this.addLog("���� �߰� ����- " + account.toString());
				return false;
			}
			else {
				this.addLog("���� �߰� ����- " + account.toString());
				return false;
			}
		}
	}
	
	public void addLog(String log) {
		date = new Date();
		log = format.format(date) + " - " + log;
		this.logs.add(log);
	}
	
	public String getLog() {
		String output = "";
		
		for(String s : this.logs)
			output += s + "\n";
		return output;
	}
}
