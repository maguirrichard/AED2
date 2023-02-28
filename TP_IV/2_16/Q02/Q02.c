#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
/* Declaração de variáveis */
   double doub;
   int i = 0, j = 0, qtd = 0, qtd2 = 0, qtd3 = 0;
   
/* Abre arquivo para escrita (w)*/
   FILE *arq1 = fopen("dados.txt", "w");
   
/* Inicio IF */
   if(arq1 == NULL)
   {
      printf("Erro ao abrir o arquivo");
   }else{ 
      scanf("%d", &qtd);   
   /* Inicio FOR */  
      for(i = 0; i < qtd; i++)
      { 
         scanf("%lf", &doub);
         fprintf(arq1, "%g\n", doub); 
      }/* Fim FOR */
 
   /* Fecha arquivo */
      fclose(arq1);
   }/* Fim IF */


/* Abre arquivo para leitura (r)*/
   FILE *arq2 = fopen("dados.txt", "r");

/* Inicio IF */
   if(arq2 == NULL)
   {
      printf("Erro ao abrir o arquivo");
   }else{
   qtd2 = qtd-1;
   qtd3 = qtd2;    
   /* Inicio FOR */  
      for(i = 0; i < qtd; i++)
      { 
         rewind(arq2);
      /* Inicio FOR */ 
         for(j = 0; j < qtd2; qtd2--)
         {
            fscanf(arq2, "%lf", &doub); 
         }/* Fim FOR */
         if(i != qtd-1){
            fseek(arq2, 1, SEEK_CUR);
            fscanf(arq2, "%lf", &doub);
            printf("%g\n", doub);
         }else{   
            fseek(arq2, 0, SEEK_CUR);         
            fscanf(arq2, "%lf", &doub);
            printf("%g\n", doub);
         }
         qtd2 = qtd3-(i+1);
      }/* Fim FOR */
   /* Fecha arquivo */
      fclose(arq2); 
   }/* Fim IF */   

   return 0;
}
