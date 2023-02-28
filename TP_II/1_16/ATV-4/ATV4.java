class ATV4 
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
  public static String invertPalavra ( String s)
  {
     String invertida = "";
     int j = s.length();
     //Faz a passagem de char em char na string
     for(int i=0; i<j; i = i+1)
     {//Inicio FOR
        invertida = invertida + s.charAt(j-(i+1)); 
     }//Fim FOR
     return(invertida);
  }// Fim invertPalavra
  public static void recurseMetod(String str)
  {
     if(!equalsMetod(str, "FIM"))
     {//Inicio IF 
         MyIO.println(invertPalavra(str));
         str = MyIO.readLine();
         recurseMetod(str);
	}//Fim IF
  }//Fim recurseMetod
  public static void main(String[] args)
  {
     String str = MyIO.readLine();
     recurseMetod(str);  

  } // Fim main()
} // Fim class
