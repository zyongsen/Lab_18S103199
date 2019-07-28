package P3;

import java.util.Scanner;


//������

public class MyChessAndGoGame {

	/*��ӡ����*/
	public static void Printer(Game game ) {
		System.out.print("*  ");
		for(int i = 0;i < game.map.getSize();i++) {
			if(i < 10)
				System.out.print(i+ "  ");
			else {
				System.out.print(i+ " ");
			}
		}
		System.out.println("* ");
		for(int i = 0;i < game.map.getSize();i++) {
			if(i < 10)
				System.out.print(i+"  ");
			else
				System.out.print(i+" ");
			for(int j = 0;j < game.map.getSize();j++) {
				if(game.map.getOnePiece(i, j)==null) 
					System.out.print("   ");
				else
					System.out.print(game.map.getOnePiece(i, j).type+"  ");
			}
			System.out.println(i);
		}
		System.out.print("*  ");
		for(int i = 0;i < game.map.getSize();i++) {
			if(i < 10)
				System.out.print(i+ "  ");
			else {
				System.out.print(i+ " ");
			}
		}
		System.out.println("* ");
	}
	public static void main(String[] args) {
		Game nowGame = new Game();  //��ǰ���
		nowGame.main(); //��ʼ�����̺������Ϣ
		Scanner it = new Scanner(System.in); //������
		Player nowPlayer;//��ǰ���
		int cnt = 0;//��������2����Ϊ1�����1���в������������2���в���
		String rec; //������ʱ��¼������ַ���
		while (true) {
			//����ֻ�
			if (cnt % 2 == 0)
				nowPlayer = nowGame.player1;
			else
				nowPlayer = nowGame.player2;
			//������ʾ
			System.out.println("Input your choice(put or move or remove or eat or search or count):");
			rec = it.nextLine(); //��¼��������ѡ��

			if (rec.equals("end")) //end��ʾ��Ϸ����
				break;
			StringBuilder trace = new StringBuilder();  //��¼��һ�εĲ�����ϸ��Ϣ
			trace.append(rec + ":");
			//put
			if (rec.equals("put")) {  
				System.out.println("Input the piece type,the position x and the position y");
				String inputType = it.nextLine();
				int inputx = it.nextInt();
				int inputy = it.nextInt();
				it.nextLine();
				nowPlayer.addPiece(new Piece(inputType, inputx, inputy, nowPlayer.playerNum), inputx, inputy,nowGame.map);
				trace.append(inputType + " put to " + "(" + inputx + "," + inputy + ")");
			} 
			//move
			else if (rec.equals("move")) {
				System.out.println("Input the piece type,the original x,the original y ,the goal x,and the goal y");
				String inputType = it.nextLine();
				int inputx1 = it.nextInt();
				int inputy1 = it.nextInt();
				it.nextLine();
				int inputx2 = it.nextInt();
				int inputy2 = it.nextInt();
				it.nextLine();
				nowGame.move(nowGame, nowPlayer, new Piece(inputType, inputx1, inputy1, nowPlayer.playerNum),
						inputx1, inputy1, inputx2, inputy2);
				trace.append(
						inputType + "(" + inputx1 + "," + inputy1 + ")" + " to " + "(" + inputx2 + "," + inputy2 + ")");
			}
			//remove
			else if (rec.equals("remove")) {
				System.out.println("Input the piece type, x and y:");
				String inputType = it.nextLine();
				int inputx = it.nextInt();
				int inputy = it.nextInt();
				it.nextLine();
				nowGame.remove(nowGame, nowPlayer, inputx, inputy);
				trace.append(inputType + "(" + inputx + "," + inputy + ")");
			}
			//eat
			else if (rec.equals("eat")) {
				System.out.println("Input the piece type,the original x,the original y ,the goal x,and the goal y");
				String inputType = it.nextLine();
				int inputx1 = it.nextInt();
				int inputy1 = it.nextInt();
				it.nextLine();
				int inputx2 = it.nextInt();
				int inputy2 = it.nextInt();
				it.nextLine();
				nowGame.changePiece(nowGame, nowPlayer, new Piece(inputType, inputx1, inputy1, nowPlayer.playerNum),
						inputx1, inputy1, inputx2, inputy2);
				trace.append(inputType + "(" + inputx1 + "," + inputy1 + ")" + " eat " + "(" + inputx2 + "," + inputy2
						+ ")");
			}
			//search
			else if (rec.equals("search")) {
				System.out.println("Input  x and  y");
				int inputx = it.nextInt();
				int inputy = it.nextInt();
				it.nextLine();
				nowGame.search(new Position(inputx, inputy), nowGame);
				trace.append("(" + inputx + "," + inputy + ")");
			}
			//count
			else if (rec.equals("count")) {
				System.out.println(nowGame.player1.name + ":" + nowGame.player1.pieces.size());
				System.out.println(nowGame.player2.name + ":" + nowGame.player2.pieces.size());
				trace.append("the players piece number");
			} 
			//����
			else {
				trace.chars();
				trace.append("let it go");
			}
			nowPlayer.history.add(trace.toString()); //�����εĲ�����¼
			cnt++; //ת�����
			Printer(nowGame); //��ӡһ�β����������
		}
		it.close(); //�رն�����
		
		//��ӡ��λ��ҵĲ�����ʷ
		System.out.println(nowGame.player1.name+"'s history:");
		for(int i =0;i < nowGame.player1.history.size();i++)
			System.out.println(nowGame.player1.history.get(i));
		System.out.println(nowGame.player2.name+"'s history:");
		for(int i =0;i < nowGame.player2.history.size();i++)
			System.out.println(nowGame.player2.history.get(i));
	}

}
