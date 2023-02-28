class ATV8 
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
  public static boolean isLetraTo (char s)
  { 
     boolean resp = false;
	//Verifica se é letra especial
        if(s == 'á' || s == 'Á' || s == 'ã' || s == 'Ã' ||
           s == 'â' || s == 'Â' || s == 'à' || s == 'À' ||
           s == 'é' || s == 'É' || s == 'ê' || s == 'Ê' ||
	   s == 'è' || s == 'È' ||            
           s == 'ô' || s == 'Ô' || s == 'ó' || s == 'Ó' ||
	   s == 'ò' || s == 'Ò' ||
 	   s == 'í' || s == 'Í' || s == 'ì' || s == 'Ì' ||
	   s == 'ú' || s == 'Ú' || s == 'ù' || s == 'Ù' ||
	   s == 'ç' || s == 'Ç')
        {//Inicio IF
           resp = true;
        }//Fim IF
     return(resp);
  }//Fim isLetraTo
  public static boolean isVogal (char s)
  { 
     boolean resp = false;
	//Verifica se é vogal
        if(s >= 'a' && s <= 'z' ||
           s >= 'A' && s <= 'Z')
        {//Inicio IF
           if(s == 'a' || s == 'e' || s == 'i' || s == 'o' ||
              s == 'u' || s == 'A' || s == 'E' || s == 'I' ||
              s == 'O' || s == 'U')
           {//Inicio IF2
              resp = true;
           }//Fim IF2 
        }//Fim IF
     return(resp);
  }//Fim isVogal
  public static boolean isConsoante (char s)
  { 
     boolean resp = false;
	//Verifica se é consoante
        if(s >= 'a' && s <= 'z' ||
           s >= 'A' && s <= 'Z')
        {//Inicio IF
           if(s != 'a' && s != 'e' && s != 'i' && s != 'o' &&
              s != 'u' && s != 'A' && s != 'E' && s != 'I' &&
              s != 'O' && s != 'U')
           {//Inicio IF2
              resp = true;
           }//Fim IF2 
        }//Fim IF
     return(resp);
  }//Fim isConsoante
  public static boolean isNum (char s)
  { 
     boolean resp = false;
	//Verifica se é número
        if(s >= '0' && s <= '9')
        {//Inicio IF
           resp = true;
        }//Fim IF
     return(resp);
  }//Fim isNum
  public static int convertToInt (char s)
  { 
     int resp;
     resp = (int)s-48;
     return(resp);
  }//Fim isNum
  public static int contChar (String s)
  {
     char x = s.charAt(0);
     int cont = 1;
     //Faz a passagem de char em char na string
     for(int i = 1; i<s.length(); i++)
     {//Inicio FOR
       if(x == s.charAt(i))
       {//Inicio IF
	 cont = cont+1;
       }//Fim IF
     }//Fim For	 
     return(cont);
  }//Fim Contchar
  public static int contLetra (String s)
  {
     int cont = 0;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
       if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
          s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
       {//Inicio IF
	 cont = cont+1;
       }//Fim IF
     }//Fim FOR	 
     return(cont);
  }//Fim contLetra
  public static int notLetra (String s)
  {
     int cont = 0;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
       if(s.charAt(i) < 'A' || s.charAt(i) > 'Z' && s.charAt(i) < 'a' || s.charAt(i) > 'z')
       {//Inicio IF
	 cont = cont+1;
       }//Fim IF
     }//Fim FOR	 
     return(cont);
  }// Fim notLetra
  public static int charDoido (String s)
  {
     int cont = 0;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
        if(isNum(s.charAt(i)) && convertToInt(s.charAt(i)) %2 != 0)
        {//Inicio IF
           cont = cont+1;
        }else if(isConsoante(s.charAt(i)) && (int)s.charAt(i) %5 == 0 && (int)s.charAt(i) %2 != 0)
	{
           cont = cont+1;
        }else if(isVogal(s.charAt(i)) && (int)s.charAt(i) %5 != 0 && (int)s.charAt(i) %2 != 8)
        {//Inicio IF2
	   cont = cont+1;
        }//Fim IF
     }//Fim FOR	 
     return(cont);
  }//Fim charDoido
  public static void main(String[] args)
  {
     //Ler o arquivo texto
     String str = MyIO.readLine();

     while(!equalsMetod(str, "FIM"))
     {//Inicio WHILE
         MyIO.println(contChar(str) + " " + contLetra(str) + " " + notLetra(str) + 		    
                      " " + charDoido(str));
	 str = MyIO.readLine(); 
     }//Fim WHILE

  } // Fim main()
} // Fim class
