  /**********************************
    * Q01
    * @author Maguirrichard Oliveira.
    * @version 1 02/2016.
    *********************************/
class Q02
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
			  tree.removerPre(id);
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


     /*str = MyIO.readLine();
     while(!str.equals("FIM"))
	{
	   tree.pesquisar(Integer.parseInt(str));
        str = MyIO.readLine();
	} */
	tree.mostrarCentral();
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

/************************
 * Classe No1
 * @author Maguirrichard.
 * @version 2 01/2015
 ************************/
class No1 
{
  public No1 dir; // Aponta pra direita.
  public No1 esq; // Aponta pra esquerda.
  public No2 elemento; // Elemento No2.
  public int mes; // Inteiro mes.
 
 
  /***********************
   * Construtor da classe.
   ***********************/
  public No1(int mes)
  {
	this(null,null,null, mes);
  }
 
  /********************************************
   * Construtor da classe.
   * @param elemento Pessoa inserido na celula.
   * @param esq No da esquerda.
   * @param dir No da direita.
   ********************************************/
  public No1(No2 elemento, No1 esq, No1 dir, int mes) 
  {
	this.elemento = elemento;
	this.esq = esq;
	this.dir = dir;
	this.mes = mes;
  }
}

/************************
 * Classe No2
 * @author Maguirrichard.
 * @version 2 01/2015
 ************************/
class No2 
{
  public Pessoa elemento; // Elemento inserido na celula.
  public No2 dir; // Aponta pra direita.
  public No2 esq; // Aponta pra esquerda.
 
 
  /***********************
   * Construtor da classe.
   ***********************/
  public No2(Pessoa elemento)
  {
	this(elemento,null,null);
  }
 
  /********************************************
   * Construtor da classe.
   * @param elemento Pessoa inserido na celula.
   * @param esq No da esquerda.
   * @param dir No da direita.
   ********************************************/
  public No2(Pessoa elemento, No2 esq, No2 dir) 
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
  private No1 raiz; // Raiz da arvore.
 
  /***********************
   * Construtor da classe.
   ***********************/
  public Arvore() 
  {
	raiz = inserirComeco(raiz);
  }
 
  private No1 inserirComeco(No1 raiz)
  {
	raiz = inserirComeco(raiz, 6);
	raiz = inserirComeco(raiz, 2);
	raiz = inserirComeco(raiz, 9);
	raiz = inserirComeco(raiz, 4);
	raiz = inserirComeco(raiz, 11);
	raiz = inserirComeco(raiz, 0);
	raiz = inserirComeco(raiz, 1);
	raiz = inserirComeco(raiz, 3);
	raiz = inserirComeco(raiz, 5);
	raiz = inserirComeco(raiz, 7);
	raiz = inserirComeco(raiz, 8);
	raiz = inserirComeco(raiz, 10);
	raiz = inserirComeco(raiz, 12);
	return raiz;
  }

  private No1 inserirComeco(No1 i, int x)  
  {
	if (i == null) i = new No1(x);
 
	else if (x < i.mes) i.esq = inserirComeco(i.esq, x);
 
	else if (x > i.mes) i.dir = inserirComeco(i.dir, x);
 
	return i;
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
  private void mostrarCentral(No1 i) 
  {
	if (i != null) 
	{
	   mostrarCentral(i.esq); // Elementos da direita.
	   mostrarCentral(i.elemento); // Conteudo do no.
	   mostrarCentral(i.dir); // Elementos da direita.
	} 
  }

  /*************************************************
   * Metodo privado recursivo para exibir elementos.
   * @param i No em analise.
   *************************************************/
  private void mostrarCentral(No2 i) 
  {
	if (i != null) 
	{
	   mostrarCentral(i.esq); // Elementos da direita.
	   i.elemento.imprimir(); // Conteudo do no.
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
  private void mostrarPre(No1 i) 
  {
	if (i != null) 
	{
	   System.out.print(i.mes + " "); // Conteudo do no.
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
  private void mostrarPos(No1 i)
  {
	if (i != null)
	{
	   mostrarPos(i.esq); // Elementos da direita.	   
	   mostrarPos(i.dir); // Elementos da direita.
	   System.out.print(i.mes + " "); // Conteudo do no.
	}
  }
 
 
  /*************************************************
   * Metodo publico iterativo para inserir elemento.
   * @param x Elemento a ser inserido.
   * @throws Exception Se o elemento existir.
   *************************************************/
  public void inserir(Pessoa x) throws Exception
  {
	this.raiz = inserir(x, this.raiz);
  }
 
  /*************************************************
   * Metodo privado recursivo para inserir elemento.
   * @param x Elemento a ser inserido.
   * @param i No em analise.
   * @return No em analise, alterado ou nao.
   * @throws Exception Se o elemento existir.
   *************************************************/
  private No1 inserir(Pessoa x, No1 i) throws Exception 
  {
	if (i == null) throw new Exception("Erro ao inserir!");
 
	else if (getMes(x) < i.mes) i.esq = inserir(x, i.esq);
 
	else if (getMes(x) > i.mes) i.dir = inserir(x, i.dir);
 
	else i.elemento = inserirE(x, i.elemento);
 
	return i;
  }

  private int getMes(Pessoa x)
  {
	int mes = 0;
	if(!x.getDataNasc().contains("ca."))
	{
	   String vetor[] = x.getDataNasc().split(" ");
	   mes = parseMes(vetor[2]);
	}
 
    return (mes);
  }

  public int parseMes(String data)
  {
	int resp = 0;
	if(data.equals("janeiro")){
	   resp = 1;
	}else if(data.equals("fevereiro")){
	   resp = 2;
	}else if(data.equals("março")){
	   resp = 3;
	}else if(data.equals("abril")){
	   resp = 4;
	}else if(data.equals("maio")){
	   resp = 5;
	}else if(data.equals("junho")){
	   resp = 6;
	}else if(data.equals("julho")){
	   resp = 7;
	}else if(data.equals("agosto")){
	   resp = 8;
	}else if(data.equals("setembro")){
	   resp = 9;
	}else if(data.equals("outubro")){
	   resp = 10;
	}else if(data.equals("novembro")){
	   resp = 11;
	}else if(data.equals("dezembro")){
	   resp = 12;
	}
      return resp;
  }

  public No2 inserirE(Pessoa x, No2 raiz) throws Exception
  {
	raiz = inserirE(raiz, x);
	return raiz;
  }

  private No2 inserirE(No2 i, Pessoa x) throws Exception 
  {
	if (i == null) i = new No2(x);
 
	else if (x.getID() < i.elemento.getID()) i.esq = inserirE(i.esq, x);
 
	else if (x.getID() > i.elemento.getID()) i.dir = inserirE(i.dir, x);
 
	else throw new Exception("Erro ao inserir!");
 
	return i;
  }

  public void removerPre(int id)
  {
	removerPre(raiz, id);
  }
 
  private void removerPre(No1 i, int id) 
  {
	if (i != null) 
	{
	   try
	   {
		 i.elemento = remover(id, i.elemento);
	   }catch(Exception erro){}
	   removerPre(i.esq, id); // Elementos da direita.	
	   removerPre(i.dir, id); // Elementos da esquerda.
	}
 }

  /*************************************************
   * Metodo privado recursivo para remover elemento.
   * @param x Elemento a ser removido.
   * @param i No em analise.
   * @return No em analise, alterado ou nao.
   * @throws Exception Se nao encontrar elemento.
   *************************************************/
  private No2 remover(int x, No2 i) throws Exception
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
  private No2 antecessor(No2 i, No2 j) 
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
  public void pesquisar(int id) 
  {
	pesquisar(raiz, id);
  }
 
  /*************************************************
   * Metodo privado recursivo para exibir elementos.
   * @param i No em analise.
   *************************************************/
  private void pesquisar(No1 i, int id) 
  {
	if (i != null) 
	{
	   String aux = "NAO";
	   MyIO.print("raiz ");
	   aux = pesquisar(i.elemento, id); // Conteudo do no.
	   if(aux.contains("NAO")
	   {
		 pesquisar(i.esq); // Elementos da direita.
		 pesquisar(i.dir); // Elementos da direita.
	   }
	} 
  }

  /*************************************************
   * Metodo privado recursivo para exibir elementos.
   * @param i No em analise.
   *************************************************/
  private String pesquisar(No2 i, int id) 
  {
	String resp = "NAO";
	if (i == null) 
	   resp = "NAO";
	else if (x == i.elemento.getID()) 
	   resp = "SIM"; 
	else if (x < i.elemento.getID()){
 	   MyIO.print("esq ");
	   resp = pesquisar(x, i.esq);
	}else{  
	   MyIO.print("dir ");
	   resp = pesquisar(x, i.dir);
	}
 
	return resp;
  }
}
