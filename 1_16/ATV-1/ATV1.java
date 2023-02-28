class ATV1 
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
  public static String invertPalavra (String s)
  {
     String resp = "";
     int j = s.length();
     //Faz apassagem de char em char na string	
     for(int i=0; i<j; i = i+1)
     {//Inicio FOR
         resp = resp + s.charAt(j-(i+1)); 
     }//Fim FOR
     return(resp);
  }//Fim invertPalavra
  public static void main(String[] args)
  {
     //Ler o arquivo texto
     String str = MyIO.readLine();
     String help;

     while(!equalsMetod(str, "FIM"))
     {//Inicio WHILE 
         //Comparação entre as strings  
         help = invertPalavra(str);
         if(equalsMetod(str, help))
         {//Inicio IF
	    MyIO.println("SIM"); 
         }else{
	    MyIO.println("NAO"); 
         }//Fim IF
         str = MyIO.readLine();
	}//Fim WHILE
       
  } // Fim main()
} // Fim class
