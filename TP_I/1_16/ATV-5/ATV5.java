import java.util.Random;
class ATV5 
{
  public static boolean equalsMetod (String s1, String s2)
  {
     boolean resp = false;
     if(s1.length() == s2.length())
     {//Inicio IF
        //Faz a passagem de char em char na string
        for(int i = 0; i < s1.length(); i = i+1)
        {//Inicio FOR
	   //Faz a comparação entre chars
           if(s1.charAt(i) == s2.charAt(i))
           {//Inicio IF2
             resp = true;
           }else{ 
	     resp = false;
	     i = s1.length();
           }//Fim IF2 
        }//Fim FOR
     }//Fim IF
     return(resp);
  }//Fim equalsMetod
  public static String mostrarSort (String s, char a, char b)
  {
     
     String str = "";
     //Faz a passagem de char em char na string
     for(int i = 0; i < s.length(); i++)
     {//Inicio FOR
        if(s.charAt(i) == a)
        {//Inicio IF
           str = str+b;
        }else{
           str = str+s.charAt(i);
        }//Fim IF
     }//Fim FOR
     return(str);
  }//Fim mostraSort
  public static void main(String[] args)
  {
     //Ler o arquivo texto
     String str = MyIO.readLine();
     Random gerador = new Random();
     gerador.setSeed(4);
     int h1;
     int h2;
     char a;
     char b;
     while(!equalsMetod(str, "FIM"))
     {//Inicio WHILE 
         h1 ='a' + Math.abs(gerador.nextInt()%26);
         h2 ='a' + Math.abs(gerador.nextInt()%26);
         a = (char)h1;
         b = (char)h2;
         MyIO.println(mostrarSort(str, a, b));
         str = MyIO.readLine();
	}//Fim WHILE
       
  } // Fim main()
} // Fim class
