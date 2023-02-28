#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define TRUE 1
#define FALSE 0

int p = 0;

int palindromo(char palavra[1000], int i, int j)
{
    if(i >= j) return TRUE;

    if(palavra[i] == palavra[j]) return palindromo(palavra, i+1, j-1);
    else return FALSE;
}



void entradaSaidaArquivo()
{
    FILE *arquivoEntrada = fopen("pub.in", "r");
    FILE *arquivoSaida = fopen("saida", "w");

    if(arquivoEntrada == NULL) printf("Erro, nao foi possivel abrir o arquivo\n");
    if(arquivoSaida == NULL) printf("Erro, nao foi possivel criar o arquivo\n");

    char palavra[1000];

    fgets(palavra, 1000, arquivoEntrada);


    while(strcmp(palavra, "FIM\n"))
    {
        p++;
        printf("%d %s\n", p, palavra);
        if(palindromo(palavra, 0, strlen(palavra)-2)) fprintf(arquivoSaida, "%s", "SIM\n");
        else fprintf(arquivoSaida, "%s", "NAO\n");

        fgets(palavra, 1000, arquivoEntrada);
    }

    fclose(arquivoEntrada);
    fclose(arquivoSaida);
}




int main()
{
    entradaSaidaArquivo();
    return 0;
}
