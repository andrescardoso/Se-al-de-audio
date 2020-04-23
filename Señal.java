import java.util.*;

public class Se�al {
	
	ArrayList<Integer> se�alOriginal = new ArrayList<>();
	ArrayList<Integer> se�alModificada = new ArrayList<>();
	private static final int SILENCIO = 0; 
	private static final int AGUDO = 65536;
	private int tamagno = (int)(Math.random()*41)+10;
	private int inferior;
	private int superior;
	
	public Se�al() {
		recibeDatos();
		llenaSe�alOriginal();
	}
	
	public void llenaSe�alOriginal() {
		
		for (int i = 0; i < tamagno; i++) {
			se�alOriginal.add(i, (int)(Math.random()*AGUDO));
		}
		System.out.println("Se�al orignal: "+se�alOriginal);
		llenaSe�alModificada();
	}
	
	public void llenaSe�alModificada() {
		for (int i = 0; i < tamagno; i++) {
			se�alModificada.add(i, se�alOriginal.get(i));
		}
	}
	
	public void recibeDatos() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Ingrese valor de se�al inferior: ");
		this.setInferior(sc.nextInt());
		System.out.println("Ingrese valor de se�al superior: ");
		this.setSuperior(sc.nextInt());
		sc.close();
	}
	
	public void se�alesInferiores(int referencia) {
		for (int i = 0; i < tamagno; i++) {
			if(se�alModificada.get(i)<referencia) 
				se�alModificada.set(i, SILENCIO);
		}
	}
	
	public void se�alesSuperiores(int referencia) {
		for (int i = 0; i < tamagno; i++) {
			if(se�alModificada.get(i)>referencia)
				se�alModificada.set(i, SILENCIO);
		}
	}
	
	public void compactaSe�al() {
		this.se�alesInferiores(inferior);
		this.se�alesSuperiores(superior);
		ArrayList<Integer> se�alFinal = new ArrayList<>();
		for (int i = 0; i < tamagno; i++) {
			se�alFinal.add(i, se�alOriginal.get(i));
		}
		int aux=0;
		for (int i = 0; i < tamagno-aux; i++) {
			if (se�alFinal.get(i)>superior) {
				se�alFinal.remove(i);
				aux++;
			}
				else if (se�alFinal.get(i)<inferior) {
					se�alFinal.remove(i);
					aux++;
			}
		}
		System.out.println("Se�al final: "+se�alFinal);
	}
	
	// SETTERS & GETTERS
	public int getSuperior() {
		return superior;
	}
	public void setSuperior(int superior) {
		this.superior = superior;
	}
	public int getInferior() {
		return inferior;
	}
	public void setInferior(int inferior) {
		this.inferior = inferior;
	}
	public static int getSilencio() {
		return SILENCIO;
	}

	public static int getAgudo() {
		return AGUDO;
	}
	
	// MAIN
	public static void main(String[] args) {
		Se�al obj = new Se�al();
		obj.compactaSe�al();
	}
}
