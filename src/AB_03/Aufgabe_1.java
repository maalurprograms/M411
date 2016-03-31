package AB_03;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by vmadmin on 25.02.2016.
 */
public class Aufgabe_1 {
    public static String encrypt(String text, int key) {
// wir werden die Zeichen einzeln codieren
        char[] zeichen = text.toCharArray();
// bitweise XOR-Verschlüsselung
        for (int i=0; i<zeichen.length; i++)
// Mit (char)int wandle int in einen char um
            zeichen[i] = (char)(zeichen[i]^key);
// wir erzeugen aus dem Array vom Typ char einen String
        return new String(zeichen);
    }
    public static void main(String[] args) throws IOException {
        Writer.writeFile("C:/Users/vmadmin/IdeaProjects/GIBB/411/src/AB_03/Aufgabe_1_Gedichte_Verschlüsselt", encrypt(Reader.readFile("C:/Users/vmadmin/IdeaProjects/GIBB/411/src/AB_03/Aufgabe_1_Gedichte"), 23), false);
    }
}