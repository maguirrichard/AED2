class Dados
{
  
  public static String pegaDados (String nomearq, int j, int k, int n)
  {
     /*Abre ARQ*/
     Arq.openRead(nomearq, "ISO-8859-1");
     String help = " ";
     String leitor = " ";
     
     /*Inicio FOR*/
     for(int i = 1; i <= j; i++)
     {
       leitor = Arq.readLine();  
     }
     /*Fim FOR*/      
     
     /*Inicio WHILE*/ 
     while((int)leitor.charAt(k) != n)
     {
        help = help+leitor.charAt(k);
        k++;
     }
     /*Fim WHILE*/

     /*Fecha ARQ*/
     Arq.close();

     return(help);
  }
   
  public static String acharUf (String nomearq, int j)
  {
     /*Abre ARQ*/
     Arq.openRead(nomearq, "ISO-8859-1");
     String help = " ";
     String leitor = " ";

     /*Inicio FOR*/
     for(int i = 1; i <= j; i++)
     {
       leitor = Arq.readLine();  
     }
     /*Fim FOR*/
     
     /*Inicio FOR*/ 
     for(int i = 6; i<8; i++)
     {
        help = help+leitor.charAt(leitor.length()-i);
     }
     /*Fim FOR*/

     /*Fecha ARQ*/
     Arq.close();
     
     return(invertPalavra(help));
  }

  public static String invertPalavra (String s)
  {
     String invertida = "";
     int j = s.length();

     /*Inicio FOR*/
     for(int i=0; i<j; i = i+1)
     {
        invertida = invertida + s.charAt(j-(i+1)); 
     }
     /*Fim FOR*/

     return(invertida);
  }

  public static String removeVirg (String str)
  {
     str = str.replace(',','.');
     return(str);
  }

  public static String removePonto (String str)
  {
     str = str.replace('.',' ');
     String resp = "";

     /*Inicio FOR*/
     for(int i = 0; i<str.length(); i++)
     {
       /*Inicio IF*/
       if(str.charAt(i) != ' ')
       {
	 resp = resp + str.charAt(i);
       }/*Fim IF*/
     }/*Fim FOR*/ 

     return(resp);
  }
 
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

     /*Inicio WHILE*/
     while(str.charAt(i) !=  '-')
     {
       nome = nome + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/ 

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  ' ')
     {
       uf = uf + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i = i+2;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  ')')
     {
       cod = cod + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i = i+3;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       latitude = latitude + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       longitude = longitude + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       altitude = altitude + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  ')')
     {
       periodo = periodo + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/ 

     i = i+3;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       temperatura = temperatura + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/ 

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       precipitacao = precipitacao + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       evpot = evpot + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       armazenamento = armazenamento + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       evreal = evreal + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  '/')
     {
       deficiencia = deficiencia + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/

     i++;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  ')')
     {
       excedente = excedente + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/ 

     i = i+3;
     /*Inicio WHILE*/
     while(str.charAt(i) !=  ')')
     {
       fonte = fonte + str.charAt(i);
       i++;
     }
     /*Fim WHILE*/
 
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
  }

  public String[] ler (String nomearq)
  {
     String[] array = new String[15];
     int linha = 43; 
     int caracter = 64;
     int especial = 45;
     String cod = " ";
 
     /*Inicio FOR*/
     for(int i = 11; i<14; i++)
     {
        cod = cod+nomearq.charAt(i);
     }
     /*Fim FOR*/     
     
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
  }
   
}//Fim CLASS Dados
 
 
/* ====== CLASSE ATV3 ====== */
class ATV2 
{
  public static void main(String[] args)
  {
     Dados dados = new Dados();
     Pilha pil = new Pilha();
     Municipio muni;
     String str = MyIO.readLine();
     /*Inicio WHILE*/
     while(!str.equals("FIM"))
     {
        muni = new Municipio(dados.ler(str));
        pil.inserir(muni);
        str = MyIO.readLine();
     }
     /*Fim WHILE*/

     str = MyIO.readLine();
     int qtd = Integer.parseInt(str);

     /*Inicio FOR*/
     for(int i = 0; i < qtd; i++)
     {
        str = MyIO.readLine();
        /*Inicio IF*/
        if(str.charAt(0) == 'I')
        {
           muni = new Municipio(dados.comando(str));
           pil.inserir(muni);
        }else if(str.charAt(0) == 'R')
        {
           try{
              Municipio tmp = pil.remover();
              MyIO.println("(R) "+tmp.getNome().toString()+"-"+tmp.getUF().toString());
           }catch(Exception erro){
              System.out.println(erro.getMessage());
           }
        }/*Fim IF*/
     }/*Fim FOR*/
 
     pil.mostrar();

  }// Fim MAIN
}//Fim CLASS ATV1


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

}//Fim CLASS Municipio

class Pilha {
  private Celula topo;

  public Pilha() 
  {
     topo = null;
  }

  public void inserir(Municipio x) 
  {
     Celula tmp = new Celula(x);
     tmp.prox = topo;
     topo = tmp;
     tmp = null;
  }

  public Municipio remover() throws Exception 
  {
     if (topo == null) 
        throw new Exception("Erro ao remover!");

     /* ----- ----- ----- ----- ----- ----- ----- ----- -----*/		

     Municipio resp = topo.elemento;
     Celula tmp = topo;
     topo = topo.prox;
     tmp.prox = null;
     tmp = null;
     return resp;
  }

  public void mostrar() 
  {
     mostrar(topo);
  }

  public void mostrar(Celula i) 
  {
     if(i != null)
     {
        mostrar(i.prox);
        MyIO.println(i.elemento + " ");
     }
  }

}//Fim CLASS Pilha

class Celula {
  public Municipio elemento; 
  public Celula prox;

  public Celula() 
  {
     this.elemento = null;
     this.prox = null;
  }

  public Celula(Municipio elemento) 
  {
     this.elemento = elemento;
     this.prox = null;
  }
}//Fim CLASS Celula
