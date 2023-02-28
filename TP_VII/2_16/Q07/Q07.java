  /**********************************
    * Q07
    * @author Maguirrichard Oliveira.
    * @version 1 02/2016.
    *********************************/
class Q07
{
  public static void main(String[] args)
  {
	Pessoa pessoa;
	Hash hash = new Hash();
     String str = MyIO.readLine();
	String dados = "";
	int id = 0, help = 0;

     while(!str.equals("FIM"))
     {
	   pessoa = new Pessoa();
        pessoa.criarPessoa(str);
	   try
	   {
	      hash.inserir(pessoa);
	      help++;
	   }catch(Exception erro){
	      MyIO.println(erro.getMessage());
	   }
        str = MyIO.readLine();
     }

     help = MyIO.readInt();
     for(int i = 0; i<help; i++)
     {
        str = MyIO.readLine();
	   if(str.contains("I"))
	   {
		 dados = str.substring(2, (str.length()));
		 pessoa = new Pessoa();
		 pessoa.parsePessoa(dados.trim());
		 hash.inserir(pessoa);
	   }else{
		 dados = str.substring(2, (str.length()));
		 id = Integer.parseInt(dados);
		 hash.remover(id);
	   }
     }

	str = MyIO.readLine();
     while(!str.equals("FIM"))
     {
	   help = Integer.parseInt(str);
	   hash.pesquisar(help);
	   str = MyIO.readLine();
     }
  }
}

  /**********************************
    * Pessoa
    * @author Maguirrichard Oliveira.
    * @version 1 02/2016.
    *********************************/
class Pessoa
{
  private int id, idade;
  private String nome, nacionalidade, dataNasc, localNasc, dataMorte, localMorte;

  /***********************
   * Construtor da classe.
   ***********************/  
  public Pessoa()
  {
	this.id = 0;
	this.idade = 0;
	this.nome = " ";
	this.nacionalidade = " ";
	this.dataNasc = " ";
	this.localNasc = " ";
	this.dataMorte = " ";
	this.localMorte = " ";
  }

  /*************************************************************************
   * Faz a leitura do html e faz um parse para retirada dos dados da pessoa.
   * @param nomearq String nome do arquivo a ser lido.
   *************************************************************************/
  public void criarPessoa (String nomearq)
  {
	Arq.openRead(nomearq,"ISO-8859-1");// "UTF8");
	int id = 0, idade = 0, coluna = 0;
	String nome = "", nacionalidade = "", dataNasc = "", localNasc = "", 
		  dataMorte = "", localMorte = "", tmp = "", tmp2 = "", leitor = "";
/* --------------------------ID-----------------------------------------------------------------*/	
	for(int i = 5; i<8; i++)
	{
	   tmp = tmp+nomearq.charAt(i);
	}
	
	id = Integer.parseInt(tmp);
	//MyIO.println(id);
/* --------------------------ID-----------------------------------------------------------------*/

/* --------------------------NOME---------------------------------------------------------------*/
	for(int i = 1; i <= 38; i++) leitor = Arq.readLine();
      
	//MyIO.println(leitor);
	//MyIO.println(coluna);
	coluna = 56;
	while((int)leitor.charAt(coluna) != 60)
	{//Inicio WHILE
	   nome = nome+leitor.charAt(coluna);
	   //MyIO.println(help + " " + coluna);
 	   coluna++;
	}//Fim WHILE

	//nome = pegaNome(str, 38, 56, 60);
	//MyIO.println(nome);
/* --------------------------NOME---------------------------------------------------------------*/

/* --------------------------NACIONALIDADE------------------------------------------------------*/
	tmp = "Nacionalidade";

	while(!leitor.contains(tmp)) leitor = Arq.readLine();

     nacionalidade = removeTags(Arq.readLine());
	//MyIO.println(nacionalidade);
/* --------------------------NACIONALIDADE------------------------------------------------------*/

/* --------------------------DATANASC-----------------------------------------------------------*/
	tmp = "Nascimento";

	while(!leitor.contains(tmp)) leitor = Arq.readLine();

     dataNasc = removeTags(Arq.readLine());
	if(dataNasc.charAt(dataNasc.length()-1) == ')')
	{
	   int k = dataNasc.indexOf('(') + 1;
	   //MyIO.println(k);

	   for(int i = k; i < k+2; i++)
	      tmp2 = tmp2+dataNasc.charAt(i);

	   idade = Integer.parseInt(tmp2);
	   dataMorte = "vivo";
	   localMorte = "vivo";
	   dataNasc = dataNasc.substring(0, dataNasc.length()-9);
	}
	//MyIO.println(dataNasc);
/* --------------------------DATANASC-----------------------------------------------------------*/

/* --------------------------LOCALNASC----------------------------------------------------------*/
	tmp = "Local";

	while(!leitor.contains(tmp)) leitor = Arq.readLine();

     localNasc = removeTags(Arq.readLine());
	//MyIO.println(localNasc);
/* --------------------------LOCALNASC----------------------------------------------------------*/

/* -------------------------DATAMORTE-----------------------------------------------------------*/
	tmp = "Morte";


	if(dataMorte.length() == 0)
	{
	   while(!leitor.contains(tmp)) leitor = Arq.readLine();

	   dataMorte = removeTags(Arq.readLine());
	   if(dataMorte.charAt(dataMorte.length()-1) == ')')
	   {
	      int k = dataMorte.indexOf('(') + 1;
	      //MyIO.println(k);
	      tmp2 = "";

	      for(int i = k; i < k+2; i++)
	        tmp2 = tmp2+dataMorte.charAt(i);

	      idade = Integer.parseInt(tmp2);
	      dataMorte = dataMorte.substring(0, dataMorte.length()-9);
	   }
	}

	//MyIO.println(dataMorte);
/* -------------------------DATAMORTE-----------------------------------------------------------*/

/* -------------------------LOCALMORTE----------------------------------------------------------*/
	tmp = "Local";

	if(localMorte.length() == 0)
	{
	   while(!leitor.contains(tmp)) leitor = Arq.readLine();

	   localMorte = removeTags(Arq.readLine());
	}

	//MyIO.println(localMorte);
/* -------------------------LOCALMORTE----------------------------------------------------------*/

	Arq.close();   
	
/* -------------------------FAZ_PESSOA----------------------------------------------------------*/
	
	this.id = id;
	this.nome = nome;
	this.nacionalidade = nacionalidade;
	this.dataNasc = dataNasc;
	this.localNasc = localNasc;
	this.dataMorte = dataMorte;
	this.localMorte = localMorte;
	this.idade = idade;

/* -------------------------FAZ_PESSOA----------------------------------------------------------*/	
  }

  /****************************************************
   * Retira as tags de cada linha lida no arquivo html.
   * @param s String linha do arquivo a ser tratada.
   ****************************************************/
  public String removeTags(String s)
  {
	String resp = "";
	 
	for (int i = 0; i < s.length(); i++)
	{
	 
	//Perguntas: (1) Pq o while abaixo? (2) Pq as clausulas do while abaixo nao podem ser invertidas?
	   while(i < s.length() && s.charAt(i) == '<')
	   {
	      for (i++; s.charAt(i) != '>'; i++);
	      i++;
	 
	      //Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
	      while(i < s.length() && s.charAt(i) == '&')
	      {
	         for (i++; s.charAt(i) != ';'; i++);
	         i++;
	      }
	   }
	 
	   //Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
	   while(i < s.length() && s.charAt(i) == '&')
	   {
	      for (i++; s.charAt(i) != ';'; i++);
	      i++;
	      resp += ' ';
	   }
	 
	   //Perqunta: Pq nao colocamos apenas resp += s.charAt(i)?
	   if(i < s.length()) resp += s.charAt(i);
         
     }
 
	while(resp.length() > 0 && resp.charAt(0) == ' ') resp = resp.substring(1);
 
	return resp;
  }

  /****************************************************************
   * Faz um split na string separando os dados pelo parametro '##'.
   * @param s String dados retirados a serem tratados.
   ****************************************************************/
  public void parsePessoa(String s)
  {
	String array[] = s.split(" ## ");
	this.id = Integer.parseInt(array[0]);
	this.nome = array[1];
	this.nacionalidade = array[2];
	this.dataNasc = array[3];
	this.localNasc = array[4];
	this.dataMorte = array[5];
	this.localMorte = array[6];
	this.idade = Integer.parseInt(array[7]);
  }

  /*****************************************
   * Imprime os dados cadastrados da pessoa.
   *****************************************/
public void imprimir(){
	MyIO.println(this.id + " ## " + this.nome  + " ## " + this.nacionalidade + " ## " +
                  this.dataNasc + " ## " + this.localNasc + " ## " + this.dataMorte + " ## " +
                  this.localMorte + " ## " + this.idade);
  }

  /********************************
   * Faz um clone do objeto pessoa.
   ********************************/
  public Pessoa clone ()
  {
	Pessoa resp = new Pessoa();
	resp.id = this.id;
	resp.nome = this.nome;
	resp.nacionalidade = this.nacionalidade;
	resp.dataNasc = this.dataNasc;
	resp.localNasc = this.localNasc;
	resp.dataMorte = this.dataMorte;
	resp.localMorte = this.localMorte;
	resp.idade = this.idade;
	return resp;
  }

  /*               Metodos SET                 */

  public void setID (int id)
  {
	this.id = id;
  }

  public void setIdade (int idade)
  {
	this.idade = idade;
  }

  public void setNome (String nome)
  {
	this.nome = nome;
  }

  public void setNacionalidade (String nacionalidade)
  {
	this.nacionalidade = nacionalidade;
  }

  public void setDataNasc (String dataNasc)
  {
	this.dataNasc = dataNasc;
  }

  public void setLocalNasc (String localNasc)
  {
	this.localNasc = localNasc;
  }

  public void setDataMorte (String dataMorte)
  {
	this.dataMorte = dataMorte;
  }

  public void setLocalMorte (String localMorte)
  {
	this.localMorte = localMorte;
  }

  /*               Metodos GET                 */

  public int getID ()
  {
	return this.id;
  }

  public int getIdade ()
  {
	return this.idade = idade;
  }

  public String getNome ()
  {
	return this.nome;
  }

  public String getNacionalidade ()
  {
	return this.nacionalidade;
  }

  public String getDataNasc ()
  {
	return this.dataNasc;
  }

  public String getLocalNasc ()
  {
	return this.localNasc;
  }

  public String getDataMorte ()
  {
	return this.dataMorte;
  }

  public String getLocalMorte ()
  {
	return this.localMorte;
  }
}

  /*****************************
   * Lista estatica
   * @author Max do Val Machado.
   * @version 2 01/2015.
   *****************************/
class Hash 
{
  Lista tabela[];
  int tamanho;
 
  public Hash ()
  {
      this(21);
  }
 
  public Hash (int tamanho)
  {
	this.tamanho = tamanho;
	this.tabela = new Lista[tamanho];
	for(int i = 0; i < tamanho; i++) tabela[i] = new Lista();
  }
 
  public int h(int elemento)
  {
	return elemento % tamanho;
  }

  public void pesquisar(int elemento)
  {
	int pos = h(elemento);
	if(tabela[pos].pesquisar(elemento) == true) MyIO.println("SIM");
	else MyIO.println("NAO");
  }
 
  public void inserir(Pessoa elemento)
  {
	int pos = h(elemento.getID());
	tabela[pos].inserir(elemento);
  }

  public void remover(int elemento)
  {
	int pos = h(elemento);
	if(tabela[pos].pesquisar(elemento) == true) tabela[pos].remover(elemento);
  }
}

/************************************
 * Celula simples.
 * @author Joao Paulo Domingos Silva.
 * @version 1.1 02/2012.
 ************************************/
class Celula 
{
  public Pessoa elemento; // Elemento inserido na celula.
  public Celula prox; // Aponta a celula prox.
 
  /**********************************************
   * Construtor da classe.
   * @param elemento Elemento inserido na celula.
   **********************************************/
  Celula(Pessoa elemento) 
  {
	this.elemento = elemento;
	this.prox = null;
  }
 
  /**********************************************
   * Construtor da classe.
   * @param elemento Elemento inserido na celula.
   * @param prox Aponta a celula prox.
   **********************************************/
  Celula(Pessoa elemento, Celula prox) 
  {
	this.elemento = elemento;
	this.prox = prox;
  }
}
 
/*********************************
 * Lista simples.
 * @author Maguirrichard Oliveira.
 * @version 1 02/2016
 *********************************/
class Lista 
{
  private Celula primeiro; // Primeira celula: SEM elemento valido.
  private Celula ultimo; // Ultima celula: COM elemento valido.
 
  /**
   * Construtor da classe: Instancia uma celula (primeira e ultima).
   */
  public Lista() 
  {
	primeiro = new Celula(null);
	ultimo = primeiro;
  }
 
  /**
   * Procura um elemento e retorna se ele existe.
   * @param x Elemento a pesquisar.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
  public boolean pesquisar(int x) 
  {
	boolean retorno = false;
	for (Celula i = primeiro.prox; i != null; i = i.prox)
	{
	   if(i.elemento.getID() == x)
	   {
		 retorno = true;
		 i = ultimo;
	   }
	}
	return retorno;
  }
 
  /******************************************************
   * Insere um elemento na primeira posicao da sequencia.
   * @param elemento Elemento a inserir.
   ******************************************************/
  public void inserir(Pessoa elemento) 
  {
	Celula tmp = new Celula(elemento);
	tmp.prox = primeiro.prox;
	primeiro.prox = tmp;

	if (primeiro == ultimo) ultimo = tmp;

	tmp = null;
  }

  public void remover(int x) 
  {
	for (Celula i = primeiro; i != null; i = i.prox)
	{
	   if(i.prox != null && i.prox.elemento.getID() == x)
	   {
		 i.prox = i.prox.prox;
	   }
	}
  }
}
