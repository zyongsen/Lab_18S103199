package P3;

public class Board {
	private final int n;
	Piece[][] map;  //����

	Board(int n) {
		this.n = n;
		this.map = new Piece[n][n];
	}

	public int getSize() {
		return n;
	}

	//�������ϵ�(x,y)λ�÷�������piece
	public boolean set(int x, int y, Piece piece) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		if (map[x][y] == null) {
			map[x][y] = piece;
			return true;
		}
		return false;
	}
	
	//��λ��(x,y)��piece���������Ƴ�
	public boolean remove(int x,int y,Piece piece) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		if(map[x][y]==null)
			return false;
		map[x][y] = null;
		return true;
	}
	
	//��ȡ(x,y)��������
	public Piece getOnePiece(int x,int y) {
		if (x < 0 ||x >= n ||y < 0 || y >= n)
			return null;
		return map[x][y];
	}

}
