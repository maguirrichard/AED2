  /**********************************
    * Q11
    * @author Maguirrichard Oliveira.
    * @version 1 02/2016.
    *********************************/
class Q11
{
   public static void main(String[] args)
   {
      Pessoa pessoa;
      Lista lista = new Lista(100);
      String str = MyIO.readLine();
      int id = 0, help = 0;
   
      while(!str.equals("FIM"))
      {
         pessoa = new Pessoa();
         pessoa.criarPessoa(str);
         try
         {
            lista.inserirFim(pessoa);
            help++;
         }
         catch(Exception erro){
            MyIO.println(erro.getMessage());
         }
         str = MyIO.readLine();
      }
   
      lista.ordenarMergesort(help);
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
class Lista 
{
   private Pessoa[] array;
   private int n;
 
 
  /**********************
   * Construtor da classe.
   **********************/
   public Lista () 
   {
      this(6);
   }
 
 
  /*********************************
   * Construtor da classe.
   * @param tamanho Tamanho da lista.
   *********************************/
   public Lista (int tamanho)
   {
      array = new Pessoa[tamanho];
      n = 0;
   }
 
 
  /*****************************************************************
   * Insere um elemento na primeira posicao da lista e move os demais
   * elementos para o fim da lista.
   * @param x int elemento a ser inserido.
   * @throws Exception Se a lista estiver cheia.
   *****************************************************************/
   public void inserirInicio(Pessoa x) throws Exception 
   {
   //validar insercao
      if(n >= array.length)
         throw new Exception("Erro ao inserir!");
   
   //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         array[i] = array[i-1];
      }
   
      array[0] = x;
      n++;
   }
 
 
  /***********************************************
   * Insere um elemento na ultima posicao da lista.
   * @param x int elemento a ser inserido.
   * @throws Exception Se a lista estiver cheia.
   ***********************************************/
   public void inserirFim(Pessoa x) throws Exception 
   {
   //validar insercao
      if(n >= array.length)
         throw new Exception("Erro ao inserir!");
   
   
      array[n] = x;
      n++;
   }
 
 
  /******************************************************************
   * Insere um elemento em uma posicao especifica e move os demais
   * elementos para o fim da lista.
   * @param x int elemento a ser inserido.
   * @param pos Posicao de insercao.
   * @throws Exception Se a lista estiver cheia ou a posicao invalida.
   ******************************************************************/
   public void inserir(Pessoa x, int pos) throws Exception 
   {
   //validar insercao
      if(n >= array.length || pos < 0 || pos > n)
         throw new Exception("Erro ao inserir!");
   
   //levar elementos para o fim do array
      for(int i = n; i > pos; i--)
         array[i] = array[i-1];
   
      array[pos] = x;
      n++;
   }
 
 
  /************************************************************
   * Remove um elemento da primeira posicao da lista e movimenta 
   * os demais elementos para o inicio da mesma.
   * @return resp int elemento a ser removido.
   * @throws Exception Se a lista estiver vazia.
   ************************************************************/
   public Pessoa removerInicio() throws Exception 
   {
   //validar remocao
      if (n == 0)
         throw new Exception("Erro ao remover!");
   
      Pessoa resp = array[0];
      n--;
   
      for(int i = 0; i < n; i++)
         array[i] = array[i+1];
   
      return resp;
   }
 
 
  /***********************************************
   * Remove um elemento da ultima posicao da lista.
   * @return resp int elemento a ser removido.
   * @throws Exception Se a lista estiver vazia.
   ***********************************************/
   public Pessoa removerFim() throws Exception 
   {
   //validar remocao
      if (n == 0)
         throw new Exception("Erro ao remover!");
   
      return array[--n];
   }
 
 
  /***********************************************************************
   * Remove um elemento de uma posicao especifica da lista e 
   * movimenta os demais elementos para o inicio da mesma.
   * @param pos Posicao de remocao.
   * @return resp int elemento a ser removido.
   * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
   ***********************************************************************/
   public Pessoa remover(int pos) throws Exception 
   {
   //validar remocao
      if (n == 0 || pos < 0 || pos >= n)
         throw new Exception("Erro ao remover!");
   
      Pessoa resp = array[pos];
      n--;
   
      for(int i = pos; i < n; i++)
         array[i] = array[i+1];
   
      return resp;
   }
 
 
   /*****************************************************
    * Mostra os elementos da lista separados por espacos.
    *****************************************************/
   public void mostrar ()
   {
      for(int i = 0; i < n; i++)
         array[i].imprimir();
   }
 
 
  /***********************************************
   * Procura um elemento e retorna se ele existe.
   * @param x int elemento a ser pesquisado.
   * @return <code>true</code> se o array existir,
   * <code>false</code> em caso contrario.
   ***********************************************/
   public String pesquisar(int fim, int id) 
   {
      String retorno = "NAO";
      int meio;
      int inicio = 0;
      fim = fim-1;
      while (inicio <= fim) 
      { //Inicio WHILE
         meio = (inicio + fim)/2;
         if(array[meio].getID() == id)
         {
            retorno = "SIM";
            break;
         }
      
         if(array[meio].getID() >= id)
            fim = meio-1;
         else
            inicio = meio+1;
      }//Fim WHILE
   
      return retorno;
   }

  /*********************************************
   * Troca o conteudo de duas posicoes do array.
   * @param i int primeira posicao.
   * @param j int segunda posicao.
   *********************************************/
   public void swap(int i, int j)
   {
      Pessoa temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

   public void ordenarMergesort(int n)
   {
   //MyIO.println(n);
      array = mergeSort(array, n);
   //MyIO.println(n);
   
   //Ordena os iguais pelo ID
      int cont = 0;
      int cont2 = 0;
      int i;
      for(i = 1; i < n; i++)
      {
         cont = i-1;
         cont2 = i-1;
      //MyIO.println(array[i-1].getDataMorte());
      //MyIO.println(array[i].getDataMorte());
         while(i < n && getDataMorte1(array[i-1], array[i]) == 0)
         {
            cont2++;
            i++;
         }
         if(cont2 != cont) ordenar(cont, cont2);
      }
   //i--;
   //MyIO.println(array[i-1].getDataMorte());
   //MyIO.println(array[i].getDataMorte());
   //array[i-1].imprimir();
   //array[i].imprimir();
   //MyIO.println(getDataMorte1(array[i-1], array[i]));
   //ordenaMerge(n);
   }

 
  /*********************************************
   * Algoritmo de ordenacao Mergesort.
   * @param int n final do array a ser ordenado.
   *********************************************/
   public Pessoa[] mergeSort(Pessoa vetor[], int n) 
   {
      if(n > 1)
      {  
         int elementsInA1 = n/2;  
         int elementsInA2 = n - elementsInA1;  
         Pessoa arr1[] = new Pessoa[elementsInA1];  
         Pessoa arr2[] = new Pessoa[elementsInA2];  
          
         for(int i = 0; i < elementsInA1; i++)  
            arr1[i] = vetor[i];  
      
         for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)  
            arr2[i - elementsInA1] = vetor[i];  
      
         int a = arr1.length;
         int b = arr2.length;
         arr1 = mergeSort(arr1, a);  
         arr2 = mergeSort(arr2, b);  
          
         int i = 0, j = 0, k = 0;  
      
         while(arr1.length != j && arr2.length != k) 
         {  
            if(getDataMorte1(arr1[j], arr2[k]) < 0) //arr1[j] <= arr2[k]
            {  
               vetor[i] = arr1[j];  
               i++;  
               j++;  
            }
            else{  
               vetor[i] = arr2[k];  
               i++;  
               k++;  
            }  
         }  
      
         while(arr1.length != j)
         {  
            vetor[i] = arr1[j];  
            i++;  
            j++;  
         }  
         while(arr2.length != k) 
         {  
            vetor[i] = arr2[k];  
            i++;  
            k++;  
         }  
      }
   
      return vetor;  
   
   }

  public int getDataMorte1(Pessoa a, Pessoa b)
  {
	int x = a.getDataMorte().compareTo(b.getDataMorte());
   
	//x < 0 caso primeiro maior que segundo
	//x == 0 caso sejam iguais
	//x > 0 caso segundo maior que primeiro
   
	return x;
  }

   public void ordenar(int inicio, int fim)
   {
      Pessoa aux;
      for(int i = inicio; i < fim; i++)
      {
         for(int j = i+1; j <= fim; j++)
         {
            if(array[i].getID() > array[j].getID())
            {
               aux = array[j];
               array[j] = array[i];
               array[i] = aux;
            }
         }
      }
   }
   public void ordenaMerge(int counter){
      for (int i = 0; i < counter; i++){
         for (int j = 1; j < counter; j++){
            if(array[i].getDataMorte().compareTo(array[j].getDataMorte()) == 0){
               if (array[i].getID() > array[j].getID()){
                  swap(i, j);
               } 
               else {
                  swap(j,i);
               }
            } 
         }	
      }
   }
}
