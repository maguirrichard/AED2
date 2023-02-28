import java.io.*;
class Q01
{
  public static void main(String[] args) throws Exception
  {
     //Ler o arquivo texto
     int qtd = MyIO.readInt();
     double help;

     RandomAccessFile raf1 = new RandomAccessFile("dados.txt", "rw");
     for(int i = 0; i < qtd; i++)
     {// Inicio FOR 
        help = MyIO.readDouble();
        raf1.writeDouble(help);
     }//Fim FOR
     raf1.close();
     
     int qtd2 = qtd-1;
     int qtd3 = qtd2;
     
     
     RandomAccessFile raf2 = new RandomAccessFile("dados.txt", "r");
     for(int i = 0; i < qtd; i++)
     {//Inicio FOR2
        raf2.seek(0);

        for(int j = 0; j < qtd2; qtd2--)
           raf2.readDouble();

        raf2.seek(raf2.getFilePointer());
        help = raf2.readDouble();

        MyIO.println(help);

        qtd2 = qtd3-(i+1);
     }//Fim FOR
     raf2.close();
     
  } // Fim main()
} // Fim class
