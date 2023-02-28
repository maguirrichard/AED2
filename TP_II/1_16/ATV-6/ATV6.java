class ATV6 
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
  public static String compareString (String s1, String s2)
  {
     String resp = "";
     
     //Primeira comparação
     if(equalsMetod(s1, s2))
     {//Inicio IF
       resp = "SIM"; 
     }else{
       resp = "NAO";
     }//Fim IF	 

     //Segunda comparação
     if(equalsMetod(toMinusc(s1), toMinusc(s2)))
     {//Inicio IF
       resp = resp + " SIM"; 
     }else{
       resp = resp + " NAO";
     }//Fim IF
     return(resp);
  }//Fim compareString
  public static void recurseMetod(String str1, String str2)
  {
     if(!equalsMetod(str1, "FIM"))
     {//Inicio IF 
	 if(equalsMetod(str2, "FIM"))
         {//Inicio IF2 
           MyIO.print(compareString(str1, str1));
	   str1 = "FIM";
	 }else{
 	    MyIO.println(compareString(str1, str2));
         }//Fim IF2 
         str1 = MyIO.readLine();
	 str2 = MyIO.readLine();
         recurseMetod(str1, str2);        
     }//Fim IF2
  }//Fim recurseMetod
  public static void main(String[] args)
  {
     //Ler o arquivo texto
     String str1 = MyIO.readLine();
     String str2 = MyIO.readLine();
     recurseMetod(str1, str2);

  } // Fim main()
} // Fim class
