import java.io.*;
import java.util.*;

class ListaAlmacen{
   //Atributos
   private NodoAlmacen inicio;
   private int tam;
    
   //Constructor
   public ListaAlmacen(){
      inicio = null;
      tam = 0;
   }

   //Indica si esta la listaa vacio o no
   public boolean vacio(){
      return tam == 0;
   }

   //Devuelve el tam de la listaa
   public int tam(){
      return tam;
   }
   
   //insercion de un elemento al principio de la lista
   public void agregarAlmacen(){
      NodoAlmacen T = inicio;
      NodoAlmacen aux = inicio;
      NodoAlmacen nuevo = new NodoAlmacen();
      
      if(vacio()){
         inicio = nuevo;
      }else{
         while(aux.sig != null){
            T = aux;
            aux = aux.sig;
         }
         
         aux.sig = nuevo;
         nuevo.ant = aux;
      }
      this.tam++;
   }

    
   //metodo para agregar un cliente a un vuelo
   public void agregarNum(int pos,int num){
      boolean encontrado = false;
      NodoAlmacen aux = inicio;
      int x=1;
      while(aux.sig != null && pos !=x){
            aux = aux.sig;
            x=x+1;
         }
       if(pos==x)
         aux.n.agregar(num);
   }

   public void almacenartotal(){
      NodoAlmacen aux = inicio;
      while(aux != null){
            aux.calculo = aux.n.tam;
            aux = aux.sig;
      }
   }
      
   //metodo para desplegar clientes en un vuelo
   public void desplegar(){
      NodoAlmacen aux = inicio;
      while(aux != null){
         System.out.print(""+aux.calculo);
         aux.n.desplegar();
         aux = aux.sig;
         System.out.println("\n");
      }
   }
}

class NodoAlmacen{
   ListaNumeros n = new ListaNumeros();
   int calculo;
   NodoAlmacen sig;
   NodoAlmacen ant;

   public NodoAlmacen(){
      sig = null;
      ant = null;
   }
}

class NodoNumero{
   int numero;
   NodoNumero sig;
   
   public NodoNumero(int num){
      numero = num;
      sig = null;
   }
}

class ListaNumeros{
   NodoNumero inicio;
   int tam;

   public ListaNumeros() {
      inicio = null;
      tam = 0;
   }

   public boolean vacio() {
      return inicio == null;
   }
   
   //metodo para agregar cliente en la lista de reservaciones de un vuelo
   public void agregar(int n) {
      NodoNumero T = inicio;
      NodoNumero aux = inicio;
      NodoNumero nuevo = new NodoNumero(n);
      
      if(vacio()){
         inicio = nuevo;
      }else{
         while(aux.sig != null ){
            T = aux;
            aux = aux.sig;
         }
      aux.sig = nuevo;
      }
      tam++;
   }
   
   //metodo para desplegar clientes en una lista de reservaciones
   public void desplegar(){
      NodoNumero aux = inicio;
      while (aux != null) {
         System.out.print("--> "+aux.numero);
         aux = aux.sig;
      }
   }
}


class Principal{
   public static void main(String[] args){
      int menu = 1;

      ListaNumeros n = new ListaNumeros();
      ListaAlmacen a = new ListaAlmacen();

      while (menu != 5) {
         //Registrar lista
         if(menu ==1){
            System.out.println("almacen creado");              
            System.out.println("---------------------------\n");

            a.agregarAlmacen();
         }
         //Registrar numeros en un almacen
         if(menu ==2){
            System.out.println("numero que se desea ingresar");
            int num = Lectura.readInt();
            System.out.println("En que almacen se va a registrar el numero: (1-"+a.tam()+"): ");
            int pos = Lectura.readInt();
            a.agregarNum(pos,num);
         }
         //almacenar en primer pos
         if(menu == 3){
            a.almacenartotal();
         }
         //desplegar
         if(menu == 4){
            a.desplegar();
         }
         //opciones del menu
         System.out.print("Ingrese lo que desea hacer:\n" +
         "agregar almacen (1)\n" +
         "registrar numeros en almacen (2)\n" +
         "almacenar en primer elemento el num de elementos (3)\n" +
         "desplegar (4)\n"+
         "salir (5)\n");
         menu = Lectura.readInt();
      }
   }
}

class Lectura{
    public static int readInt(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        int num2=Integer.parseInt(num);
        return num2;
    }

    public static float readFloat(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        float num2=Float.parseFloat(num);
        return num2;
    }

    public static byte readByte(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        byte num2=Byte.parseByte(num);
        return num2;
    }

    public static boolean readBoolean(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        boolean num2=Boolean.getBoolean(num);
        return num2;
    }

    public static double readDouble(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        double num2=Double.parseDouble(num);
        return num2;
    }

    public static long readLong(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        long num2=Long.parseLong(num);
        return num2;
    }

    public static short readShort(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        short num2=Short.parseShort(num);
        return num2;
    }

    public static char readChar(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        char num2=num.charAt(0);
        return num2;
    }
    public static String readString(){
        String num;
        DataInputStream w=new DataInputStream(System.in);
        try{
            num=w.readLine();
        }
        catch(IOException e){num="0";}
        return num;
    }
}

// FIN CLASE LECTURA