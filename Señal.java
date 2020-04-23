import java.util.*;

public class Señal {
	
	ArrayList<Integer> señalOriginal = new ArrayList<>();
	ArrayList<Integer> señalModificada = new ArrayList<>();
	private static final int SILENCIO = 0; 
	private static final int AGUDO = 65536;
	private int tamagno = (int)(Math.random()*41)+10;
	private int inferior;
	private int superior;
	
	public Señal() {
		recibeDatos();
		llenaSeñalOriginal();
	}
	
	public void llenaSeñalOriginal() {
		
		for (int i = 0; i < tamagno; i++) {
			señalOriginal.add(i, (int)(Math.random()*AGUDO));
		}
		System.out.println("Señal orignal: "+señalOriginal);
		llenaSeñalModificada();
	}
	
	public void llenaSeñalModificada() {
		for (int i = 0; i < tamagno; i++) {
			señalModificada.add(i, señalOriginal.get(i));
		}
	}
	
	public void recibeDatos() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Ingrese valor de señal inferior: ");
		this.setInferior(sc.nextInt());
		System.out.println("Ingrese valor de señal superior: ");
		this.setSuperior(sc.nextInt());
		sc.close();
	}
	
	public void señalesInferiores(int referencia) {
		for (int i = 0; i < tamagno; i++) {
			if(señalModificada.get(i)<referencia) 
				señalModificada.set(i, SILENCIO);
		}
	}
	
	public void señalesSuperiores(int referencia) {
		for (int i = 0; i < tamagno; i++) {
			if(señalModificada.get(i)>referencia)
				señalModificada.set(i, SILENCIO);
		}
	}
	
	public void compactaSeñal() {
		this.señalesInferiores(inferior);
		this.señalesSuperiores(superior);
		ArrayList<Integer> señalFinal = new ArrayList<>();
		for (int i = 0; i < tamagno; i++) {
			señalFinal.add(i, señalOriginal.get(i));
		}
		int aux=0;
		for (int i = 0; i < tamagno-aux; i++) {
			if (señalFinal.get(i)>superior) {
				señalFinal.remove(i);
				aux++;
			}
				else if (señalFinal.get(i)<inferior) {
					señalFinal.remove(i);
					aux++;
			}
		}
		System.out.println("Señal final: "+señalFinal);
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
		Señal obj = new Señal();
		obj.compactaSeñal();
	}
}
