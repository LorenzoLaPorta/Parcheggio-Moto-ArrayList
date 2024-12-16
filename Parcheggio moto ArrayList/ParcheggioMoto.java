import java.util.ArrayList;
import java.util.Scanner;

public class ParcheggioMoto{

    final static int POSTI_PIANO_1 = 2; //variabile statica che indica i posti disponibili al piano 1
    final static int POSTI_PIANO_2 = 3; //variabile statica che indica i posti disponibili al piano 2
    final static int POSTI_PIANO_3 = 4; //variabile statica che indica i posti disponibili al piano 3

    final static int P_PARCHEGGIO_GIORNALIERO = 10; //variabile statica che indica il prezzo al giorno di un parcheggio

    static ArrayList<Moto> piano1 = new ArrayList<>(); //arraylist del primo piano
    static ArrayList<Moto> piano2 = new ArrayList<>(); //arraylist del secondo piano
    static ArrayList<Moto> piano3 = new ArrayList<>(); //arraylist del terzo 
    
    static Scanner scanner = new Scanner(System.in); //scanner in grado di prendere valori in input

    /**
     * funzione che sceglie automaticamente il piano in cui inserire la moto
     * 
     * @param void
     * @return String
     */
    public static String scegliPiano(Moto moto){
        if ((piano1.size() - 1) < POSTI_PIANO_1){
            inserisciMoto(piano1, moto);
            return "";
        }
        if((piano2.size() - 1) < POSTI_PIANO_2){
            inserisciMoto(piano2, moto);
            return "";
        }
        if((piano3.size() - 1) < POSTI_PIANO_3){
            inserisciMoto(piano3, moto);
            return "";
        }
        else{
            return "L'intero parcheggio e' pieno. Non puoi entrare.";
        }
    }
    
    /**
     * funzione che inserisce la moto in uno dei tre piani
     * 
     * @param Arraylist
     * @param Moto
     * @return void
     */
    public static void inserisciMoto(ArrayList<Moto> piano, Moto moto){
        Moto.inserisciModello(scanner, moto, "inserisci il modello della moto");
        Moto.inserisciTarga(scanner, moto, "inserisci la targa della moto");
        Moto.inserisciGiorno(scanner, moto, "inserisci il giorno attuale");
        piano.add(moto);
    }

    /**
     * funzione che prova ogni lista per trovare l'indice della stringa inserita
     * 
     * @param String
     * @return String
     */
    public static String provaLista(String targa){
        int indice1 = cercaERimuovi(targa, piano1);
        int indice2 = cercaERimuovi(targa, piano2);
        int indice3 = cercaERimuovi(targa, piano3);
        if (indice1 != -1){
            int piano = 1;
            stampaPrezzoParcheggio(indice1, piano);
            return "";
        }
        else if (indice2 != -1){
            int piano = 2;
            stampaPrezzoParcheggio(indice2, piano);
            return "";
        }
        else if (indice3 != -1){
            int piano = 3;
            stampaPrezzoParcheggio(indice3, piano);
            return "";
        }
        else{
            return "La targa inserita non e' stata trovata";
        }
    }

    
    /**
     * funzione che cerca e rimuove una moto tramite la targa
     * 
     * @param String
     * @return boolean
     */
    public static int cercaERimuovi(String targa, ArrayList<Moto> piano){
        for (int i = 0; i < piano.size(); i++){
            if (piano.get(i).targa.equals(targa) && piano.get(i).targa != null){
                return i;
            }
        }
        return -1;
    }

    /**
     * funzione che calcola quanto pagare in base ai giorni di parcheggio e lo stampa
     * 
     * @param void
     * @return void
     */
    public static void stampaPrezzoParcheggio(int indiceMoto, int piano){
        int giornoEntrata = 0;
        if (piano == 1){
            giornoEntrata = piano1.get(indiceMoto).giorno;
        }
        if (piano == 2){
            giornoEntrata = piano2.get(indiceMoto).giorno;
        }
        if (piano == 3){
            giornoEntrata = piano3.get(indiceMoto).giorno;
        }
        System.out.println("Inserisci il giorno attuale");
        int giornoAttuale = scanner.nextInt();
        scanner.nextLine();
        int prezzo = (giornoAttuale - giornoEntrata) * P_PARCHEGGIO_GIORNALIERO;
        System.out.println("il prezzo da pagare e' " + prezzo + " euro");
    }

    public static void stampaMenu(){
        System.out.println("INSERISCI UN NUMERO:");
        System.out.println("0) chiudi il programma");
        System.out.println("1) entra nel parcheggio");
        System.out.println("2) esci dal parcheggio");
    }

    public static void main(String[] args) {
        String targa;
        String funzione;
        do {
            stampaMenu();
            funzione = scanner.nextLine();
            switch (funzione){
                case "1":
                    Moto moto = new Moto(null, null); // oggetto moto, che conterra' tutte le nuove moto inserite
                    System.out.println(scegliPiano(moto));
                    System.out.println(piano1);
                break;
                case "2":
                    System.out.println("Inserisci la targa della tua moto");
                    targa = scanner.nextLine();
                    System.out.println(provaLista(targa));
                break;
                case "0":
                break;
                default:
                    System.out.println("Hai sbagliato l'inserimento! Riprova");
                break;
            }
            
        } while (!(funzione.equals("0")));
    }
}