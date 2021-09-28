import java.io.*;

public class csv
{
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final String CSV_DATA = "Nome auto,Marca,Prezzo,Anno\n"
    +"720S,McLaren,450000,2017\n"
    +"Zonda,Pagani,1250000,2007\n"
    +"812 Superfast,Ferrari,350000,2018\n"
    +"RSR,Porsche,425000,2016\n"
    +"GT500,Shelby,815000,1967\n"
    +"Delta S4,Lancia,450000,1980\n";
    private static final String CSV_PATH = "../CSVFile.csv";


    public static boolean InitReader()
    {
        try {
            br = new BufferedReader(new FileReader(CSV_PATH));
            return true;
        } catch (Exception e) {
            System.out.println("Eccezione durante inizializzazione: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean InitWriter()
    {
        try {
            bw = new BufferedWriter(new FileWriter(CSV_PATH));
            return true;
        } catch (Exception e) {
            System.out.println("Eccezione durante inizializzazione (scrittura): " + e.getMessage());
            return false;
        }
    }

    public static boolean Read()
    {
        if (InitReader() == false)
        {
            return false;
        }

        String line = "";


        try {
            while (((line = br.readLine()) != null))
            {
                String[] Data = line.split(",");
                for (int i = 0; i < Data.length; i++)
                {
                    System.out.print(Data[i] + " ");
                }

                System.out.print("\n");
            }
            
            br.close();
            return true;

        } catch (Exception e) {
            System.out.println("Eccezione durante lettura file: " + e.getMessage());
            return false;
        }


    }

    public static boolean Write()
    {
        if (InitWriter() == false)
        {
            return false;
        }

        try {
            bw.write(CSV_DATA);
            bw.close();

            return true;
        } catch (Exception e) {
            System.out.println("Eccezione durante scrittura file: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        if (!Write())
        {
            return;
        }

        if (!Read())
        {
            return;
        }

        System.out.println("Operazione completa");
    }
}