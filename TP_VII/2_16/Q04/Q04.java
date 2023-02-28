  /**********************************
    * Q04
    * @author Maguirrichard Oliveira.
    * @version 1 02/2016.
    *********************************/
class Q04
{
  public static void main(String[] args)
  {
	Pessoa pessoa = new Pessoa();
	Alvinegra tree = new Alvinegra();
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
  public boolean cor; 
 
 
  /***********************
   * Construtor da classe.
   ***********************/
  public No(Pessoa elemento)
  {
	this(elemento,null,null,false);
  }

  /***********************
   * Construtor da classe.
   ***********************/
  public No(Pessoa elemento, boolean cor)
  {
	this(elemento,null,null,cor);
  }
 
  /********************************************
   * Construtor da classe.
   * @param elemento Pessoa inserido na celula.
   * @param esq No da esquerda.
   * @param dir No da direita.
   ********************************************/
  public No(Pessoa elemento, No esq, No dir, boolean cor) 
  {
	this.elemento = elemento;
	this.esq = esq;
	this.dir = dir;
	this.cor = cor;
  }
}

  /******************************
    * Arvore binaria de pesquisa.
    * @author Max do Val Machado.
    *****************************/
class Alvinegra
{
  private No raiz; // Raiz da arvore.
 
  /***********************
   * Construtor da classe.
   ***********************/
  public Alvinegra() 
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
	//Se a arvore tiver tres ou mais elementos
	if(raiz != null && raiz.esq != null && raiz.dir != null)
        //"Arvore com tres ou mais elementos..."
	   inserir(x, null, null, null, raiz);
       
	//Senao, se a arvore estiver vazia
	else if(raiz == null) raiz = new No(x, false);
	//"Antes, zero elementos. Agora, raiz(" + raiz.elemento + ")."
 
	//Senao, se a arvore tiver um elemento 
	else if(raiz.esq == null && raiz.dir == null){

	   if(raiz.elemento.getID() > x.getID()) raiz.esq = new No(x, true);
	   //"Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento +").")
	   else raiz.dir = new No(x, true);
	   //"Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento +").");
 
      //Senao, se a arvore tiver dois elementos (raiz e dir)
	}else if (raiz.esq == null){

	   if(raiz.elemento.getID() > x.getID())  raiz.esq = new No(x);
//"Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").")
 
	   else if (raiz.dir.elemento.getID() > x.getID()){
            
		 raiz.esq = new No(raiz.elemento);
		 raiz.elemento = x;
//"Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").")
 
	   }else{

		 raiz.esq = new No(raiz.elemento);
		 raiz.elemento = raiz.dir.elemento;
		 raiz.dir.elemento = x;
//"Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").")
	   }
 
	   raiz.esq.cor = raiz.dir.cor = false;
          
	//Senao, se a arvore tiver dois elementos (raiz e esq)
	}else if (raiz.dir == null){
          
	   if(raiz.elemento.getID() < x.getID()) raiz.dir = new No(x);
//"Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").")
	   else if (raiz.esq.elemento.getID() < x.getID()){
		 raiz.dir = new No(raiz.elemento);
		 raiz.elemento = x;
//"Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").")
	   }else{
		 raiz.dir = new No(raiz.elemento);
		 raiz.elemento = raiz.esq.elemento;
		 raiz.esq.elemento = x;
//"Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento +") e dir(" + raiz.dir.elemento +").")
	   }
	   raiz.esq.cor = raiz.dir.cor = false;
      }else throw new Exception("Erro ao inserir!");
 
      raiz.cor = false;
  }
 
  /*************************************************
   * Metodo privado recursivo para inserir elemento.
   * @param elemento Elemento a ser inserido.
   * @param avo No em analise.
   * @param pai No em analise.
   * @param i No em analise.
   * @throws Exception Se o elemento existir.
   *************************************************/
  private void inserir(Pessoa x, No bisavo, No avo, No pai, No i) throws Exception 
  {
	if (i == null) 
	{
	   if(x.getID() < pai.elemento.getID()) i = pai.esq = new No(x, true);
        else i = pai.dir = new No(x, true);
 
	   if(pai.cor == true) balancear(bisavo, avo, pai, i);

	}else{
 	   //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
	   if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true)
	   {
		 i.cor = true;
		 i.esq.cor = i.dir.cor = false;
		 if(i == raiz) i.cor = false;
		 else if(pai.cor == true) balancear(bisavo, avo, pai, i);
	   }

	   if(x.getID() < i.elemento.getID()) inserir(x, avo, pai, i, i.esq);
	   else if (x.getID() > i.elemento.getID()) inserir(x, avo, pai, i, i.dir);
	   else throw new Exception("Erro inserir (elemento repetido)!");
	}
  }

  private void balancear(No bisavo, No avo, No pai, No i)
  {
	//Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
	if(pai.cor == true)
	{
	   //4 tipos de reequilibrios e acoplamento
	   if(pai.elemento.getID() > avo.elemento.getID())
	   { // rotacao a esquerda ou direita-esquerda
 		 if(i.elemento.getID() > pai.elemento.getID()) avo = rotacaoEsq(avo);
		 else avo = rotacaoDirEsq(avo);
 
	   }else{ // rotacao a direita ou esquerda-direita
		 if(i.elemento.getID() < pai.elemento.getID()) avo = rotacaoDir(avo);
		 else avo = rotacaoEsqDir(avo);
	   }
 
	   if (bisavo == null) raiz = avo;
	   else{
		 if(avo.elemento.getID() < bisavo.elemento.getID()) bisavo.esq = avo;
		 else bisavo.dir = avo;
	   }
 
	   //reestabelecer as cores apos a rotacao
	   avo.cor = false;
	   avo.esq.cor = avo.dir.cor = true;
//"Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir(" + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)")
	} //if(pai.cor == true)
  }

  private No rotacaoDir(No no) 
  {
	//System.out.println("Rotacao DIR(" + no.elemento + ")");
	No noEsq = no.esq;
	No noEsqDir = noEsq.dir;
 
	noEsq.dir = no;
	no.esq = noEsqDir;
 
	return noEsq;
  }
 
  private No rotacaoEsq(No no)
  {
	//System.out.println("Rotacao ESQ(" + no.elemento + ")");
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
