#include <stdio.h>

int main ()
{
	float x = 0.01;
	
  printf("%.20f\n", 0.01f * 100.0);
  
  double y = 0.01f * 100.0;
  
  printf("%.20f\n", y);
  printf("%.20f\n", 1.0);

	if (x*100.0 == 1.0)
   	printf ("Iguais \n");
	else 
   	printf ("Não iguais \n");

	return(0);
}