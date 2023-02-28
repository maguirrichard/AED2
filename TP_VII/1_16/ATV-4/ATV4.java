/* ====== CLASSE DADOS ====== */
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

  public static double pesquisa (String str)
  {
     int help = str.length();
	String tmp = "";
     double resp = 0.0;

     /*Inicio FOR*/
     for(int i = 2; i<str.length(); i++)
     {
	   tmp = tmp + str.charAt(i);
     }/*Fim FOR*/ 
	tmp = removeVirg(tmp);
	//System.out.println(tmp);
	resp = Double.parseDouble(tmp);
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
     Alvinegra tree = new Alvinegra();
     Municipio muni;
     String str = MyIO.readLine();
     int qtd;

     /*Inicio WHILE*/
     while(!str.equals("FIM"))
     {
        muni = new Municipio(dados.ler(str));

	   /*Inicio TRY*/
	   try{
           tree.inserir(muni);
        }catch(Exception erro){
           //System.out.println(erro.getMessage());
        }/*Fim TRY*/

        str = MyIO.readLine();
     }
     /*Inicio WHILE*/

     str = MyIO.readLine();
     qtd = Integer.parseInt(str);

     /*Inicio FOR*/
     for(int i = 0; i < qtd; i++)
     {
        str = MyIO.readLine();
        muni = new Municipio(dados.comando(str));
        try{
           tree.inserir(muni);
        }catch(Exception erro){
           //System.out.println(erro.getMessage());
        }
     }/*Fim FOR*/
	str = MyIO.readLine();

     /*Inicio WHILE*/
     while(!str.equals("FIM"))
     {
        tree.pesquisar2(Double.parseDouble(str));
	   str = MyIO.readLine();
     }/*Fim WHILE*/

  }// Fim MAIN
}//Fim CLASS ATV1

/* ====== CLASSE ARVOREBINARIA ====== */
class Alvinegra {
  private No raiz;

  public Alvinegra() 
  {
	raiz = null;
  }

  public boolean pesquisar(int elemento) 
  {
	return pesquisar(elemento, raiz);
  }

  private boolean pesquisar(int elemento, No i) 
  {
	boolean resp;
	if (i == null) {
	   resp = false;

	} else if (elemento == i.elemento) {
	   resp = true;

	} else if (elemento < i.elemento) {
	   resp = pesquisar(elemento, i.esq);

	} else {
	   resp = pesquisar(elemento, i.dir);
	}
	
	return resp;
 }

  public void inserir(int elemento) throws Exception 
  {
   
	//Se a arvore tiver tres ou mais elementos
	if(raiz != null && raiz.esq != null && raiz.dir != null){

	   inserir(elemento, null, null, null, raiz);
	   System.out.println("Arvore com tres ou mais elementos...");
      
	//Senao, se a arvore estiver vazia
	} else if(raiz == null){
	   raiz = new No(elemento, false);
	   System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento + ").");

	//Senao, se a arvore tiver um elemento 
	} else if (raiz.esq == null && raiz.dir == null){
	   if (raiz.elemento > elemento)
	   {
		 raiz.esq = new No(elemento, true);
		 System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento +").");
	   } else {
		 raiz.dir = new No(elemento, true);
		 System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento +").");
        }

      //Senao, se a arvore tiver dois elementos (raiz e dir)
	} else if (raiz.esq == null){

	   if(raiz.elemento > elemento){
		 raiz.esq = new No(elemento);
		 System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");

	} else if (raiz.dir.elemento > elemento){
	   raiz.esq = new No(raiz.elemento);
	   raiz.elemento = elemento;
	   System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");

	} else {
	   raiz.esq = new No(raiz.elemento);
	   raiz.elemento = raiz.dir.elemento;
	   raiz.dir.elemento = elemento;
	   System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
	}

	raiz.esq.cor = raiz.dir.cor = false;
         
	//Senao, se a arvore tiver dois elementos (raiz e esq)
	} else if (raiz.dir == null){
         
	   if(raiz.elemento < elemento){
		 raiz.dir = new No(elemento);
		 System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
	   } else if (raiz.esq.elemento < elemento){
		 raiz.dir = new No(raiz.elemento);
		 raiz.elemento = elemento;
		 System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
	   } else {
		 raiz.dir = new No(raiz.elemento);
		 raiz.elemento = raiz.esq.elemento;
		 raiz.esq.elemento = elemento;
		 System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").");
	   }

	   raiz.esq.cor = raiz.dir.cor = false;
	} else {
	   throw new Exception("Erro ao inserir!");
	}

	raiz.cor = false;

  }

  private void balancear(No bisavo, No avo, No pai, No i)
  {

	//Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
	if(pai.cor == true)
	{

	   //4 tipos de reequilibrios e acoplamento
	   if(pai.elemento > avo.elemento)
	   { // rotacao a esquerda ou direita-esquerda
		 if(i.elemento > pai.elemento){
		    avo = rotacaoEsq(avo);
		 } else {
		    avo = rotacaoDirEsq(avo);
		 }

	   } else { // rotacao a direita ou esquerda-direita
		 if(i.elemento < pai.elemento){
		    avo = rotacaoDir(avo);
		 } else {
		    avo = rotacaoEsqDir(avo);
		 }
	   }

	   if (bisavo == null){
		 raiz = avo;
	   } else {
		 if(avo.elemento < bisavo.elemento){
		    bisavo.esq = avo;
		 } else {
		    bisavo.dir = avo;
		 }
	   }

	   //reestabelecer as cores apos a rotacao
	   avo.cor = false;
	   avo.esq.cor = avo.dir.cor = true;
	   System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir(" + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
	} //if(pai.cor == true)

  }

  private void inserir(int elemento, No bisavo, No avo, No pai, No i) throws Exception 
  {
	if (i == null) 
	{

	   if(elemento < pai.elemento){
		 i = pai.esq = new No(elemento, true);
	   } else {
		 i = pai.dir = new No(elemento, true);
	   }

	   if(pai.cor == true){
 		 balancear(bisavo, avo, pai, i);
	   }

	} else {

	   //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
	   if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
		 i.cor = true;
		 i.esq.cor = i.dir.cor = false;
		 if(i == raiz){
		    i.cor = false;
		 }else if(pai.cor == true){
		    balancear(bisavo, avo, pai, i);
		 }
	   }
	   if (elemento < i.elemento) {
		 inserir(elemento, avo, pai, i, i.esq);
	   } else if (elemento > i.elemento) {
		 inserir(elemento, avo, pai, i, i.dir);
	   } else {
		 throw new Exception("Erro inserir (elemento repetido)!");
	   }
	}
  }

  private No rotacaoDir(No no) 
  {
	System.out.println("Rotacao DIR(" + no.elemento + ")");
	No noEsq = no.esq;
	No noEsqDir = noEsq.dir;

	noEsq.dir = no;
	no.esq = noEsqDir;

	return noEsq;
  }

  private No rotacaoEsq(No no) 
  {
	System.out.println("Rotacao ESQ(" + no.elemento + ")");
	No noDir = no.dir;
	No noDirEsq = noDir.esq;

	noDir.esq = no;
	no.dir = noDirEsq;
	return noDir;
  }

  private No rotacaoDirEsq(No no)
  {
	no.dir = rotacaoDir(no.dir);
	return rotacaoEsq(no);
  }

  private No rotacaoEsqDir(No no) 
  {
	no.esq = rotacaoEsq(no.esq);
	return rotacaoDir(no);
  }
  
}//Fim CLASS ArvoreBinaria

/* ====== CLASSE MUNICIPIO ====== */
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

/* ====== CLASSE NO ====== */
class No {
  public Municipio elemento; 
  public boolean cor;
  public No esq; 
  public No dir;

  public No() 
  {
     this(null);
  } 

  public No(Municipio elemento) 
  {
     this(elemento, null, null, false);
  }

  public No(Municipio elemento, boolean cor) 
  {
     this(elemento, cor, null, null);
  }

  public No(Municipio elemento, boolean cor, No esq, No dir) 
  {
	this.elemento = elemento;
	this.esq = esq;
	this.dir = dir;
	this.cor = cor;
  }
}//Fim CLASS No
