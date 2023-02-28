class ATV10 
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
  public static String toMaisc (String s)
  { 
     String str = "";
     int k;
     char help;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
	//Verifica se esta entre azinho e zezinho
        if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
        {//Inicio IF
          k = (int)s.charAt(i);
          k = k-32;
          help = (char)k;
	//Verifica se é caracter especial
        }else{
          if(s.charAt(i) == 'ç')
          {//Inicio IF2
	    help = 'Ç';
          }else if (s.charAt(i) == 'á')
          {//Inicio ELSE IF
            help = 'Á';
          }else if (s.charAt(i) == 'ã')
          {//Inicio ELSE IF
            help = 'Ã';
          }else if (s.charAt(i) == 'â')
          {//Inicio ELSE IF
            help = 'Â';
          }else if (s.charAt(i) == 'à')
          {//Inicio ELSE IF
            help = 'À';
          }else if (s.charAt(i) == 'å')
          {//Inicio ELSE IF
            help = 'Å';
          }else if (s.charAt(i) == 'é')
          {//Inicio ELSE IF
            help = 'É';
          }else if (s.charAt(i) == 'ê')
          {//Inicio ELSE IF
            help = 'Ê';
          }else if (s.charAt(i) == 'í')
          {//Inicio ELSE IF
            help = 'Í';
          }else if (s.charAt(i) == 'ì')
          {//Inicio ELSE IF
            help = 'Ì';
          }else if (s.charAt(i) == 'ô')
          {//Inicio ELSE IF
            help = 'Ô';
          }else if (s.charAt(i) == 'ó')
          {//Inicio ELSE IF
            help = 'Ó';
          }else if (s.charAt(i) == 'ò')
          {//Inicio ELSE IF
            help = 'Ò';
          }else if (s.charAt(i) == 'ø')
          {//Inicio ELSE IF
            help = 'Ø';
          }else if (s.charAt(i) == 'ú')
          {//Inicio ELSE IF
            help = 'Ú';
          }else if (s.charAt(i) == 'ù')
          {//Inicio ELSE IF
            help = 'Ù';
          }else{
            help = s.charAt(i);
          }//Fim IF2
	}//Fim IF
	str = str+help;
     }//Fim FOR 
     return(str);
  }//Fim toMaisc
  public static String toMinusc (String s)
  {
     String str = "";
     int k;
     char help;
     //Faz a passagem de char em char na string
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
	//Verifica se esta entre azão e zezão
        if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
        {//Inicio IF
          k = (int)s.charAt(i);
          k = k+32;
          help = (char)k;
	//Verifica se é caracter especial
        }else{
          if(s.charAt(i) == 'Ç')
          {//Inicio IF2
	    help = 'ç';
          }else if (s.charAt(i) == 'Á')
          {//Inicio ELSE IF
            help = 'á';
          }else if (s.charAt(i) == 'Ã')
          {//Inicio ELSE IF
            help = 'ã';
          }else if (s.charAt(i) == 'Â')
          {//Inicio ELSE IF
            help = 'â';
          }else if (s.charAt(i) == 'À')
          {//Inicio ELSE IF
            help = 'à';
          }else if (s.charAt(i) == 'Å')
          {//Inicio ELSE IF
            help = 'å';
          }else if (s.charAt(i) == 'É')
          {//Inicio ELSE IF
            help = 'é';
          }else if (s.charAt(i) == 'Ê')
          {//Inicio ELSE IF
            help = 'ê';
          }else if (s.charAt(i) == 'Í')
          {//Inicio ELSE IF
            help = 'í';
          }else if (s.charAt(i) == 'Ì')
          {//Inicio ELSE IF
            help = 'ì';
          }else if (s.charAt(i) == 'Ô')
          {//Inicio ELSE IF
            help = 'ô';
          }else if (s.charAt(i) == 'Ó')
          {//Inicio ELSE IF
            help = 'ó';
          }else if (s.charAt(i) == 'Ò')
          {//Inicio ELSE IF
            help = 'ò';
          }else if (s.charAt(i) == 'Ø')
          {//Inicio ELSE IF
            help = 'ø';
          }else if (s.charAt(i) == 'Ú')
          {//Inicio ELSE IF
            help = 'ú';
          }else if (s.charAt(i) == 'Ù')
          {//Inicio ELSE IF
            help = 'ù';
          }else{
            help = s.charAt(i);
          }//Fim IF2
	}//Fim IF
	str = str+help;
     }//Fim FOR 
     return(str);
  }//Fim toMinusc
  public static String rmvSpc (String s)
  {
     String resp = "";
     for(int i = 0; i<s.length(); i++)
     {//Inicio FOR
       if(s.charAt(i) != ' ')
       {//Inicio IF
	 resp = resp + s.charAt(i);
       }//Fim IF
     }	//Fim FOr 
     return(resp);
  }//FIm rmvSpc
  public static String rmvFirstChar (String s)
  {
     char x = s.charAt(0);
     String resp = "";
     for(int i = 1; i<s.length(); i++)
     {//Inicio FOR
       if(s.charAt(i) != x)
       {//Inicio IF
	 resp = resp + s.charAt(i);
       }//FIm IF
     }//Fim FOR	 
     return(resp);
  }//Fim rmvFirstChar
  public static void recurseMetod(String str)
  {
     if(!equalsMetod(str, "FIM"))
     {//Inicio IF 
         MyIO.println(toMaisc(str));
         MyIO.println(toMinusc(str));
         MyIO.println(rmvSpc(str));
         MyIO.println(rmvFirstChar(str));
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
