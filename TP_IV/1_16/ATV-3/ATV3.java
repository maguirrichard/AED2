class Dados
{
  
  public static String pegaDados (String nomearq, int j, int k, int n)
  {
     Arq.openRead(nomearq, "ISO-8859-1");
     String help = " ";
     String leitor = " ";
     for(int i = 1; i <= j; i++)
     {//Inicio FOR
       leitor = Arq.readLine();  
     }//Fim FOR
      
     //MyIO.println(leitor);
      
     while((int)leitor.charAt(k) != n)
     {//Inicio WHILE
        help = help+leitor.charAt(k);
        k++;
     }//Fim WHILE
     Arq.close();
     return(help);
  }
   
  public static String acharUf (String nomearq, int j)
  {
     Arq.openRead(nomearq, "ISO-8859-1");
     String help = " ";
     String leitor = " ";
     for(int i = 1; i <= j; i++)
     {//Inicio FOR
       leitor = Arq.readLine();  
     }//Fim FOR
      
     //MyIO.println(leitor);
      
     for(int i = 6; i<8; i++)
     {//Inicio FOR
        help = help+leitor.charAt(leitor.length()-i);
     }//Fim FOR
     Arq.close();
     
     return(invertPalavra(help));
  }

  public static String invertPalavra (String s)
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

  public static String removeVirg (String str)
  {
     str = str.replace(',','.');
     return(str);
  }// Fim invertPalavra

  public static String removePonto (String str)
  {
     str = str.replace('.',' ');
     String resp = "";
     for(int i = 0; i<str.length(); i++)
     {//Inicio FOR
       if(str.charAt(i) != ' ')
       {//Inicio IF
	 resp = resp + str.charAt(i);
       }//Fim IF
     }	//Fim FOr 
     return(resp);
  }// Fim invertPalavra
 

  public static String[] comando (String str)
  {
     String nome = "";
     String uf = "";
     String cod = "";
     String latitude = "";
     String longitude = "";
     String altitude = "";
     String periodo = "";
     String temperatura = "";
     String precipitacao = "";
     String evpot = "";
     String armazenamento = "";
     String evreal = "";
     String deficiencia = "";
     String excedente = "";
     String fonte = "";
     int i = 2;
     String[] array = new String[15];

     while(str.charAt(i) !=  '-')
     {//Inicio WHILE
       nome = nome + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  ' ')
     {//Inicio WHILE
       uf = uf + str.charAt(i);
       i++;
     }//Fim WHILE 

     i = i+2;
     while(str.charAt(i) !=  ')')
     {//Inicio WHILE
       cod = cod + str.charAt(i);
       i++;
     }//Fim WHILE 

     i = i+3;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       latitude = latitude + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       longitude = longitude + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       altitude = altitude + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  ')')
     {//Inicio WHILE
       periodo = periodo + str.charAt(i);
       i++;
     }//Fim WHILE 

     i = i+3;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       temperatura = temperatura + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       precipitacao = precipitacao + str.charAt(i);
       i++;
     }//Fim WHILE

     i++;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       evpot = evpot + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       armazenamento = armazenamento + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       evreal = evreal + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  '/')
     {//Inicio WHILE
       deficiencia = deficiencia + str.charAt(i);
       i++;
     }//Fim WHILE 

     i++;
     while(str.charAt(i) !=  ')')
     {//Inicio WHILE
       excedente = excedente + str.charAt(i);
       i++;
     }//Fim WHILE 

     i = i+3;
     while(i < str.length()-1)
     {//Inicio WHILE
       fonte = fonte + str.charAt(i);
       i++;
     }//Fim WHILE
 
     array[0] = nome;
     array[1] = uf;
     array[2] = cod;
     array[3] = latitude;
     array[4] = longitude;
     array[5] = altitude;
     array[6] = periodo;
     array[7] = temperatura;
     array[8] = precipitacao;
     array[9] = evpot;
     array[10] = armazenamento;
     array[11] = evreal;
     array[12] = deficiencia;
     array[13] = excedente;
     array[14] = fonte;

     return(array);
  }//FIm comandos

  public String[] ler (String nomearq)
  {
     String[] array = new String[15];
     int linha = 43; 
     int caracter = 64;
     int especial = 45;
     String cod = " ";
 
     for(int i = 11; i<14; i++)
     {
        cod = cod+nomearq.charAt(i);
     }     
     
     //Sring nome
     array[0] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[0]);
     
     linha = 43;
     caracter = 77;
     especial = 60;
      
     //String uf
     array[1] = acharUf(nomearq, linha).trim();
     //MyIO.println(array[1]);
    
     //int cod
     array[2] = cod.trim();
     //MyIO.println(array[2]);
      
     linha = 50;
     caracter = 27;
      
     //String latitude
     array[3] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[3]);
      
     linha = 52;
     caracter = 27;
     especial = 60;
      
     //String longitude
     array[4] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[4]);
      
     linha = 54;
     caracter = 27;
     especial = 109;
      
     //int altitude
     array[5] = pegaDados(nomearq, linha, caracter, especial).trim();
     array[5] = removePonto(array[5]).trim();
     //MyIO.println(array[5]);
      
     linha = 56;
     caracter = 27;
     especial = 60;
      
     //String periodo
     array[6] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[6]);
      
     linha = 271;
     caracter = 40;
     especial = 38;
      
     //double medtemp
     array[7] = pegaDados(nomearq, linha, caracter, especial).trim();
     array[7] = removeVirg(array[7]);
     //MyIO.println(array[7]);
 
     linha = 272;
     caracter = 40;
     especial = 38;
      
     //int precip
     array[8] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[8]);
 
     linha = 273;
     caracter = 40;
     especial = 38;
      
     //int etp
     array[9] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[9]);
 
     linha = 274;
     caracter = 40;
     especial = 38;
      
     //int armaz
     array[10] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[10]);
 
     linha = 275;
     caracter = 40;
     especial = 38;
      
     //int etr
     array[11] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[11]);
 
     linha = 276;
     caracter = 40;
     especial = 38;
      
     //int deficiencia
     array[12] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[12]);
 
     linha = 277;
     caracter = 40;
     especial = 38;
      
     //int excedente
     array[13] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[13]);
 
     linha = 283;
     caracter = 45;
     especial = 60;
      
     //String fonte
     array[14] = pegaDados(nomearq, linha, caracter, especial).trim();
     //MyIO.println(array[14]);
     
     return(array);
  }//Fim ler

   
}//Fim CLASS Dados
 
 
/* ====== CLASSE ATV3 ====== */
class ATV3 
{//Inicio CLASS ATV3
  public static void main(String[] args)
  {//Inicio MAIN
     Dados dados = new Dados();
     Lista lista = new Lista(1000);
     Municipio muni;
     String str = MyIO.readLine();
     double help = 0.0;
     int x = 0;
     while(!str.equals("FIM"))
     {//Inicio WHILE
        muni = new Municipio(dados.ler(str));
        lista.inserir(muni);
        x++; 
        str = MyIO.readLine();
     }//Fim WHILE
     lista.selecao(x);
     lista.mostrar(x);
  }// Fim MAIN
}//Fim CLASS ATV3


class Municipio
{
  private int cod, altitude, precipitacao, evpot, armazenamento, evreal, deficiencia, excedente;
  private double temperatura;
  private String nome, uf, longitude, latitude, periodo, fonte;
  
  public Municipio()
  {
     this.nome = "";
     this.uf = "";
     this.cod = 0;
     this.latitude = "";
     this.longitude = "";
     this.altitude = 0;
     this.periodo = "";
     this.temperatura = 0.0;
     this.precipitacao = 0;
     this.evpot = 0;
     this.armazenamento = 0;
     this.evreal = 0;
     this.deficiencia = 0;
     this.excedente = 0;
     this.fonte = "";
  }

  public Municipio(String[] array)
  {
     this.nome = array[0];
     this.uf = array[1];
     this.cod = Integer.parseInt(array[2]);
     this.latitude = array[3];
     this.longitude = array[4];
     this.altitude = Integer.parseInt(array[5]);
     this.periodo = array[6];
     this.temperatura = Double.parseDouble(array[7]);
     this.precipitacao = Integer.parseInt(array[8]);
     this.evpot = Integer.parseInt(array[9]);
     this.armazenamento = Integer.parseInt(array[10]);
     this.evreal = Integer.parseInt(array[11]);
     this.deficiencia = Integer.parseInt(array[12]);
     this.excedente = Integer.parseInt(array[13]);
     this.fonte = array[14];
  }

  @Override
  public String toString(){
    return (this.nome + "-" + this.uf + " (" + this.cod + ") (" + this.latitude + "/" + this.longitude +
            "/" + this.altitude + "/" + this.periodo + ") (" + this.temperatura + "/" + this.precipitacao
            + "/" + this.evpot + "/" + this.armazenamento + "/" + this.evreal + "/" + this.deficiencia +
            "/" + this.excedente + ") (" + this.fonte+ ")");
  }

  public void setNome (String nome)
  {
     this.nome = nome;
  }
  public void setUf (String uf)
  {
     this.uf = uf;
  }
  public void setCod (int cod)
  {
     this.cod = cod;
  }
  public void setLatitude (String latitude)
  {
     this.latitude = latitude;
  }
  public void setLongitude (String longitude)
  {
     this.longitude = longitude;
  }
  public void setAltitude (int altitude)
  {
     this.altitude = altitude;
  }
  public void setPeriodo (String periodo)
  {
     this.periodo = periodo;
  }
  public void setTemperatura (double temperatura)
  {
     this.temperatura = temperatura;
  }
  public void setPrecipitacao (int precipitacao)
  {
     this.precipitacao = precipitacao;
  }
  public void setEvpot (int evpot)
  {
     this.evpot = evpot;
  }
  public void setArmazenamento (int armazenamento)
  {
     this.armazenamento = armazenamento;
  }
  public void setEvreal (int evreal)
  {
     this.evreal = evreal;
  }
  public void setDeficiencia (int deficiencia)
  {
     this.deficiencia = deficiencia;
  }
  public void setExcedente (int excedente)
  {
     this.excedente = excedente;
  }
  public void setFonte (String fonte)
  {
     this.fonte = fonte;
  }
  public String getNome ()
  {
     return this.nome;
  }
  public String getUF ()
  {
     return this.uf;
  }
  public int getCod ()
  {
     return this.cod;
  }
  public String getLatitude ()
  {
     return this.latitude;
  }
  public String getLongitude ()
  {
     return this.longitude;
  }
  public int getAltitude ()
  {
     return this.altitude;
  }
  public String getPeriodo ()
  {
     return this.periodo;
  }
  public double getTemperatura ()
  {
     return this.temperatura;
  }
  public int getPrecipitacao ()
  {
     return this.precipitacao;
  }
  public int getEvpot ()
  {
     return this.evpot;
  }
  public int getArmazenamento ()
  {
     return this.armazenamento;
  }
  public int getEvreal ()
  {
     return this.evreal;
  }
  public int getDeficiencia ()
  {
     return this.deficiencia;
  }
  public int getExcedente ()
  {
     return this.excedente;
  }
  public String getFonte ()
  {
     return this.fonte;
  }
  
  public String imprimir()
  {
   return(this.nome + "-" + this.uf + " (" + this.cod + ") (" + this.latitude                  + "/" + this.longitude + "/" + this.altitude + "/" + this.periodo + ") (" +                    this.temperatura + "/" + this.precipitacao + "/" + this.evpot + "/" + this.armazenamento +                  "/" + this.evreal + "/" + this.deficiencia + "/" + this.excedente + ") (" +                   this.fonte+ ")" );
  }//Fim imprimir

}//Fim CLASS Municipio



class Lista
{
  public Municipio[] lista;
  public int primeiro;
  private int ultimo;
  private int k;

  public Lista()
  {
     this.lista = new Municipio[6];
     primeiro = 0;
     ultimo = 0;
     k = 0;
  }
  
  public Lista(int tamanho)
  {
     this.lista = new Municipio[tamanho+1];
     primeiro = 0;
     ultimo = 0;
     k = 0;
  }

  public void inserir (Municipio muni) 
  {
     //validar insercao
     if (((ultimo + 1) % lista.length) == primeiro) 
     {
        remover();
        lista[ultimo] = muni; 
        ultimo = (ultimo + 1) % lista.length;
     }else{
        lista[ultimo] = muni; 
        ultimo = (ultimo + 1) % lista.length;     
     }//Fim IF

     if(k < 6)
     {
        k++;
     }else if (k >= 6){
        k--;
     }
  }

  public void remover () 
  {
     
     //validar remocao
     if (primeiro == ultimo)
     {
        MyIO.println("ERRO AO REMOVER");
     }else{
        primeiro = (primeiro + 1) % lista.length;
        k--;
        }//Fim IF
     if(k < 0)
     {
        k = 0;
     }
  }

  

  public boolean ordenarPorNome(int menor, int j) 
  {
     boolean resp = false;
     String x1 = lista[menor].getNome();
     String x2 = lista[j].getNome();
     int x = x1.compareTo(x2);
     if( x > 0)
     {//Inicio IF
        resp = true;
     }else if(x < 0){
        resp = false;
     }//Fim IF
     return resp;
  }

  public boolean ordenarPorUF(int menor, int j) 
  {
    boolean resp = false;
    String y1 = lista[menor].getUF();
    String y2 = lista[j].getUF();
    int y = y1.compareTo(y2);
    if( y > 0 )
    {
       resp = true; 
    }else if (y < 0){
       resp = false;
    }
    return resp;
  }

  public void mostrar(int n) 
  {
     for (int i = 0; i < n; i++) 
     {//Inicio for
         MyIO.println(lista[i].imprimir());
     }//Fim FOR
  }

  public void swap(int i, int j) 
  {
     Municipio temp = lista[i];
     lista[i] = lista[j];
     lista[j] = temp;
  }

  public void selecao (int n) 
  {
     for (int i = 0; i < (n - 1); i++) 
     {//Inicio FOR
        int menor = i;
        for (int j = (i + 1); j < n; j++)
        {//Inicio FOR2
           if (lista[j].getPrecipitacao() < lista[menor].getPrecipitacao())
           {//Inicio IF      
              menor = j;
           }else if (lista[j].getPrecipitacao() == lista[menor].getPrecipitacao()){
              if(!lista[menor].getUF().equals(lista[j].getUF()))
              {//Inicio IF2
                 if(ordenarPorUF(menor, j) == true)
                    menor = j;
              }else if(lista[menor].getUF().equals(lista[j].getUF())){
                 if(ordenarPorNome(menor, j) == true)
                    menor = j;
              }//Fim IF2
           }//Fim IF
        }//Fim FOR2
        swap(menor, i);
     }//Fim FOR
   }

}//Fim CLASS Lista
