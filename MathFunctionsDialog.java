
/**
 * diese Klasse ist eine Test-Klasse für die Klasse MathFunktions
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (01.12.2020)
 */


import java.util.*;

public class MathFunctionsDialog {
   
    private static final short TeilerSumme = 1;
    private static final short pruefZiffer = 2;
    private static final short ENDE = 0;
    private short auswahl = -1;
    private long ISBN = 0;
    private Scanner input = new Scanner(System.in);
    
    
    /**
     * diese ist einlesen Methode.
     * die Metode lässt der Benutzer wählen , zwichen TeilerSumme (1)
     *                                        oder ISBN prüfziffer (2)  
     *                                        oder ENDE (0)
     **/                      
     private short getAuswahl() {
        System.out.println("wählen sie eine funktion aus:\n" +
                " 1: TeilerSumme\n 2: ISBN prüfziffer\n 0: ENDE");
        return input.nextShort();
      }

    /**
     * diese ist einlesen Methode.
     * die Metode list und scannt TeilerSumme und pruefZiffer ein.
     **/
     private long getNummber(short teilerAndPruefziffer) {
        switch (teilerAndPruefziffer) {
            case TeilerSumme:
                System.out.println("geben sie eine zahl ein");
                return input.nextLong();
            case pruefZiffer:
                System.out.println("geben sie eine ISBN ein: muss 9 stellige zahl");
                return input.nextLong();
            default:
                return -1;
        }

      }
    
    /**
    * diese Funktion überprueft ob die TeilSumme zahl enthält.   
    **/
    private void TeilerSumme_funktion(){
             try {
                        long temp_teiler = getNummber(TeilerSumme);
                        long result_summe = MathFunctions.berechneTeilersumme(temp_teiler);
                        System.out.println(result_summe);
                        
                    } catch (InputMismatchException e) {
                        System.out.println("ungültige Eingabe");
                        input.nextLine();

                    } catch(IllegalArgumentException e){
                        System.out.println("Die Zahl muss natürlichen Zahl sein");
                        input.nextLine();
                        
                    } catch (Exception e) {    
                        System.out.println(e);
                        input.nextLine();
                        
                    }

    }
    
    /**
    * diese Funktion überprueft ob die pruefZiffer zahl enthält.
    * und ob pruefZiffer 9 stellig Zahl ist.
    **/
    private void pruefZiffer_funktion(){
            String result = null;
            try {
                        long temp_Ziffer = getNummber(pruefZiffer);
                        result = MathFunctions.berechneChecksummeIsbn(temp_Ziffer);
                        System.out.println(result);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.toString());
                        
                    }  catch (Exception e) {
                        System.out.println("ungültige Eingabe");
                        input.nextLine();
                        
                    }
    
    }
    
    
    /**
     * diese Funktion ruft die andern Methoden .
    * diese Funktion überprueft ob der Bentzer zahl eingibt.
    **/
    public void start() {
        while (auswahl != 0) {
            try {
                auswahl = getAuswahl();
            }catch (Exception e){
                System.out.println("geben Sie ein gültige Auswhal");
                input.nextLine();
                continue;
            }
            
            switch (auswahl) {
                case TeilerSumme:
                   TeilerSumme_funktion(); 
                    break;
                    
                case pruefZiffer:
                   pruefZiffer_funktion();
                    break;
                    
                case ENDE:
                    return;
                    
                default:
                    System.out.println("Geben Sie eine gültige zahl");
            }
        }
    }

     public static void main(String[] args) {
        MathFunctionsDialog x = new MathFunctionsDialog();
        x.start();
    }
}
