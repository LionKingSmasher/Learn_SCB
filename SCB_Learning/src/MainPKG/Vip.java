package MainPKG;

public class Vip extends person {
	
	private final int MAX_RANK = 10;
	
	int rank;
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		if(rank >= MAX_RANK)
			this.rank = MAX_RANK;
		else if(rank >= 1) 
			this.rank = rank;
		else
			this.rank = 1;
	}
	
	public Vip(String RRN, String name, int money, int rank) {
		super(RRN, name, money);
		this.setRank(rank);
	}
	
	public Vip(person P, int rank) {
		this(P.getRRN(), P.getName(), P.getMoney(), rank);
	}
	
	@Override
	public String toString() {
		return this.getName() + "[" + this.getRank() + "]" + "-" + this.getMoney();
	}
}
