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
	Arvore tree = new Arvore();
     String str = MyIO.readLine();
	int contador;

     while(!str.equals("FIM"))
	{
	   pessoa = new Pessoa();
        pessoa.criarPessoa(str);
	   try
	   {
		 tree.inserir(pessoa);
	   }catch(Exception erro){
		 MyIO.println(erro.getMessage());
	   }
        str = MyIO.readLine();
	}
 
	contador = MyIO.readInt();
     
	for(int i = 0; i < contador; i++)
	{
	   str = MyIO.readLine();
	   String dados = "", operacao = str.substring(0, 1);
	   int id = 0;
 
	   if(operacao.contains("I"))
		 dados = str.substring(2, (str.length()));
	   else
		 id = Integer.parseInt(str.substring(2, str.length()));

	   operacao = operacao.trim();
	   switch (operacao)
	   {
		 case "I":
		    pessoa = new Pessoa();
		    pessoa.parsePessoa(dados.trim());
		    try
		    {
			   tree.inserir(pessoa);
		    }catch(Exception erro){
			   MyIO.println(erro.getMessage());
		    }		    
              break;
 
		 case "R":
		    try
		    {
			  tree.remover(id);
			  //MyIO.println("(R) " + pessoa.getNome());
		    }catch(Exception erro){
			  //MyIO.println(erro.getMessage());
		    }
		    break;
 
		 default:
		    MyIO.println("ERRO!");
		    break;
	   }
 	}
 
    //tree.mostrarCentral();

     str = MyIO.readLine();
     while(!str.equals("FIM"))
	{
	   tree.pesquisar(Integer.parseInt(str));
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
class No 
{
  public Pessoa elemento; // Elemento inserido na celula.
  public No dir; // Aponta pra direita.
  public No esq; // Aponta pra esquerda.
 
 
  /***********************
   * Construtor da classe.
   ***********************/
  public No(Pessoa elemento)
  {
	this(elemento,null,null);
  }
 
  /********************************************
   * Construtor da classe.
   * @param elemento Pessoa inserido na celula.
   * @param esq No da esquerda.
   * @param dir No da direita.
   ********************************************/
  public No(Pessoa elemento, No esq, No dir) 
  {
	this.elemento = elemento;
	this.esq = esq;
	this.dir = dir;
  }
}

  /******************************
    * Arvore binaria de pesquisa.
    * @author Max do Val Machado.
    *****************************/
class Arvore
{
  private No raiz; // Raiz da arvore.
 
  /***********************
   * Construtor da classe.
   ***********************/
  public Arvore() 
  {
	raiz = null;
  }
 
  /*************************************************
   * Metodo publico iterativo para exibir elementos.
   *************************************************/
  public void mostrarCentral() 
  {
	mostrarCentral(raiz);
  }
 
  /*************************************************
   * Metodo privado recursivo para exibir elementos.
   * @param i No em analise.
   *************************************************/
  private void mostrarCentral(No i) 
  {
	if (i != null) 
	{
	   mostrarCentral(i.esq); // Elementos da direita.
	   System.out.print(i.elemento + " "); // Conteudo do no.
	   mostrarCentral(i.dir); // Elementos da direita.
	} 
 }
 
  /*************************************************
   * Metodo publico iterativo para exibir elementos.
   *************************************************/
  public void mostrarPre()
  {
	mostrarPre(raiz);
  }
 
  /*************************************************
   * Metodo privado recursivo para exibir elementos.
   * @param i No em analise.
   *************************************************/
  private void mostrarPre(No i) 
  {
	if (i != null) 
	{
	   System.out.print(i.elemento + " "); // Conteudo do no.
	   mostrarPre(i.esq); // Elementos da direita.	
	   mostrarPre(i.dir); // Elementos da esquerda.
	}
 }
 
  /*************************************************
   * Metodo publico iterativo para exibir elementos.
   *************************************************/
  public void mostrarPos() 
  {
	mostrarPos(raiz);
  }
 
  /*************************************************
   * Metodo privado recursivo para exibir elementos.
   * @param i No em analise.
   *************************************************/
  private void mostrarPos(No i)
  {
	if (i != null)
	{
	   mostrarPos(i.esq); // Elementos da direita.	   
	   mostrarPos(i.dir); // Elementos da direita.
	   System.out.print(i.elemento + " "); // Conteudo do no.
	}
  }
 
 
  /*************************************************
   * Metodo publico iterativo para inserir elemento.
   * @param x Elemento a ser inserido.
   * @throws Exception Se o elemento existir.
   *************************************************/
  public void inserir(Pessoa x) throws Exception
  {
	raiz = inserir(x, raiz);
  }
 
  /*************************************************
   * Metodo privado recursivo para inserir elemento.
   * @param x Elemento a ser inserido.
   * @param i No em analise.
   * @return No em analise, alterado ou nao.
   * @throws Exception Se o elemento existir.
   **************************************************/
  private No inserir(Pessoa x, No i) throws Exception 
  {
	if (i == null) i = new No(x);
 
	else if (x.getID() < i.elemento.getID()) i.esq = inserir(x, i.esq);
 
	else if (x.getID() > i.elemento.getID()) i.dir = inserir(x, i.dir);
 
	else throw new Exception("Erro ao inserir!");
 
	return i;
  }
 
  /*************************************************
   * Metodo publico iterativo para remover elemento.
   * @param x Elemento a ser removido.
   * @throws Exception Se nao encontrar elemento.
   *************************************************/
  public void remover(int x) throws Exception
  {
	raiz = remover(x, raiz);
  }
 
  /*************************************************
   * Metodo privado recursivo para remover elemento.
   * @param x Elemento a ser removido.
   * @param i No em analise.
   * @return No em analise, alterado ou nao.
   * @throws Exception Se nao encontrar elemento.
   *************************************************/
  private No remover(int x, No i) throws Exception
  {
	if (i == null) throw new Exception("Erro ao remover!");
 
	else if (x < i.elemento.getID()) i.esq = remover(x, i.esq);
 
	else if (x > i.elemento.getID()) i.dir = remover(x, i.dir);
 
	// Sem no a direita.
	else if (i.dir == null) i = i.esq;

	// Sem no a esquerda.
	else if (i.esq == null) i = i.dir;
 
	// No a esquerda e no a direita.
	else i.esq = antecessor(i, i.esq);
 
	return i;
  }
 
  /*************************************************
   * Metodo para trocar no removido pelo antecessor.
   * @param i No que teve o elemento removido.
   * @param j No da subarvore esquerda.
   * @return No em analise, alterado ou nao.
   *************************************************/
  private No antecessor(No i, No j) 
  {
	// Existe no a direita.
	if (j.dir != null) 
	{
	   // Caminha para direita.
	   j.dir = antecessor(i, j.dir);
 
	// Encontrou o maximo da subarvore esquerda.
	}else{
	   i.elemento = j.elemento; // Substitui i por j.
	   j = j.esq; // Substitui j por j.ESQ.
	}
	return j;
  }

  /*************************************************
   * Metodo publico iterativo para remover elemento.
   * @param x Elemento a ser removido.
   * @throws Exception Se nao encontrar elemento.
   *************************************************/
  public void pesquisar(int x) 
  {
 	MyIO.print("raiz ");
	raiz = pesquisar(x, raiz);
  }

  /*************************************************
   * Metodo privado recursivo para remover elemento.
   * @param x Elemento a ser removido.
   * @param i No em analise.
   * @return No em analise, alterado ou nao.
   * @throws Exception Se nao encontrar elemento.
   *************************************************/
  private No pesquisar(int x, No i)
  {
	if (i == null) 
	   MyIO.println("NAO");
	else if (x == i.elemento.getID()) 
	   MyIO.println("SIM"); 
	else if (x < i.elemento.getID()){
 	   MyIO.print("esq ");
	   i.esq = pesquisar(x, i.esq);
	}else{  
	   MyIO.print("dir ");
	   i.dir = pesquisar(x, i.dir);
	}
 
	return i;
  }
}
