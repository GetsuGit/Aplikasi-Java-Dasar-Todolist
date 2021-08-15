package AplikasiList;

public class MainClass {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        viewList();

    }

    // ============= Membuat logic Aplikasi List =================

    // Menampilkan List
    public static void showList(){
        System.out.println("====== Aplikasi Menampilkan dan Menghapus List ======");
       for (int i = 0; i < model.length; i++ ){

          String todo = model[i];
          int no = i + 1;

          if (todo != null){
              System.out.println(no + ". " + todo);
          }
       }
    }

    // Test showList
    public static void testShowlist(){
        model[0] = "List Ke 1";
        model[1] = "List Ke 2";
        model[2] = "List Ke 3";
        showList();
    }

    // Menambah List
    public static void addList(String todo) {
        // cek apakah list penuh
        boolean isFull = true;
        for (int i = 0; i < model.length; i++){
            if(model[i] == null){
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

    // jika penuh, resize ukuran array 2x
    if (isFull){
        String[] temp  = model;
        model = new String[model.length * 2];

    // mereset
    for (int i = 0; i < temp.length; i++){
        model[i] = temp[i];
       }
    }

    // menambah ke posisi array nilainya null
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    // test add list
    public static void testAddlist(){
       for (int i = 0; i < 25; i++){
           addList("Contoh List Ke. " + i);
       }
        showList();
    }


    // Menghapus List
    public static boolean removeList(Integer number){

        if ((number - 1) >= model.length){
            return false;
        } else if (model[number - 1] == null){
            return false;
        } else {
           for (int i = (number - 1); i < model.length; i++){
               if (i == (model.length - 1)){
                   model[i] = null;
               } else {
                   // menggeser ke atas
                   model[i] = model[i + 1];
               }
           }
            return true;
        }
    }

    // Test menghapus list
     public static void testRemoveList(){

         addList("Satu");
         addList("Dua");
         addList("Tiga");
         addList("Empat");
         addList("Lima");

         boolean result = removeList(20);
         System.out.println(result);

         result =  removeList(7);
         System.out.println(result);

         result =  removeList(2);
         System.out.println(result);

         showList();
     }

     public static String input(String info){
        System.out.println(info + ": ");
        String data = scanner.nextLine();
        return data;
     }

     public static void testInput(){
        String name = input("nama");
        System.out.println("Hi " + name);

        String channel = input("Channel");
        System.out.println(channel);
     }


    // ============= Membuat Tampilan Aplikasi List =================

    // Menampilkan menu
    public static void viewList(){
       while (true) {
           showList();

           System.out.println("Menu : ");
           System.out.println("1. Tambah");
           System.out.println("2. Hapus");
           System.out.println("x. Keluar");

           String input = input("Pilih");

           if (input.equals("1")){
               viewAddList();
           } else if (input.equals("2")){
               viewRemoveList();
           } else if(input.equals("x")) {
               break;
           } else {
               System.out.println("Pilihan tidak di men gerti");
               }
           }
       }
// tes viewList
 public static void testViewList(){

     addList("Satu");
     addList("Dua");
     addList("Tiga");
     addList("Empat");
     addList("Lima");
     viewList();

 }

 // Menampilkan tambah list
    public static void viewAddList(){
        System.out.println("===== Menambah List =====");
        System.out.println("Masupkan list yang akan anda isi : ");
        String todo = input("(Pilih x Jika Batal)");

        // cek apakah menambah atau batal
        if (todo.equals("x")){
            // batal
        } else {
            addList(todo);
        }
    }

    // test viewAddList
    public static void testviwAddlist(){

        addList("Satu");
        addList("Dua");
        viewAddList();

        // coba menampilkan lagi
        showList();

    }

    // Menampilkan hapus list
    public static void viewRemoveList(){
        System.out.println("===== Menghapus List =====");

        String number = input("Pilih nomor yang di hapus (Pilih x Jika Batal)");

        if (number.equals("x")){
            // batal
        } else {
            boolean success =  removeList(Integer.valueOf(number));
            if (!success){
                System.out.println("Gagal menghapus list : " + number);
            }
        }
    }

    // test remove list
    public static void tesviewRemoveList(){
        addList("Satu");
        addList("Dua");
        addList("Tiga");
        addList("Empat");
        addList("Lima");

        showList();
        viewRemoveList();
        showList();
    }
}
