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
 
  public static String comandos (String str)
  {
     String resp = "";
     
     /*Inicio FOR*/
     for(int i = 0; i<2; i++)
     {
       resp = resp + str.charAt(i);
     }
     /*Fim FOR*/

     return(resp);
  }

  public static String[] comandoIR (String str)
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
     int i = 3;
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

  public static int posicaoIR (String str)
  {
     String posicao = "";

     /*Inicio FOR*/
     for(int k = str.length(); k > (str.length()-2); k--)
     {
       posicao = posicao + str.charAt(k-1);
     }
     /*Fim FOR*/

     posicao = invertPalavra(posicao);
     return (Integer.parseInt(posicao));
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
  }//Fim ler

   
}//Fim CLASS Dados
 

/* ====== CLASSE ATV ====== */
class ATV4
{
  public static void main(String[] args)
  {
     Dados dados = new Dados();
     Lista list = new Lista();
     Municipio muni;
     String str = MyIO.readLine();
     int qtd;

     /*Inicio WHILE*/
     while(!str.equals("FIM"))
     {
        muni = new Municipio(dados.ler(str));
        list.inserirFim(muni);
        str = MyIO.readLine();
     }
     /*Inicio WHILE*/

     list.quicksort();
     //list.mostrar();

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

class Lista {
  private Celula primeiro;
  private Celula ultimo;

  public Lista() 
  {
     primeiro = new Celula();
     ultimo = primeiro;
  }

  public void inserirInicio(Municipio x) 
  {
     Celula tmp = new Celula(x);
     tmp.ant = primeiro;
     tmp.prox = primeiro.prox;
     primeiro.prox = tmp;
     /*Inicio IF*/
     if (primeiro == ultimo) 
     {                
        ultimo = tmp;
     }else{
        tmp.prox.ant = tmp;
     }
     /*Inicio IF*/

     tmp = null;
  }

  public void inserirFim(Municipio x) 
  {
     ultimo.prox = new Celula(x);
     ultimo.prox.ant = ultimo;
     ultimo = ultimo.prox;
  }

  public Municipio removerInicio() throws Exception
  {
     if (primeiro == ultimo) 
        throw new Exception("Erro ao remover (vazia)!");

     /* ----- ----- ----- ----- ----- ----- ----- ----- -----*/

     Celula tmp = primeiro;
     primeiro = primeiro.prox;
     Municipio resp = primeiro.elemento;
     tmp.prox = primeiro.ant = null;
     tmp = null;
     return resp;
  }

  public Municipio removerFim() throws Exception 
  {
     if (primeiro == ultimo) 
        throw new Exception("Erro ao remover (vazia)!");

     /* ----- ----- ----- ----- ----- ----- ----- ----- -----*/ 

     /*Caminhar ate a penultima celula*/

     Municipio resp = ultimo.elemento; 
     ultimo = ultimo.ant; 
     ultimo.prox.ant = null;
     ultimo.prox = null;
     return resp;
  }

  public void inserir(Municipio x, int pos) throws Exception 
  {
     int tamanho = tamanho();
     /*Inicio IF*/
     if(pos < 0 || pos > tamanho)
     {
        throw new Exception("Erro ao inserir posicao ("+ pos + " / tamanho = " + tamanho + ") invalida!");
     }else if(pos == 0){
        inserirInicio(x);
     }else if(pos == tamanho){
        inserirFim(x);
     }else{
        /*Caminhar ate a posicao anterior a inserção*/
        Celula i = primeiro;
        for(int j = 0; j < pos; j++, i = i.prox);
		
        Celula tmp = new Celula(x);
        tmp.ant = i;
        tmp.prox = i.prox;
        tmp.ant.prox = tmp.prox.ant = tmp;
        tmp = i = null;
     }/*Fim IF*/
  }

  public Municipio remover(int pos) throws Exception 
  {
     Municipio resp;
     int tamanho = tamanho();
     /*Inicio IF*/
     if (primeiro == ultimo)
     {
        throw new Exception("Erro ao remover (vazia)!");
     }else if(pos < 0 || pos >= tamanho){
	throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
     }else if(pos == 0){
        resp = removerInicio();
     }else if(pos == tamanho - 1){
        resp = removerFim();
     }else{
	/*Caminhar ate a posicao anterior a inserção*/
        Celula i = primeiro.prox;
        for(int j = 0; j < pos; j++, i = i.prox);
	
        i.ant.prox = i.prox;
        i.prox.ant = i.ant;
        resp = i.elemento;
        i.prox = i.ant = null;
        i = null;
     }/*Fim IF*/
     return resp;
  }

  public void mostrar() 
  {
     /*Inicio FOR*/
     for(Celula i = primeiro.prox; i != null; i = i.prox) 
     {
        System.out.print(i.elemento.toString() + "\n");
     }/*Fim FOR*/
  }

  public boolean ordenarPorNome(Celula i, Celula j) 
  {
     boolean resp = false;
     String x1 = i.elemento.getNome();
     String x2 = j.elemento.getNome();
     int x = x1.compareTo(x2);
     if( x > 0)
     {//Inicio IF
        resp = true;
     }else if(x < 0){
        resp = false;
     }//Fim IF
     return resp;
  }

  public boolean ordenarPorUF(Celula i, Celula j) 
  {
    boolean resp = false;
    String y1 = i.elemento.getUF();
    String y2 = j.elemento.getUF();
    int y = y1.compareTo(y2);
    if( y > 0 )
    {
       resp = true; 
    }else if (y < 0){
       resp = false;
    }
    return resp;
  }

  public Celula acharPivo(int qtd, Celula j) 
  {
     Celula k = j; 
     for(int i = 0; i < qtd; k = k.prox, i++);

     return k;
  }

  public void swap(Celula i, Celula j) 
  {
	Municipio element = new Municipio();

	element = j.elemento;
	j.elemento = i.elemento;	
	i.elemento = element;
  }

  public boolean achaEsp(Celula i, Celula j) 
  {
     boolean resp = false;
     int m = 0, n = 0;      

     for(Celula tmp = primeiro; tmp != i; tmp = tmp.prox, m++);

     for(Celula tmp = primeiro; tmp != j; tmp = tmp.prox, n++);

     if(m <= n) resp = true;
     
     return resp;
  }

  public void quicksort() {
     int tamanho = tamanho();

	//System.out.println(tamanho);
	quicksort(primeiro.prox, ultimo, tamanho);
   }


  private void quicksort(Celula esq, Celula dir, int tamanho) 
  {
        Celula i = esq;
        Celula j = dir;

        int qtd = tamanho/2;
        Celula pivo = acharPivo(qtd, esq);
	System.out.println(qtd);
        /*Inicio WHILE*/
        while (achaEsp(i, j) || i == j) 
        {
           /* --------------------------------------------------------------------------------- */
           while(i.elemento.getDeficiencia() < pivo.elemento.getDeficiencia()) {
                  i = i.prox; System.out.println("1rwra");}
           while(j.elemento.getDeficiencia() > pivo.elemento.getDeficiencia()) {
                  j = j.ant; System.out.println("2rwra"); }
           /* --------------------------------------------------------------------------------- */

           /*Inicio IF*/            
           if(achaEsp(i, j) || i == j)
           { 
               /*Inicio IF2*/
               if(i.elemento.getDeficiencia() > j.elemento.getDeficiencia()) 
               {
                  swap(i, j);
                  i = i.prox;
                  j = j.ant;

               }else if(i.elemento.getDeficiencia() == j.elemento.getDeficiencia()){

                  /*Inicio IF3*/
                  if(!i.elemento.getUF().equals(j.elemento.getUF())) 
                  {
   
                     /* ---------- IF ---------- */
                     if(ordenarPorUF(i, j) == true)
                     {
                        swap(i, j);
                        i = i.prox;
                        j = j.ant;
                     }

                     /* ---------- IF ---------- */

                  }else if(i.elemento.getUF().equals(j.elemento.getUF())){

                     /* ----------- IF ----------- */ 
                     if(ordenarPorNome(i, j) == true)
                     {
						
                        swap(i, j);
                        i = i.prox;
                        j = j.ant; 
                     }
                     /* ----------- IF ----------- */

                  }
                  /*Fim IF3*/
              } 
              /*Fim IF2*/
           }
           /*Fim IF*/

        }
        /*Fim WHILE*/
		System.out.println("4rwra");
        /* --------------------- IF --------------------- */
        if(achaEsp(esq, j) == true)  quicksort(esq, j, qtd);
        if(achaEsp(i, dir) == true)  quicksort(i, dir, qtd);
        /* --------------------- IF --------------------- */
    }

  public int tamanho() 
  {
     int tamanho = 0; 

     for(Celula i = primeiro.prox; i != null; i = i.prox, tamanho++);
	
     return tamanho;
  }

}//Fim CLASS Lista

class Celula {
  public Municipio elemento; 
  public Celula ant;
  public Celula prox;

  public Celula() 
  {
     this.elemento = null;
     this.prox = this.ant = null;
  }

  public Celula(Municipio elemento) 
  {
     this.elemento = elemento;
     this.ant = this.prox = null;
  }
}//Fim CLASS Celula
