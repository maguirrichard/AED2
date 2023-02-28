  /**********************************
    * Q01
    * @author Maguirrichard Oliveira.
    * @version 1 02/2016.
    *********************************/
class Q01
{
  public static void main(String[] args)
  {
	Pessoa pessoa = new Pessoa();
	Lista lista = new Lista();
     String str = MyIO.readLine();
	int contador;

     while(!str.equals("FIM"))
	{
	   pessoa = new Pessoa();
        pessoa.criarPessoa(str);
	   try
	   {
		 lista.inserirFim(pessoa);
	   }catch(Exception erro){
		 MyIO.println(erro.getMessage());
	   }
        str = MyIO.readLine();
	}

	//lista.mostrar();
 
	contador = MyIO.readInt();
     
	for(int i = 0; i < contador; i++)
	{
	   str = MyIO.readLine();
	   String dados = "", operacao = str.substring(0, 2), tmp = "";
	   int posicao = 0;
 
	   if(!operacao.contains("R"))
		 dados = str.substring(3, (str.length()));
 
	   if(operacao.contains("*"))
	   {
		 tmp = str.substring(3, 5);
		 posicao = Integer.parseInt(tmp);
	   }
 
	   tmp = "";
	   operacao = operacao.trim();
	   switch (operacao)
	   {
		 case "II":
		    pessoa = new Pessoa();
		    //MyIO.println(dados);
		    pessoa.parsePessoa(dados.trim());
		    try
		    {
			  lista.inserirInicio(pessoa);
            }catch(Exception erro){
			  MyIO.println(erro.getMessage());
            }
            break;
 
		 case "IF":
		    pessoa = new Pessoa();
		    //MyIO.println(dados);
		    pessoa.parsePessoa(dados.trim());
		    try
		    {
			  lista.inserirFim(pessoa);
		    }catch(Exception erro){
			  MyIO.println(erro.getMessage());
		    }
		    break;
 
		 case "I*":
		    pessoa = new Pessoa();
		    tmp = dados.substring(3, dados.length());
		    //MyIO.println(tmp);
		    pessoa.parsePessoa(tmp.trim());
		    try
		    {		    
			  lista.inserir(pessoa, posicao);
		    }catch(Exception erro){
			  MyIO.println(erro.getMessage());
		    }
            break;
 
		 case "RI":
		    try
		    {
			  pessoa = lista.removerInicio();
			  MyIO.println("(R) " + pessoa.getNome());
		    }catch(Exception erro){
			  MyIO.println(erro.getMessage());
		    }
		    break;
 
		 case "RF":
		    try
		    {
			  pessoa = lista.removerFim();
			  MyIO.println("(R) " + pessoa.getNome());
		    }catch(Exception erro){
			  MyIO.println(erro.getMessage());
		    }
		    break;
 
		 case "R*":
		    try
		    {
			  pessoa = lista.remover(posicao);
			  MyIO.println("(R) " + pessoa.getNome());
		    }catch(Exception erro){
			  MyIO.println(erro.getMessage());
		    }
		    break;
 
		 default:
		    MyIO.println("ERRO!");
		    break;
	   }
 	}
 
    lista.mostrar(); 
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
	Arq.openRead(nomearq, "ISO-8859-1");// "UTF8");
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

  public void imprimir()
  {
    MyIO.println(this.id + " ## " + this.nome  + " ## " + this.nacionalidade + " ## " +
                  this.dataNasc + " ## " + this.localNasc + " ## " + this.dataMorte + " ## " +
                  this.localMorte + " ## " + this.idade);
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
 * Classe Celula 
 * @author Max do Val Machado.
 * @version 2 01/2015
 *****************************/
class Celula 
{
  public Pessoa elemento; // Elemento inserido na celula.
  public Celula prox; // Aponta a celula prox.
 
 
  /***********************
   * Construtor da classe.
   ***********************/
  public Celula()
  {
	this(null);
  }
 
  /********************************************
   * Construtor da classe.
   * @param elemento Pessoa inserido na celula.
   ********************************************/
  public Celula(Pessoa elemento) 
  {
	this.elemento = elemento;
	this.prox = null;
  }
}

/**
 * Lista dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista 
{
  private Celula primeiro;
  private Celula ultimo;
 
 
  /****************************************************************************
   * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
   ****************************************************************************/
  public Lista() 
  {
	primeiro = new Celula();
	ultimo = primeiro;
  }
 
 
  /**************************************************
   * Insere um elemento na primeira posicao da lista.
   * @param x int elemento a ser inserido.
   **************************************************/
  public void inserirInicio(Pessoa x)
  {
	Celula tmp = new Celula(x);
	tmp.prox = primeiro.prox;
	primeiro.prox = tmp;

	if(primeiro == ultimo) ultimo = tmp;
	
	tmp = null;
  }
 
 
  /************************************************
   * Insere um elemento na ultima posicao da lista.
   * @param x int elemento a ser inserido.
   ************************************************/
  public void inserirFim(Pessoa x) 
  {
	ultimo.prox = new Celula(x);
	ultimo = ultimo.prox;
  }
 
 
  /******************************************************
   * Remove um elemento da primeira posicao da lista.
   * @return resp int elemento a ser removido.
   * @throws Exception Se a lista nao contiver elementos.
   ******************************************************/
  public Pessoa removerInicio() throws Exception 
  {
	if (primeiro == ultimo) throw new Exception("Erro ao remover (vazia)!");
 
	Celula tmp = primeiro;
	primeiro = primeiro.prox;
	Pessoa resp = primeiro.elemento;
	tmp.prox = null;
	tmp = null;
	return resp;
  }
 
 
  /******************************************************
   * Remove um elemento da ultima posicao da lista.
   * @return resp int elemento a ser removido.
   * @throws Exception Se a lista nao contiver elementos.
   ******************************************************/
  public Pessoa removerFim() throws Exception 
  {
	if (primeiro == ultimo) throw new Exception("Erro ao remover (vazia)!");
 
	// Caminhar ate a penultima celula:
	Celula i;
	for(i = primeiro; i.prox != ultimo; i = i.prox);
 
	Pessoa resp = ultimo.elemento; 
	ultimo = i; 
	i = ultimo.prox = null;
       
	return resp;
  }
 
 
  /*****************************************************************
   * Insere um elemento em uma posicao especifica considerando que o 
   * primeiro elemento valido esta na posicao 0.
   * @param x int elemento a ser inserido.
   * @param pos int posicao da insercao.
   * @throws Exception Se <code>posicao</code> invalida.
   *****************************************************************/
  public void inserir(Pessoa x, int pos) throws Exception 
  {
	int tamanho = tamanho();
 
	if(pos < 0 || pos > tamanho)
	   throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
	else if (pos == 0)
 	   inserirInicio(x);
	else if (pos == tamanho)
	   inserirFim(x);
	else{
	   // Caminhar ate a posicao anterior a insercao
	   Celula i = primeiro;
	   for(int j = 0; j < pos; j++, i = i.prox);
         
	   Celula tmp = new Celula(x);
	   tmp.prox = i.prox;
	   i.prox = tmp;
	   tmp = i = null;
	}
  }
 
 
  /****************************************************************
   * Remove um elemento de uma posicao especifica da lista
   * considerando que o primeiro elemento valido esta na posicao 0.
   * @param posicao Meio da remocao.
   * @return resp int elemento a ser removido.
   * @throws Exception Se <code>posicao</code> invalida.
   ****************************************************************/
  public Pessoa remover(int pos) throws Exception 
  {
	Pessoa resp;
	int tamanho = tamanho();
 
	if (primeiro == ultimo)
	   throw new Exception("Erro ao remover (vazia)!"); 
	else if(pos < 0 || pos >= tamanho)
	   throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
	else if (pos == 0)
	   resp = removerInicio();
	else if (pos == tamanho - 1)
	   resp = removerFim();
	else{
	   //Caminhar ate a posicao anterior a insercao
	   Celula i = primeiro;
	   for(int j = 0; j < pos; j++, i = i.prox);
         
	   Celula tmp = i.prox;
	   resp = tmp.elemento;
	   i.prox = tmp.prox;
	   tmp.prox = null;
	   i = tmp = null;
	}
 
	return resp;
  }
 
  /*****************************************************
   * Mostra os elementos da lista separados por espacos.
   *****************************************************/
  public void mostrar() 
  {
	for (Celula i = primeiro.prox; i != null; i = i.prox) i.elemento.imprimir();
  }
 
  /**
   * Procura um elemento e retorna se ele existe.
   * @param x Elemento a pesquisar.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
  public boolean pesquisar(Pessoa x) {
	boolean resp = false;
	for (Celula i = primeiro.prox; i != null; i = i.prox)
	{
	   if(i.elemento.getID() == x.getID())
	   {
		 resp = true;
		 i = ultimo;
	   }
	}
	return resp;
  }
 
  /****************************************************************
   * Calcula e retorna o tamanho, em numero de elementos, da lista.
   * @return resp int tamanho
   ****************************************************************/
  public int tamanho() 
  {
	int tamanho = 0; 
	for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
	return tamanho;
  }
}
