class teste
{
  public static void main(String[] args)
  {
	compareData("28 de fevereiro de 1901", "28 de abril de 1999");
	
  }

  public static void compareNome(String j, String tmp)
  {
	int x = j.compareTo(tmp);

	//x < 0 caso primeiro venha antes do segundo
	//x == 0 caso sejam iguais
	//x > 0 caso segundo venha antes do primeiro

	MyIO.println(x);
  }

  public static void compareData(String a, String b)
  {
	String arraya[] = a.split(" ");
	String arrayb[] = b.split(" ");
		
	
	int x = arraya[0].compareTo(arrayb[0]);

	//x < 0 caso primeiro venha antes do segundo
	//x == 0 caso sejam iguais
	//x > 0 caso segundo venha antes do primeiro

	MyIO.println(x);
  }


}

