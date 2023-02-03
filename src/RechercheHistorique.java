

/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


    public class RechercheHistorique<emojiCount> {

        public RechercheHistorique() {
        }

        public static String rechercheMot(String mot) throws FileNotFoundException {
            boolean flag = false;
            int count = 0;
            //System.out.println("Contenu de la ligne");
            //Reading the contents of the file
            Scanner sc2 = new Scanner(new FileInputStream("E:\\msgstore.db.crypt.txt"));
            int i = 0;
            while(sc2.hasNextLine()) {
                String line = sc2.nextLine();
                i++;
                //System.out.println(line);
                if(line.indexOf(mot)!=-1) {
                    flag = true;
                    count = count+1;
                }
            }
            System.out.println("Nombre total de messages envoyés: "+i+" ");
            if(flag) {

                System.out.println("Nombre total de fois que l'utilsateur a envoyé " +mot+ " : "+count);
            }
            else {
                System.out.println("Nombre total de fois que l'utilsateur a envoyé " +mot+ " : 0");
                //System.out.println("Fil
                //ù does not contain the specified word");
            }
            return null;
        }



        public static void main(String args[]) throws FileNotFoundException {
            //Reading the word to be found from the user

            rechercheMot("lol");
            System.out.println("");
            rechercheMot("lmao");
            System.out.println("");
            rechercheMot("fuck");
            System.out.println("");
            rechercheMot("merde");
            System.out.println("");
            rechercheMot("putain");
            System.out.println("");
            rechercheMot("ass");
            System.out.println("");
            rechercheMot("amen");
            System.out.println("");
            rechercheMot("akpe");
            System.out.println("");
            rechercheMot("merci");
            System.out.println("");
            rechercheMot("nagode");
            System.out.println("");
            rechercheMot("imela");
            System.out.println("");
            rechercheMot("thanks");
            System.out.println("");
            rechercheMot("thank you");
            rechercheMot("alhamdulillah");
            System.out.println("");
            rechercheMot("shukran");
            System.out.println("");


            String word1 = "lol";
            String word2 = "lmao";
            String b1 = "fuck";
            String b2 = "merde";
            String b3 = "putain";
            String b4 = "ass";
            String word3 = "amen";
            String word4= "akpe";
            String word5= "merci";
            String word6= "nagode";
            String word7= "imela";
            String word8= "thanks";
            String word9= "thank you";
            String word10= "alhamdulillah";
            String word11= "shukran";


        }
    }*/




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RechercheHistorique {

    private static final String[] BAD_WORDS = {"fuck", "merde", "putain", "ass"};
    private static final String[] EMOJIS = {":)", "😂", "😍", "😭", "😡"};
    private static final String[] THANK_WORDS = {"amen", "akpe", "merci", "nagode", "imela", "thanks", "thank you", "alhamdulillah", "shukran"};

    public static void main(String[] args) throws IOException {

        // Demande du nom de l'utilisateur
        System.out.println("Entrez le nom de l'utilisateur:");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        // Initialisation des compteurs
        int totalMessages = 0;
        int lolCount = 0;
        int lmaoCount = 0;
        int emojiSentCount = 0;
        int badWordsCount = 0;
        int emojiReceivedCount = 0;
        int angryEmojiCount = 0;
        int thankCount = 0;

        // Lecture du fichier d'historique WhatsApp
        BufferedReader reader = new BufferedReader(new FileReader("E:\\msgstore.db.crypt.txt"));
        String line;
        while ((line = reader.readLine()) != null) {

            // Si la ligne contient le nom de l'utilisateur, cela signifie qu'elle contient un message envoyé par cet utilisateur
            if (line.contains(userName)) {
                totalMessages++;
                if (line.contains("lol")) {
                    lolCount++;
                }
                if (line.contains("lmao")) {
                    lmaoCount++;
                }
                for (String emoji : EMOJIS) {
                    if (line.contains(emoji)) {
                        emojiSentCount++;
                    }
                }
                for (String badWord : BAD_WORDS) {
                    if (line.contains(badWord)) {
                        badWordsCount++;
                    }
                }
                for (String thankWord : THANK_WORDS) {
                    if (line.contains(thankWord)) {
                        thankCount++;
                    }
                }
            } else {
                // Si la ligne ne contient pas le nom de l'utilisateur, cela signifie qu'elle contient un message reçu par l'utilisateur

                for (String emoji : EMOJIS) {
                    if (line.contains(emoji)) {
                        emojiReceivedCount++;
                    }
                }
                if (line.contains("😡")) {
                    angryEmojiCount++;
                }
            }
        }
        reader.close();

        // Affiche des résultats

        System.out.println("Nombre total de messages envoyes: " + totalMessages);
        System.out.println("Nombre total de fois que l'utilisateur a envoyé 'lol': " + lolCount);
        System.out.println("Nombre total de fois ou l'utilisateur a envoyé 'lmao': " + lmaoCount);
        System.out.println("Nombre total de fois ou l'utilisateur a envoyé des emojis: " + emojiSentCount);
        System.out.println("Nombre total de grossieretés envoyées par l'utilisateur: " + badWordsCount);
        System.out.println("Nombre total de fois que l'utilisateur a reçu des emojis: " + emojiReceivedCount);
        System.out.println("Nombre total de fois que l'utilisateur a reçu l'emoji 😡 en colere: " + angryEmojiCount);
        System.out.println("Nombre total de fois que l'utilisateur a envoyé et reçu les mots de remerciement: " + thankCount);
    }
}
