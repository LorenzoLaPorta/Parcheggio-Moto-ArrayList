import java.util.Scanner;

public class Moto{
  // attributi della classe
  String modello;
  String targa;
  int giorno;
  //-------------------------------------

  // costruttore
  Moto(String modello, String targa) {
    this.modello = modello;
    this.targa = targa;
  }
 
  /**
   * funzione che fa l'override del metodo toString per restituire modello e targa della moto
   * 
   * @param void
   * @return stampa
   */
  @Override
  public String toString() {
    String stampa;
    stampa = "Moto : (Modello = " + this.modello + " | Targa = " + this.targa + ")";
    return stampa;
  }

  /**
   * funzione che gestisce l'inserimento di input
   * 
   * @param scanner
   * @param stringa
   * @return void
   */
  public static String inserisci(Scanner scanner, String stringa) {
    System.out.println(stringa);
    String input = scanner.nextLine();
    return input;
  }

  public static void inserisciModello(Scanner scanner, Moto moto, String stringa) {
    System.out.println(stringa);
    moto.modello = scanner.nextLine();
  }

  public static void inserisciTarga(Scanner scanner, Moto moto, String stringa) {
    System.out.println(stringa);
    moto.targa = scanner.nextLine();
  }

  public static void inserisciGiorno(Scanner scanner, Moto moto, String stringa) {
    System.out.println(stringa);
    moto.giorno = scanner.nextInt();
    scanner.nextLine();
  }
}