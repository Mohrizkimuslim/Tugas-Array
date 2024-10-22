import java.util.ArrayList;
import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        String[][] Buah = {
            {"apel", "35000"}, 
            {"jeruk", "50000"}, 
            {"mangga", "25000"}, 
            {"duku", "15000"}, 
            {"semangka", "20000"}
        };

        ArrayList<String[]> daftarBelanja = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean input = true;

        while (input) {
            System.out.println("Menu:");
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (pilihan) {
                case 1:
                    // Menampilkan daftar buah
                    System.out.println("Daftar Buah:");
                    for (int i = 0; i < Buah.length; i++) {
                        System.out.println(i + ". " + Buah[i][0] + " - " + Buah[i][1]);
                    }
                    
                    // Meminta pengguna untuk memilih buah
                    System.out.print("Pilih Buah (0-4): ");
                    int indexBuah = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    // Validasi indeks buah
                    if (indexBuah < 0 || indexBuah >= Buah.length) {
                        System.out.println("Indeks tidak valid. Silakan pilih indeks antara 0 dan " + (Buah.length - 1));
                        break;
                    }

                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    // Menambahkan item ke daftar belanja
                    daftarBelanja.add(new String[]{Buah[indexBuah][0], String.valueOf(jumlah), Buah[indexBuah][1]});
                    System.out.print("Input lagi? (y/n): ");
                    char lagi = scanner.next().charAt(0);
                    scanner.nextLine(); // Consume the newline
                    if (lagi != 'y') input = false;
                    break;

                case 2:
                    // Struk Belanja
                    if (daftarBelanja.isEmpty()) {
                        System.out.println("Daftar belanja kosong. Silakan beli buah terlebih dahulu.");
                    } else {
                        System.out.println("Daftar Belanja:");
                        System.out.println("========================================");
                        System.out.println("No. Nama Buah Jumlah Harga Subtotal");
                        int total = 0;
                        for (int i = 0; i < daftarBelanja.size(); i++) {
                            String[] item = daftarBelanja.get(i);
                            int harga = Integer.parseInt(item[2]); // Harga per item
                            int jumlahItem = Integer.parseInt(item[1]); // Jumlah item
                            int subtotal = harga * jumlahItem; // Hitung subtotal
                            total += subtotal;
                            System.out.printf("%d %s %s %s %d\n", i + 1, item[0], item[1], item[2], subtotal);
                        }
                        System.out.println("========================================");
                        System.out.println("Total: " + total);

                        double discount = total * 0.15;
                        System.out.printf("Discount(15%%): %.0f\n", discount);
                        System.out.printf("Total bayar: %.0f\n", total - discount);
                    }
                    break;

                case 3:
                    // Keluar
                    System.out.println("Terima kasih!");
                    input = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
        scanner.close();
    }
}
