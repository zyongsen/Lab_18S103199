package P3;

import java.util.Scanner;

public class Game extends Action{
	Board map;  //����
	Player player1; //���1
	Player player2; //���2 
	
	
	//���û������ʼ�����
	public void  main() {
		System.out.println("Chess or Go?");
		Scanner itScanner = new Scanner(System.in);
		String gameType = itScanner.nextLine();
		
		//��������û���
		System.out.println("Please input the name of player1:");
		String playerName1 = itScanner.nextLine();
		System.out.println("Please input the name of player2:");
		String playerName2 = itScanner.nextLine();
		
		//�����û�ѡ����������
		StringBuffer relType = new StringBuffer();
		String[] typeTemp = gameType.split("\\s+");
		for (int i = 0; i < typeTemp.length; i++)
			if (!typeTemp[i].contains(" "))
				relType.append(typeTemp[i]);
		
		//���ղ�ͬ�����ʹ������
		if (relType.toString().toLowerCase().equals("chess")) {
			map = new Board(8);
			System.out.println(map);
			player1 = new Player(playerName1,1,0,map);
			player2 = new Player(playerName2,2,0,map);
		} else if (relType.toString().toLowerCase().equals("go")) {
			map = new Board(17);
			player1 = new Player(playerName1,1,1,map);
			player2 = new Player(playerName2,2,1,map);
		} else {
			System.out.println("Input game type type error!");
			itScanner.close();
			return;
		}
		itScanner.close();
	}
	
}
