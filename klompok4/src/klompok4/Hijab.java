package klompok4;

public final class Hijab extends ProdukToko implements Merk{
    private String bahan;
    private int stok;
    
     public final String namaProduk = "Hijab";
    
        public Hijab(String jenis, String warna, int harga , String bahan,int stok) {
        super(jenis, warna, harga);
        this.bahan = bahan;
        this.stok = stok;
    }


    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }
    
    @Override
    public void tambah(){
        System.out.println("\n------------------------------------------------");
        System.out.println("|  Produk " + this.namaProduk + " Berhasil Ditambahkan    |");
        System.out.println("------------------------------------------------");         
    }
    
    @Override
    public void edit(){
        System.out.println("\n-------------------------------------------------");
        System.out.println("|     Produk " + this.namaProduk + " Berhasil Diubah      |");
        System.out.println("-------------------------------------------------");    
    }
    
    @Override
    public void hapus(){
        System.out.println("\n-------------------------------------------------");
        System.out.println("|     Produk " + this.namaProduk + " Berhasil Dihapus     |");
        System.out.println("-------------------------------------------------");    
    }
    
    
//Overloading
    public void bell(int stok,int harga){
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("  | Data Harga produk telah diubah Menjadi "+ getharga());
        System.out.println("  | Data Stok produk telah diubah Menjadi "+ getStok() );
        System.out.println("-----------------------------------------------------------");
    }
    
    //Overloading
    public static void bel(int beli,int jumlahbeli ){
        System.out.println("Anda membeli Menu"+ beli +"Berhasil Ditambahkan");
        System.out.println("Jumlah yang Anda beli Adalah"+ jumlahbeli);
        
    }    
    
    
    @Override
    public void DataToko(){
       System.out.println("Jenis Produk                    : " + getjenis());
       System.out.println("Warna                           : " + getwarna());
       System.out.println("Harga Produk                    : " + getharga());
       System.out.println("Stok Produk                     : " + stok);
       System.out.println("Bahan                           : " + bahan);
       System.out.println("Tahun                           : " + Tahun());
       System.out.println("Merk                            : " + Nama());
    }
    
    @Override
    public String Tahun(){
        return "2021";
    }

    @Override
    public String Nama(){
        return "Bella Square";
    }



    public int getStok() {
        return stok;
    }

 
    public void setStok(int stok) {
        this.stok = stok;
    }
}