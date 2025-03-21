package DSA.Structures2;

public class MultipLicationHash {

    public static void main (String[] args ) {
        int key = 1234; //Ключь
        int tableSize = 10; // Розмір хєш таблиці
        double A = 0.6180339887; // Кнутівська константа

        //Обчислюемо хэш
        int hasValue = multiplicatiomHash( key, tableSize, A);

        //Виводемо результат
        System.out.println("Хеш для ключа " + key + "=" + hasValue);
    }

    public static int multiplicatiomHash(int key, int tableSize, double A) {
        double fraction = key *  A % 1; //Беремо тылькти дробну частину
        System.out.println("Дробна частина: " + fraction);
        return (int) Math.floor(tableSize * fraction); //округлюемо вниз
    }
    
}
