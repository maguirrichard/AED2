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
class ATV3
{
  public static void main(String[] args)
  {
     Dados dados = new Dados();
     AVL tree = new AVL();
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

        /*Inicio IF*/
        if(str.charAt(0) == 'I')
        {
           muni = new Municipio(dados.comando(str));
           try{
              tree.inserir(muni);
           }catch(Exception erro){
              //System.out.println(erro.getMessage());
           }
        }
         else if(str.charAt(0) == 'R')
        {
           try{
		    tree.remover(dados.pesquisa(str));
           }catch(Exception erro){
              //System.out.println(erro.getMessage());
           }
        }/*Fim IF*/

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

/* ====== CLASSE AVL ====== */
class AVL {
  private No raiz; 

  public AVL() 
  {
	raiz = null;
  }

  public int getAltura() 
  {
	return nivel(raiz) - 1;
  }

  private int nivel(No no)
  {
	return (no == null) ? 0 : (1 + Math.max(nivel(no.esq), nivel(no.dir)));
  }

  public boolean pesquisar(Municipio elemento) 
  {
	return pesquisar(raiz, elemento);
  }

  private boolean pesquisar(No no, Municipio x) 
  {
	boolean resp;

	/*Inicio IF*/	
	if (no == null){
	   resp = false;
     }else if(x.getTemperatura() == no.elemento.getTemperatura()){
        resp = true;
     }else if(x.getTemperatura() < no.elemento.getTemperatura()){
        resp = pesquisar(no.esq, x);
     }else{
        resp = pesquisar(no.dir, x);
     }/*Fim IF*/

	return resp;
  }

  public void pesquisar2(double temp) 
  {
	System.out.print("raiz ");	
	pesquisar2(raiz, temp);
  }

  private void pesquisar2(No no, double x) 
  {
	
	/*Inicio IF*/	
	if (no == null) {
        System.out.print("NAO\n");
     }else if(x == no.elemento.getTemperatura()){
        System.out.print("SIM\n");
     }else if(x < no.elemento.getTemperatura()){
        System.out.print("esq ");
	   pesquisar2(no.esq, x);
     }else{
        System.out.print("dir ");
	   pesquisar2(no.dir, x);
     }/*Fim IF*/

  }

  public void mostrarCentral() 
  {
	mostrarCentral(raiz);
  }

  private void mostrarCentral(No no) 
  {  
	/*Inicio IF*/
	if (no != null) 
	{
	   mostrarCentral(no.esq); 
	   System.out.print(no.elemento.toString() + "\n");
	   mostrarCentral(no.dir); 
	}/*Fim IF*/
  }

  public void mostrarPre() 
  {
	mostrarPre(raiz);
  }

  private void mostrarPre(No no) 
  {
	/*Inicio IF*/	
	if (no != null) 
	{
	   System.out.print(no.elemento.toString() + "\n");
        mostrarPre(no.esq); 
	   mostrarPre(no.dir); 
	}/*Fim IF*/
  }

  public void mostrarPos() 
  {
	mostrarPos(raiz);
  }

  private void mostrarPos(No no) 
  {
	/*Inicio IF*/	
	if (no != null) 
	{
	   mostrarPos(no.esq); 
	   mostrarPos(no.dir);
	   System.out.print(no.elemento.toString() + "\n"); 
	}/*Fim IF*/
  }

  public void inserir(Municipio x) throws Exception 
  {
	raiz = inserir(raiz, x);
  }

  private No inserir(No no, Municipio x) throws Exception 
  {
	/*Inicio IF*/	
	if (no == null){
	   no = new No(x);
     }else if(x.getTemperatura() < no.elemento.getTemperatura()){
	   no.esq = inserir(no.esq, x);
     }else if(x.getTemperatura() > no.elemento.getTemperatura()){
	    no.dir = inserir(no.dir, x);
     }else{ 
	   throw new Exception("Erro ao inserir!");
     }/*Fim IF*/

	no = balancear(no);
	return no;
  }

  private No balancear(No no) throws Exception 
  {
	/*Inicio IF1*/
	if(no != null)
	{
	   int fator = No.getNivel(no.dir) - no.getNivel(no.esq);

	   //Se balanceada
	   /*Inicio IF2*/	
	   if (Math.abs(fator) <= 1){
	      no = no.setNivel();

	   //Se desbalanceada para a direita
	   }else if (fator == 2){
	      int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);

	      //Se o filho a direita tambem estiver desbalanceado
		 /*Inicio IF3*/	
	      if (fatorFilhoDir == -1)
	      {
	         no.dir = rotacionarDir(no.dir);
	      }
		 /*Fim IF3*/	
	      no = rotacionarEsq(no);

	   //Se desbalanceada para a esquerda
	   }else if (fator == -2){

	      int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);

	      //Se o filho a esquerda tambem estiver desbalanceado
		 /*Inicio IF3*/	
	      if (fatorFilhoEsq == 1) 
	      {
	         no.esq = rotacionarEsq(no.esq);
	      }
		 /*Fim IF3*/	
	      no = rotacionarDir(no);

	   }else{
	      throw new Exception("Erro fator de balanceamento (" + fator + ") invalido!"); 
	   }/*Fim IF2*/	
	}

	return no;
  }

  private No rotacionarDir(No no) 
  {
	//System.out.println("Rotacionar DIR(" + no.elemento + ")");
	No noEsq = no.esq;
	No noEsqDir = noEsq.dir;

	noEsq.dir = no;
	no.esq = noEsqDir;

	no.setNivel();
	noEsq.setNivel();

	return noEsq;
  }

  private No rotacionarEsq(No no) 
  {
	//System.out.println("Rotacionar ESQ(" + no.elemento + ")");
	No noDir = no.dir;
	No noDirEsq = noDir.esq;

	noDir.esq = no;
	no.dir = noDirEsq;

	no.setNivel();
	noDir.setNivel();
	return noDir;
  }

  public void remover(double x) throws Exception 
  {
	raiz = remover(raiz, x);
  }

  private No remover(No no, double x) throws Exception 
  {
	/*Inicio IF*/	
	if (no == null) {
        throw new Exception("Erro ao remover!");
     }else if(x < no.elemento.getTemperatura()){
        no.esq = remover(no.esq, x);
     }else if(x > no.elemento.getTemperatura()){
        no.dir = remover(no.dir, x);
     }else if(no.dir == null){
        no = no.esq;
     }else if(no.esq == null){
        no = no.dir;
     }else{
        no.esq = antecessor(no, no.esq);
	}/*Fim IF*/
	
	no = balancear(no);
	return no;
  }

  private No antecessor(No n1, No n2) 
  {
	/*Inicio IF*/	
	if (n2.dir != null) 
	{
	   n2.dir = antecessor(n1, n2.dir);
	}else{
	   n1.elemento = n2.elemento; 
	   n2 = n2.esq; 
	}/*Fim IF*/

	return n2;
  }
}//Fim CLASS AVL

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
  public No esq; 
  public No dir; 
  public int nivel;

  public No(Municipio elemento) 
  {
     this(elemento, null, null, 1);
  }

  public No(Municipio elemento, No esq, No dir, int nivel) 
  {
	this.elemento = elemento;
	this.esq = esq;
	this.dir = dir;
	this.nivel = nivel;
  }

  public No setNivel() 
  {
	this.nivel = 1 + Math.max(getNivel(esq),getNivel(dir));
     return this;
  }

  public static int getNivel(No no) 
  {
	return (no == null) ? 0 : no.nivel;
  }
}//Fim CLASS No
