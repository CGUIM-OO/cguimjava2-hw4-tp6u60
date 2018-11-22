import java.util.ArrayList;

public class Player {
	private String name;//���a�m�W
	private int chips;//���a�w�X
	private int bet;//���a�U����`
	private ArrayList<Card> oneRoundCard;//�o�����P

	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
		
	}
	public String getName() {//name��getter
		return name;
	}
	
	public int makeBet() {//�U�`
		bet = 1;//�򥻤U�`
		chips = chips - bet;//��W���w�X��h�U�`
		if(chips <= 0) {//�p�G�S�w�X,�h���U�`
			bet = 0;
		}
		return bet;
		
	}
	public void setOneRoundCard(ArrayList<Card> cards) {
		oneRoundCard = cards;//�o���o�쪺�P
	}
	public boolean hitMe() {//�O�_�n�P�A�O�^��true�A���A�n�P�h�^��false
		int sum = 0;
		for(int i = 0;i < oneRoundCard.size();i++) {//�N�o�����쪺�P���j�p�[�`
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
	public int getTotalValue() {//�^�Ǧ��P���ұo���d�I�ƥ[�`
		int total = 0;
		for(int k = 0;k < oneRoundCard.size();k++) {
			Card totalRoundC = (Card)oneRoundCard.get(k);
			total = total + totalRoundC.getRank();
		}
		return total;
		
	}
	public int getCurrentChips() {//�^�Ǫ��a�{���w�X
		return chips;
	}
	public void increaseChips (int diff) {//���a�w�X�ܰ�
		chips = chips + diff;
	}
	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + "chips.");
	}
}
