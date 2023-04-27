
package klompok4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Klompok4 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Hijab> hijab = new ArrayList<>();
    static ArrayList<String> pembelii = new ArrayList<>();
  

    public static void froze() throws IOException {
        System.out.print("Tekan enter untuk melanjutkan... ");
        input.readLine();
        System.out.println("");
    }
    
    static final String FILENAME = "users.txt";
    
    
    static final void keluar(){
        System.out.println("\n=======================================");            
        System.out.println("|     TERIMA KASIH DATANG KEMBALI     |");
        System.out.println("======================================="); 
    } 
    
     public static void tambahProduk() throws IOException {

            System.out.println("-Masukan Data Jilbab-");            
            System.out.print("Masukkan Jenis Jilbab                   : ");
            String jenis = input.readLine();
        
            System.out.print("Masukkan warna                          : ");
            String warna = input.readLine();
        
            System.out.print("Masukkan Harga Jilbab                   : ");
            int harga = Integer.parseInt(input.readLine());
            
            System.out.print("Masukkan Bahan Jilbab                   : ");
            String bahan = input.readLine();
            
            System.out.print("Masukan  Jumlah Stok Hijab              : ");
            int stok = Integer.parseInt(input.readLine());
                  
            Hijab hjb = new Hijab(jenis, warna, harga, bahan, stok);
            hijab.add(hjb);
            hjb.toko(jenis, harga);
            hjb.tambah();
            
            
    }
     
    public static void tampilProduk() throws IOException{

            System.out.println("-Data Jilbab-");  
            if (hijab.isEmpty()){
                System.out.println("\n================================");
                System.out.println("Belum ada data yang tersimpan!");
                System.out.println("================================\n");
            }else{
                for(int i = 0; i < hijab.size();i++){
                System.out.println("=================================================");
                System.out.println("\t\tProduk Ke-" + (i+1));
                System.out.println("=================================================");
                hijab.get(i).DataToko();
                
                    }
                }
                System.out.println("\n=================================================");
                Hijab.ketentuan();

    }     

    static void ubahProduk()throws IOException {
        
            if (hijab.isEmpty()) {
                System.out.println("\n================================");
                System.out.println("Belum ada produk yang tersimpan!");
                System.out.println("================================\n");
            } else {
                
                 for(int i = 0; i < hijab.size();i++){
                    int nomor = i+1;
                    System.out.println("=================================================");
                    System.out.println("Hijab dengan nomor " + nomor);
                    System.out.println("=================================================");
                    hijab.get(i).DataToko();
                    }
                 System.out.println("=================================================");
                 
                System.out.print("\nMasukkan nomor jilbab yang ingin diubah: ");
                int index = Integer.parseInt(input.readLine());
                
                if (index <= hijab.size() || index > 0) {
                    
                    System.out.println("\n-Masukkan data jilbab yang baru-");
                    
                    System.out.print("Masukkan Harga Produk              : ");
                    int harga = Integer.parseInt (input.readLine());
                    hijab.get(index-1).setharga(harga);
                    
                    System.out.print("Masukkan Stok Jilbab               : ");
                    int stok = Integer.parseInt (input.readLine());
                    hijab.get(index-1).setStok(stok);                    
                    
                    
                    hijab.get(index-1).bell(harga,stok);
                    
                    hijab.get(index-1).edit();
                }else{
                    System.out.println("indeks tidak ditemukan");
                }
            }
    }
    
    static void hapusProduk() throws IOException{

            if (hijab.isEmpty()) {
                System.out.println("\n================================");
                System.out.println("Belum ada produk yang tersimpan!");
                System.out.println("================================\n");
            } else {
                
                for(int i = 0; i < hijab.size();i++){
                    int nomor = i + 1;
                    System.out.println("=================================================");
                    System.out.println("\tHijab dengan nomor " + nomor);
                    System.out.println("=================================================");
                    hijab.get(i).DataToko();
                }
                System.out.println("=================================================");
                
                System.out.print("Masukkan nomor jilbab yang ingin dihapus: ");
                int index = Integer.parseInt(input.readLine());
                if(index <= hijab.size() || index > 0) 
                {
                    hijab.remove(index-1).hapus();
                }
                else
                {
                    System.out.println("Indeks tidak ditemukan!");
                }
            }
        
    }
    
    public static void pesanbarang() throws IOException{
        System.out.println("\nSilahkan Pesan Hijab Yang Anda Inginkan ><");
        System.out.println("\nPillih Nomer yang Ingin Dibeli");
         
        for(int i = 0; i < hijab.size();i++){
                System.out.println("=================================================");
                System.out.println("\tProduk Ke-" + (i+1));
                System.out.println("=================================================");
                hijab.get(i).DataToko();
              }
              System.out.println("=================================================");
        
                
        
            if(hijab.isEmpty()){
                System.out.println("\n=============================================");
                System.out.println("         Belum ada data yang tersimpan!      ");
                System.out.println("=============================================");
            }else{
                System.out.print("Masukan Nomer Yang Ingin dibeli : ");
                int beli = Integer.parseInt(input.readLine());
                
                if(beli > hijab.size()) {
                     System.out.println("\n=======================");
                    System.out.println("Nomor data tidak tersedia");
                     System.out.println("=======================\n");
                }
                else{      
                    System.out.print("Masukan total Yang ingin dibeli : ");
                    int jumlahbeli = Integer.parseInt(input.readLine());
                    if (beli > 0 && beli <= hijab.size()) {
       
                        int stok = hijab.get(beli-1).getStok();

                        if ( jumlahbeli <= stok){
                             stok = stok - jumlahbeli;
                             hijab.get(beli-1).setStok(stok);

                             System.out.println("\n=======================");
                             System.out.println("Pesanan telah di proses");
                             System.out.println("=======================\n");
                            }else{
                               System.out.println("\n====================================");
                               System.out.println("Mohonmaaf Stok kami Titak mencukupi ");
                               System.out.println("====================================\n");
                               return;

                            }
                        System.out.println("\nAnda Akan membeli Barang Dengan keterangan sebagai berikut : ");
                        System.out.println("================================================================");
                        hijab.get(beli-1).DataToko();
                        
                        int harga = hijab.get(beli-1).getharga();
                        double total = harga *jumlahbeli;
                        System.out.println("\nUang yang harus Anda dibayar Rp."+ total);

                         System.out.print("\nMasukan Nominal uang Anda : ");
                              int uang = Integer.parseInt(input.readLine());
                              if (uang >= total){
                                  double kembalian = uang - total;
                                  System.out.println("\nKembalian yang anda terima Rp."+ kembalian);
                                  pembelii.add("Jenis Produk      : " + hijab.get(beli-1).getjenis() + "\n" + 
                                              "Warna             : " + hijab.get(beli-1).getwarna() + "\n" + 
                                              "Harga Produk      : " + hijab.get(beli-1).getharga()+ "\n"+ 
                                              "Stok Produk       : " + hijab.get(beli-1).getStok()+ "\n"+ 
                                              "Bahan Produk      : " + hijab.get(beli-1).getBahan()+ "\n"+ 
                                              "Tahun             : " + hijab.get(beli-1).Tahun()+ "\n"+ 
                                              "Merek             : " + hijab.get(beli-1).Nama()+ "\n"+ 
                                              "Jumlah Barang     : " + jumlahbeli + "\n"+ 
                                              "Total             : Rp. " + total + "\n"+ 
                                              "Uang              : Rp. " + uang + "\n"+ 
                                              "Kembalian         : Rp. " + kembalian );
                                  Hijab.bel(beli,jumlahbeli);
                                  Hijab.ketentuan();
                              }else {
                                   System.out.println("\n=======================");
                                  System.out.println("Uang anda tidak mencukupi");
                                   System.out.println("=======================\n");
                                  
                              }
        
        
        
                        }
                    } 
                }
        
     }
    
    
    
   public static void lihatpesan() {
            System.out.println("=============================================");
            System.out.println("|              Riwayat Transaksi            |");
            System.out.println("=============================================");
            
                if(pembelii.isEmpty()){
                    System.out.println("\n=============================================");
                    System.out.println("               Belum ada pembeli!            ");
                    System.out.println("=============================================");
                    }else{
                        for (String transaksi : pembelii) {
                        System.out.println(transaksi);
                        System.out.println("---------------------------------------------\n");
                        } 
                    }
            }
    
    

    
    public static void admin()throws IOException{
        System.out.println("=============================================");
        System.out.println("|                Login as Admin             |");
        System.out.println("=============================================");
        System.out.print("| Masukkan username : ");
        String username = input.readLine();
        System.out.print("| Masukkan password : ");
        String password = input.readLine();
        System.out.println("=============================================\n");
        if ((username.equals("Admin") && password.equals("123"))){   
        int admin = 0;    
        while(admin != 5){
            System.out.println("""
                        \n\n\t\t|----------------------------|
                        \t\t|        Selamat Datang      |
                        \t\t|----------------------------|
                        \t\t|1.| Lihat List Hijab        |
                        \t\t|2.| Tambah List Hijab       |
                        \t\t|3.| Edit List Hijab         |
                        \t\t|4.| Hapus List Hijab        |
                        \t\t|5.| Lihat Data Transaksi    |
                        \t\t|6.| Log out                 |
                        \t\t|----------------------------|
                        """);
            System.out.print("Pilih Menu: ");
                          
            int choice = Integer.parseInt(input.readLine());
                switch (choice) {
                    case 1:
                       tampilProduk();
                       froze();
                        break;

                    case 2:
                       tambahProduk();
                       froze();
                        break;
                    case 3:
                      ubahProduk();
                      froze();
                        break;
                    case 4:
                       hapusProduk();
                       froze();
                        break;
                    case 5:
                        lihatpesan();
                        froze();
                        break;
                    case 6:
                        System.out.println("Anda telah log out");
                        return;

                    default:
                        System.out.println("Pilihan tidak ada!");
                        froze();
                        break;
                                    }
                                }
                            }
        else {
            System.out.println("Password atau Username anda salah");
            }
            
        }
    
    public static void pembeli() throws IOException{
                    int pelanggan = 0;
                    while (pelanggan != 3){
                        System.out.println("""
                                           \n\n\t\t|----------------------------|
                                           \t\t|        Selamat Datang      |
                                           \t\t|----------------------------|
                                           \t\t|1.| Lihat Menu              |
                                           \t\t|2.| Belanja                 |
                                           \t\t|3.| Lihat Hasil Belanja     |
                                           \t\t|4.| LOg out                 |
                                           \t\t|----------------------------|
                                           """);
                        System.out.print("Silahkan Pilih Menu : ");
                        int pilih = Integer.parseInt(input.readLine());
                        switch(pilih){
                            case 1:
                                tampilProduk();
                                froze();
                                break;
                            case 2:
                                pesanbarang();
                                froze();
                                break;
                            case 3:
                                lihatpesan();
                                froze();
                                break;
                            case 4:
                                 System.out.println("Anda telah log out");
                                  return;
                             default:
                                System.out.println("Pilihan tidak ada!");
                                froze();    
                        }
                        
                    }
    }

    
    
    
    public static void main(String[] args)  throws IOException {
        boolean menu = true;
        while(menu == true){
            System.out.println("""
                               \n\n\t\t|============================|
                                \t\t|       Login Sebagai        |
                                \t\t|============================|
                                \t\t|1.| Admin                   |
                                \t\t|2.| Pelanggan               |
                                \t\t|3.| Registrasi Pelanggan    |
                                \t\t|4.| Exit program            |
                                \t\t|============================|
                               """);
            System.out.print("pilih :");
            try{
            int pill = Integer.parseInt(input.readLine());
            switch (pill){
                case 1 : 
                    admin();
                    froze();  
                    break;
                case 2 :
                    login();
                    froze();
                    break;
                case 3: 
                    register();
                    froze();
                    break;
                case 4:
                    keluar();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak ada!");
            }
        }catch(NumberFormatException  e){
                System.out.println("Input yang Anda masukkan salah! Silahkan coba lagi.");
                }
        }

    }



    public static void login() {
        Scanner input = new Scanner(System.in);
        String username, password;
        
        System.out.println("\n\n=============================================");
        System.out.println("|                Login as Users             |");
        System.out.println("=============================================");
        System.out.print("| Masukkan username : ");
        username = input.nextLine();
        System.out.print("| Masukkan password : ");
        password = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] user = line.split(";");

                if (user[0].equals(username) && user[1].equals(password)) {
                    System.out.println("\nBerhasil Login");
                    System.out.println("Selamat datang, " + username + "!");
                    pembeli();
                    return;
                }
            }

            System.out.println("Username atau password salah.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file.");
            e.printStackTrace();
        }
    }

    public static void register() {
        Scanner input = new Scanner(System.in);
        String username, password;
        System.out.println("\n\n=============================================");
        System.out.println("|                 Registrasi                |");
        System.out.println("=============================================");
        System.out.print("| Masukkan username : ");
        username = input.nextLine();
        System.out.print("| Masukkan password : ");
        password = input.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            bw.write(username + ";" + password);
            bw.newLine();
            System.out.println("Registrasi berhasil!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke file.");
            e.printStackTrace();
        }
    }


//end
}
