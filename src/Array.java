
 
 import java.util.Scanner;
 
 public class Array {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String inputLagi = "y";
         String mahasiswa[] = new String[10];
         String keterangan[] = new String[10];
         int nilai[] = new int[10];
         int sum = 0;
         int i = 0;
         do {
             System.out.print(" Masukan Nama Mahasiswa: ");
             mahasiswa[i] = sc.next();
             System.out.print(" Masukan Nilai Mahasiswa: ");
             nilai[i] = sc.nextInt();
             if (nilai[i] >= 75) {
                 keterangan[i] = "lulus";
             } else {
                 keterangan[i] = "Tidak Lulus";
             }
             sc.nextLine();
             System.out.print(" Tambah Mahasiswa Lagi? (y/n): ");
             inputLagi = sc.nextLine().toLowerCase();
             sum += nilai[i];
             i++;
         } while (i < mahasiswa.length && inputLagi.equals("y"));
             System.out.println("Daftar Mahasiswa");
             System.out.println("No\tNama\tNilai\tKeterangan");
             for (int j = 0; j < i; j++) {
                 if (mahasiswa[j] == null) {
                     break;
                 }
                 
                 System.out.println((j+1)+ "\t" + mahasiswa[j] + "\t" + nilai[j] + "\t" + keterangan[j]);
             }
 
             double rata_rata = sum/i;
 
             System.out.println("Nilai Rata Rata Mahasiswa adalah: " + rata_rata);
 
         sc.close();
     }
 }