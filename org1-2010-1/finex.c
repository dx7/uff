#include "stdio.h"
#include <math.h>

int main () {

	float X,Y,Y1,Z,Z1;
	
	X=77777;
	Y=7;
	Y1=1/Y;  //  1/7
	Z=X/Y;   //  77777 / 7
  Z1= X*Y1; //  77777 * 1/7
	
	printf ("Z %f Z1 %f \n", Z, Z1);
	
	if (Z==Z1)
		printf ("Z %f Z1 %f iguais \n",Z,Z1);
	else 
		printf ("Z %f Z1 %f diferentes \n",Z,Z1);
	return(0);
}