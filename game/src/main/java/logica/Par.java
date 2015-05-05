package logica;

public class Par {

	private int i;
	private int j;

	public Par(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public void print() {
		System.out.println("[i=" + i + " ,j=" + j + "]");
	}
}
