import java.util.ArrayList;

public class Player {
	private String name;//玩家姓名
	private int chips;//玩家籌碼
	private int bet;//玩家下的賭注
	private ArrayList<Card> oneRoundCard;//這局的牌

	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
		
	}
	public String getName() {//name的getter
		return name;
	}
	
	public int makeBet() {//下注
		bet = 1;//基本下注
		chips = chips - bet;//手上的籌碼減去下注
		if(chips <= 0) {//如果沒籌碼,則不下注
			bet = 0;
		}
		return bet;
		
	}
	public void setOneRoundCard(ArrayList<Card> cards) {
		oneRoundCard = cards;//這局得到的牌
	}
	public boolean hitMe() {//是否要牌，是回傳true，不再要牌則回傳false
		int sum = 0;
		for(int i = 0;i < oneRoundCard.size();i++) {//將這局拿到的牌的大小加總
			Card myRoundC = (Card)oneRoundCard.get(i);
			sum = sum + myRoundC.getRank();
		}
		if(sum >= 17) {
			return false;
		}
		else {
			return true;
		}
		
	}
	public int getTotalValue() {//回傳此牌局所得的卡點數加總
		int total = 0;
		for(int k = 0;k < oneRoundCard.size();k++) {
			Card totalRoundC = (Card)oneRoundCard.get(k);
			total = total + totalRoundC.getRank();
		}
		return total;
		
	}
	public int getCurrentChips() {//回傳玩家現有籌碼
		return chips;
	}
	public void increaseChips (int diff) {//玩家籌碼變動
		chips = chips + diff;
	}
	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + "chips.");
	}
}
