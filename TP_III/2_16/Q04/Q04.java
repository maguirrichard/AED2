  /**********************************
    * Q02
    * @author Maguirrichard Oliveira.
    * @version 1 02/2016.
    *********************************/
class Q04
{
  public static void main(String[] args)
  {
	Pessoa pessoa;
	Fila fila = new Fila(5);
     String str = MyIO.readLine();
	int contador = 0;

     while(!str.equals("FIM"))
     {
	   pessoa = new Pessoa();
        pessoa.criarPessoa(str);
        if(!fila.isCheia()){
	   try
	   {
	      fila.inserir(pessoa);
              MyIO.println(fila.fazMedia());
	   }catch(Exception erro){
	      MyIO.println(erro.getMessage());
	   }
        }else{
	   try
	   {
	      fila.remover();
	      fila.inserir(pessoa);
	      MyIO.println(fila.fazMedia());
	   }catch(Exception erro){
	      MyIO.println(erro.getMessage());
	   }
         }
        str = MyIO.readLine();
     }

	//fila.mostrar();

	contador = MyIO.readInt();
	
	for(int i = 0; i < contador; i++)
	{
	   str = MyIO.readLine();
	   String dados = "", operacao = str.substring(0, 1), tmp = "";

	   if(operacao.equals("I"))
	      dados = str.substring(2, (str.length()));

	   tmp = "";
	   operacao = operacao.trim();
	   switch (operacao)
	   {
		 case "I":
	   	    pessoa = new Pessoa();
		    //MyIO.println(dados);
		    pessoa.parsePessoa(dados.trim());
                    if(!fila.isCheia()){
	               try
	               {
	                  fila.inserir(pessoa);
                          MyIO.println(fila.fazMedia());
	               }catch(Exception erro){
	                  MyIO.println(erro.getMessage());
	               }
                    }else{
                       try
                       {
                          fila.remover();
                          fila.inserir(pessoa);
                          MyIO.println(fila.fazMedia());
                       }catch(Exception erro){
                          MyIO.println(erro.getMessage());
                       }
                    }
		    break;

		 case "R":
	   	    try
	   	    {
	      	  pessoa = fila.remover();
			  //fila.fazMedia();
	   	    }catch(Exception erro){
	      	  MyIO.println(erro.getMessage());
	   	    }
		    break;

		 default:
	   	    MyIO.println("ERRO!");
		    break;
	   }

	}

	//fila.mostrar(); 
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
	Arq.openRead(nomearq,"UTF8"); //"ISO-8859-1");
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

/**
 * Fila estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Fila {
   private Pessoa[] array;
   private int primeiro; // Remove do indice "primeiro".
   private int ultimo; // Insere no indice "ultimo".
   private int n;
 
 
   /**
    * Construtor da classe.
    */
   public Fila () {
      this(6);
   }
 
 
   /**
    * Construtor da classe.
    * @param tamanho Tamanho da fila.
    */
   public Fila (int tamanho){
      array = new Pessoa[tamanho+1];
      primeiro = ultimo = n = 0;
   }
 
 
   /**
    * Insere um elemento na ultima posicao da fila.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a fila estiver cheia.
    */
   public void inserir(Pessoa x) throws Exception {
 
      //validar insercao
      if (((ultimo + 1) % array.length) == primeiro) {
         throw new Exception("Erro ao inserir!");
      }
 
      array[ultimo] = x;
      ultimo = (ultimo + 1) % array.length;
      n++;
   }
 
 
   /**
    * Remove um elemento da primeira posicao da fila e movimenta 
    * os demais elementos para o primeiro da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a fila estiver vazia.
    */
   public Pessoa remover() throws Exception {
 
      //validar remocao
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover!");
      }
 
      Pessoa resp = array[primeiro];
      primeiro = (primeiro + 1) % array.length;
      n--;
      return resp;
   }

  public int fazMedia()
  {
	double media = 0.0;
	int resp = 0;	
	if(this.n != 0)
	{
	   for(int i = primeiro; i != ultimo; i = (i+1) % array.length)
		 media = media+array[i].getIdade();

	   media = Math.round(media/this.n);
	   resp = (int) media;

	   return resp;
     }else
	   return 0;

  }
 
 
   /**
    * Mostra os array separados por espacos.
    */
   public void mostrar(){
 
      for(int i = primeiro; i != ultimo; i = ((i + 1) % array.length)) 
         array[i].imprimir();
   }
  
 
   /**
    * Retorna um boolean indicando se a fila esta vazia
    * @return boolean indicando se a fila esta vazia
    */
   public boolean isVazia() {
      return (primeiro == ultimo); 
   }

   /**
    * Retorna um boolean indicando se a fila esta vazia
    * @return boolean indicando se a fila esta vazia
    */
   public boolean isCheia() {
      return (n == array.length-1); 
   }
}
