class ATV9 
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
  public static String isVogal (String s)
  {
     String resp = "";
     int cont = 0;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
       if(s.charAt(i) == 'a' || s.charAt(i) == 'A' ||
          s.charAt(i) == 'e' || s.charAt(i) == 'E' ||
          s.charAt(i) == 'i' || s.charAt(i) == 'I' ||
          s.charAt(i) == 'o' || s.charAt(i) == 'O' ||
          s.charAt(i) == 'u' || s.charAt(i) == 'U')
       {//Inicio IF
	 cont = cont+1;
       }//Fim IF
     }//Fim FOR	 
     if(cont == s.length())
     {//Inicio IF   
         resp = "SIM";  
     }else{
         resp = "NAO";
     }//Fim IF
     return(resp);
  }//Fim isVogal
  public static String isConsoante (String s)
  {
     String resp = "";
     int cont = 0;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
       if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
          s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
       {//Inicio IF
          if(s.charAt(i) != 'a' && s.charAt(i) != 'A' &&
             s.charAt(i) != 'e' && s.charAt(i) != 'E' &&
             s.charAt(i) != 'i' && s.charAt(i) != 'I' &&
             s.charAt(i) != 'o' && s.charAt(i) != 'O' &&
             s.charAt(i) != 'u' && s.charAt(i) != 'U')
          {//Inicio IF2
	    cont = cont+1;
          }//Fim IF2
       }//Fim IF
     }//Fim FOR	 
     if(cont == s.length())
     {//Inicio IF   
         resp = "SIM";  
     }else{
         resp = "NAO";
     }//Fim IF
     return(resp);
  }//Fim isConsoante
  public static String isInt (String s)
  {
     String resp = "";
     int cont = 0;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
       if((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57)
       {//Inicio IF
	 cont = cont+1;
       }//Fim IF
     }//Fim FOR	 
     if(cont == s.length())
     {//Inicio IF   
         resp = "SIM";  
     }else{
         resp = "NAO";
     }//Fim IF
     return(resp);
  }//Fim isInt
  public static String isReal (String s)
  {
     String resp = "";
     int cont = 0;
     int cont2 = 0;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
       if((int)s.charAt(i) == 44 || (int)s.charAt(i) == 46)
       {//Inicio IF
	 cont = cont+1;
       }//Fim IF
     }//Fim FOR
     if(cont > 1)
     {//Inicio IF
            resp = "NAO";
     }else{
        //Faz a passagem de char em char na string
        for(int i = 0; i<s.length(); i++)
        {//Inicio FOR
          if((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57||
             (int)s.charAt(i) == 44 || (int)s.charAt(i) == 46)
          {//Inicio IF
	    cont2 = cont2+1;
          }//Fim IF
        }//Fim FOR	 
        if(cont2 == s.length())
        {//Inicio IF2
            resp = "SIM";  
        }else{
            resp = "NAO";
        }//Fim IF2
     }//Fim IF
     return(resp);
  }//Fim isReal
  public static void recurseMetod(String str)
  {
     if(!equalsMetod(str, "FIM"))
     {//Inicio IF 	 
         MyIO.println(isVogal(str) + " " + isConsoante(str) + " " + isInt(str) +                      
                      " " + isReal(str));
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
