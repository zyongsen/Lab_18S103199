package P3;

//���ֹ��ܵ�ʵ��

public class Action {

	// ͳ����ҿ��õ�������
	// ���룺name(�����)��game(���)
	// �����(int)��ҿ���������
	public int countPieces(String name, Game game) {
		if (game.player1.name.equals(name))
			return game.player1.pieces.size();
		else if (game.player2.name.equals(name)) 
			return game.player2.pieces.size();
		else
			return -1;
	}

	// ��ѯ������ĳһλ�õ��������
	// ���룺Position(���ӵ�λ��)��game(���)
	// ��ӡ��Ϣ:������λ��û�����ӣ������ӡ��It is empty!������������ӣ����ӡ��xx(�û���)��xx���͵�����
	public Piece search(Position at, Game game) {
		if (at.getx() < 0 || at.getx() >= game.map.getSize() || at.gety() < 0 || at.gety() >= game.map.getSize()) {
			System.out.println("Out of the map!");
			return null;
		}
		if (game.map.getOnePiece(at.getx(), at.gety()) == null) {
			System.out.println("It is empty!");
			return null;
		}
		else {
			if (game.map.getOnePiece(at.getx(), at.gety()).tag() == 1)
				System.out.println("It is conquered by " + game.player1.name + "'s "
						+ game.map.getOnePiece(at.getx(), at.gety()).type() + " piece!");
			else
				System.out.println("It is conquered by " + game.player2.name + "'s "
						+ game.map.getOnePiece(at.getx(), at.gety()).type() + " piece!");
			return game.map.getOnePiece(at.getx(), at.gety());
		}
	} 

	// ��ĳ�����ӷ������� 
	// ����:name(��ҵ�����),piece(������Ϣ),x(����λ�õĺ�����),y(����λ�õ�������),game(���)
	// ��������name����������е�����һ������,�򷵻�����Ӧ��������������ӵ���Ϣ;���name����������ҵ����֣�����false
	public boolean putPieceToBoard(String name, Piece piece, int x, int y, Game game) {
		if (game.player1.name.equals(name))
			return game.player1.addPiece(piece, x, y, game.map);
		else if (game.player2.name.equals(name))
			return game.player2.addPiece(piece, x, y, game.map);
		else
			return false;
	}

	// �ƶ�������λ��Ϊ(x1,y1)�����ӵ�(x2,y2)
	// ����:game(���),player(���),piece(����),x1(ԭ������),x2(�ֺ�����),y1(ԭ������),y2(��������)
	// ���:���(x1,y1)��(x2,y2)��ͬһλ�ã����false;���(x1,y1)��(x2,y2)����һ���㲻�������У����false;���(x1,y1)��û�����ӣ�����(x2,y2)�����ӣ�����false;
	// ���(x1,y1)�������Ӳ���piece������false.������map��ɾ��(x1,y1)�������ӣ�������Ӧ����ҵĶ��㴦�����ӵ�λ�ø���Ϊ(x2,y2)
	public boolean move(Game game, Player player, Piece piece, int x1, int y1, int x2, int y2) {
		if (x1 == x2 && y1 == y2)
			return false;
		if (x1 < 0 || x1 >= game.map.getSize() || y1 < 0 || y1 >= game.map.getSize()
				|| game.map.getOnePiece(x1, y1) == null || !game.map.getOnePiece(x1, y1).type().equals(piece.type)||game.map.getOnePiece(x1, y1).tag()!=(piece.tag())) {
			return false;
		}
		if (x2 < 0 || x2 >= game.map.getSize() || y2 < 0 || y2 >= game.map.getSize()
				|| game.map.getOnePiece(x2, y2) != null) {
			return false;
		}
		game.map.remove(x1, y1, piece);
		player.addPiece(piece, x2, y2, game.map);
		return true;
	}

	// ��ĳһ�����Ӵ��������Ƴ�
	// ����:game(���),player(���),x(�Ƴ����ӵĺ�����),y(�Ƴ����ӵ�������)
	// ���:���(x,y)��û�����ӻ������Ӳ���player�Ķ��ֵĶ���player�ģ�����false;�����ȡ(x,y)�������ӣ���������Ӵ����player�Ķ��ֵĿ��������б�ɾ��
	public boolean remove(Game game, Player player, int x, int y) {
		if (x < 0 || x > game.map.getSize() || y < 0 || y >= game.map.getSize() || game.map.getOnePiece(x, y) == null
				|| game.map.getOnePiece(x, y).tag == player.playerNum) {
			return false;
		}

		Piece piece = game.map.getOnePiece(x, y);
		if (game.player1.name.equals(player.name)) {
			game.player2.removePiece(piece, x, y, game.map);

		} else {
			game.player1.removePiece(piece, x, y, game.map);

		}

		return true;
	}

	// ����
	// ������ɾ���������Ӻ��ƶ�ȥ���ӵ����Ӻϳ�
	public boolean changePiece(Game game, Player player, Piece piece, int x1, int y1, int x2, int y2) {
		return remove(game, player, x2, y2) && move(game, player, piece, x1, y1, x2, y2);
	}
}
