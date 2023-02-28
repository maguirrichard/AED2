class ATV3 
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
  public static String cifraCesar (String s)
  {
     char h;
     int k;	
     String cifrada = "";
     //Faz a passagem de char em char na string
     for(int i=0; i<s.length(); i = i+1)
     {//Inicio FOR
        h = s.charAt(i);
        k = (int)h;
        k = k-3;
        h = (char)k;		
        cifrada = cifrada + h; 
     }//Fim FOR
     return(cifrada);
  }//Fim cifraCesar
  public static void recurseMetod(String str)
  {
     if(!equalsMetod(str, "FIM"))
     {//Inicio IF 
         MyIO.println(cifraCesar(str)); 
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
