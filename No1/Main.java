package Collection.No1;

import java.util.*;

public class Main {
  static int totalSks = 0;
  static HashMap<String, Integer> krs = new HashMap<String, Integer>();

  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int command;
    while (true) {
      System.out.println("Menu:");
      System.out.println("1. Tambah Krs");
      System.out.println("2. Hapus Krs");
      System.out.println("3. Print Krs");
      System.out.print("Masukkan menu: ");
      command = sc.nextInt();
      sc.nextLine();
      if (command == 1) {
        System.out.print("Matkul: ");
        String matkul = sc.nextLine();
        System.out.print("Jumlah SKS: ");
        int sks = sc.nextInt();
        tambahKrs(matkul, sks);
        System.out.println();
        continue;
      } else if (command == 2) {
        System.out.print("matkul yang ingin dihapus: ");
        String matkul = sc.nextLine();
        hapusKrs(matkul);
        System.out.println();
        continue;
      } else if (command == 3) {
        printKrs();
        System.out.println("Selamat menjalankan perkuliahan");
        break;
      }
    }
  }

  static void tambahKrs(String matkul, int sks) {
    if (cekKrs()) {
      System.out.println("Krs anda telah penuh");
      return;
    }
    krs.put(matkul, sks);
    totalSks += sks;
    System.out.println("berhasil menambahkan " + matkul + " dengan total " + sks + " SKS");
  }

  static boolean cekKrs() {
    return totalSks >= 24;
  }

  static void hapusKrs(String matkul) {
    if (!cekMatkul(matkul)) {
      System.out.println("Matkul yang anda masukkan tidak ada");
      return;
    }

    System.out.println("berhasil menghapus " + matkul + " dengan total " + krs.get(matkul) + " SKS");
    krs.remove(matkul);
  }

  static boolean cekMatkul(String matkul) {
    return krs.containsKey(matkul);
  }

  static void printKrs() {
    System.out.println("=== Krs yang diambil ===");
    krs.forEach((matkul, sks) -> {
      // System.out.println(matkul + " " + sks + " SKS");
      System.out.printf("%-15s : %d sks\n", matkul, sks);
    });
  }
}
