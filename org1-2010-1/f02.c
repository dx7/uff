#include <stdio.h>

int main ()
{
	float x=0.01;
	x=x*100.0;

  printf("%.20f\n", x);

	if (x == 1.0)
   	printf ("Iguais \n");
	else 
   	printf ("Não iguais \n");

	return(0);
}