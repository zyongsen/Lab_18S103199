package P3;

public class Piece {
	String type; //��������
	int x; //���Ӻ�����
	int y; //����������
	int tag; //���ӵı��

	Piece(String type, int x, int y, int tag) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.tag = tag;
	}
	
	public String type() {
		return type;
	}
	public int x() {
		return x;
	}
	public int y() {
		return y;
	}
	public int tag() {
		return tag;
	}

	//����typeֵ
	public void setType(String type) {
		this.type = type;
	}

	//��������λ����Ϣ
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//�ж������Ƿ�Ϊͬһ������
	public boolean equals(Piece piece) {
		return this.type.equals(piece.type) && y == piece.y && x == piece.x && tag == piece.tag;
	}
}
