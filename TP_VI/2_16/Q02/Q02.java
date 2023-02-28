  /**********************************
    * Q02
    * @author Maguirrichard Oliveira.
    * @version 1 02/2016.
    *********************************/
class Q02
{
  public static void main(String[] args)
  {
	Pessoa pessoa = new Pessoa();
	Pilha pilha = new Pilha();
     String str = MyIO.readLine();
	int contador;

     while(!str.equals("FIM"))
	{
	   pessoa = new Pessoa();
        pessoa.criarPessoa(str);
	   try
	   {
		 pilha.inserir(pessoa);
	   }catch(Exception erro){
		 MyIO.println(erro.getMessage());
	   }
        str = MyIO.readLine();
	}

	//pilha.mostrar();
 
	contador = MyIO.readInt();
     
	for(int i = 0; i < contador; i++)
	{
	   str = MyIO.readLine();
	   String dados = "", operacao = str.substring(0, 1), tmp = "";
	   int posicao = 0;
 
	   if(operacao.contains("I"))
		 dados = str.substring(2, (str.length()));
 
	   tmp = "";
	   operacao = operacao.trim();
	   switch (operacao)
	   {
		 case "I":
		    pessoa = new Pessoa();
		    //MyIO.println(dados);
		    pessoa.parsePessoa(dados.trim());
		    try
		    {
			  pilha.inserir(pessoa);
            }catch(Exception erro){
			  MyIO.println(erro.getMessage());
            }
            break;
 
		 case "R":
		    try
		    {
			  pessoa = pilha.remover();
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
 
    pilha.mostrarRec(); 
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
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Pilha 
{
  private Celula topo;
 
 
  /****************************************************************************
   * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
   ****************************************************************************/
  public Pilha() 
  {
	topo = null;
  }
 
 
  /*****************************************************************
   * Insere um elemento em uma posicao especifica considerando que o 
   * primeiro elemento valido esta na posicao 0.
   * @param x int elemento a ser inserido.
   * @param pos int posicao da insercao.
   * @throws Exception Se <code>posicao</code> invalida.
   *****************************************************************/
  public void inserir(Pessoa x) throws Exception 
  {
	Celula tmp = new Celula(x);
	tmp.prox = topo;
	topo = tmp;
	tmp = null;
  }
  
  /****************************************************************
   * Remove um elemento de uma posicao especifica da lista
   * considerando que o primeiro elemento valido esta na posicao 0.
   * @param posicao Meio da remocao.
   * @return resp int elemento a ser removido.
   * @throws Exception Se <code>posicao</code> invalida.
   ****************************************************************/
  public Pessoa remover() throws Exception 
  {

	if (topo == null) throw new Exception("Erro ao remover!");
 
	Pessoa resp = topo.elemento;
	Celula tmp = topo;
	topo = topo.prox;
	tmp.prox = null;
	tmp = null;
	return resp;
  }
 
  /*****************************************************
   * Mostra os elementos da lista separados por espacos.
   *****************************************************/
  public void mostrar() 
  {
	for (Celula i = topo; i != null; i = i.prox) i.elemento.imprimir();
  }

  /*****************************************************
   * Mostra os elementos da lista separados por espacos.
   *****************************************************/
  public void mostrarRec() 
  {
	mostrarRec(topo);
  }

  /*****************************************************
   * Mostra os elementos da lista separados por espacos.
   *****************************************************/
  public void mostrarRec(Celula i) 
  {
	if(i != null)
	{
	   mostrarRec(i.prox);
	   i.elemento.imprimir();
	}
  }
 
  /**
   * Procura um elemento e retorna se ele existe.
   * @param x Elemento a pesquisar.
   * @return <code>true</code> se o elemento existir,
   * <code>false</code> em caso contrario.
   */
  public boolean pesquisar(Pessoa x) {
	boolean resp = false;
	for (Celula i = topo.prox; i != null; i = i.prox)
	{
	   if(i.elemento.getID() == x.getID())
	   {
		 resp = true;
		 i = null;
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
	for(Celula i = topo; i.prox != null; i = i.prox, tamanho++);
	return tamanho;
  }
}
