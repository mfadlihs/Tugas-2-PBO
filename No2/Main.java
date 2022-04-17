// package Collection.No2;

import java.util.*;

public class Main {
  static Stack<String> rakBuku = new Stack<String>();

  public static void main(String[] args) {
    var sc = new Scanner(System.in);

    int command;
    while (true) {
      System.out.println("Menu:");
      System.out.println("1. Tambah buku");
      System.out.println("2. Ambil buku paling atas");
      System.out.println("3. Cari buku");
      System.out.println("4. Tampilkan buku");
      System.out.println("5. Keluar program");
      System.out.print("Masukkan menu: ");
      command = sc.nextInt();
      System.out.println();
      sc.nextLine();
      if (command == 1) {
        System.out.print("Masukkan judul buku: ");
        tambahBuku(sc.nextLine());
        System.out.println();
      } else if (command == 2) {
        ambilBuku();
        System.out.println();
      } else if (command == 3) {
        System.out.print("Masukkan judul buku: ");
        cariBuku(sc.nextLine());
        System.out.println();
      } else if (command == 4) {
        tampilkanBuku();
        System.out.println();
      } else if (command == 5) {
        System.out.println("Program selesai");
        break;
      }
    }
  }

  static void tambahBuku(String buku) {
    rakBuku.push(buku);
    System.out.println("Berhasil menambahkan buku berjudul " + buku);
  }

  static void ambilBuku() {
    if (isEmpty()) {
      System.out.println("Rak buku kosong");
    } else {
      System.out.println("Berhasil mengambil buku berjudul " + rakBuku.pop());
    }
  }

  static boolean isEmpty() {
    return rakBuku.empty();
  }

  static void cekAtas() {
    if (isEmpty()) {
      System.out.println("Rak buku kosong");
    } else {
      System.out.println("Buku teratas berjudul " + rakBuku.peek());
    }
  }

  static void banyakBuku() {
    System.out.println("Total ada " + rakBuku.size() + " buku dalam tumpukan");
  }

  static void cariBuku(String buku) {
    if (rakBuku.search(buku) == -1) {
      System.out.println("Buku berjudul " + buku + " tidak ada di tumpukan");
    } else {
      System.out.println("Buku berjudul " + buku + " ada di tumpukan ke-" + rakBuku.search(buku) + " dari paling atas");
    }
  }

  static void tampilkanBuku() {
    if (isEmpty()) {
      System.out.println("Rak buku kosong");
    } else {
      System.out.println("Tumpukan buku: ");
      rakBuku.forEach(buku -> {
        System.out.println(buku);
      });
    }
  }
}
