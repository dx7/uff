#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define MAX 50

/*
 * Alunos: Cristian e Rafael Carvalho
 */

int main ()
{
	char expression[] = "93322$*4/*+";
	int r = avalia(expression);
	
	printf("expressão: %s\nresposta: %i\n", expression, r);
	
	return 0;
}

int avalia(char pos[])
{
	int top = -1, i, op1, op2, result, current;
	char stack[MAX];
	
	for(i = 0; i < strlen(pos); ++i)
	{
		if(pos[i] >= '0' && pos[i] <= '9')
		{
			current = pos[i] - '0';
			push(&stack, &top, current);
		}
		else
		{
			op2 = pop(&stack, &top);
			op1 = pop(&stack, &top);

			result = (int) eval2(op1, op2, pos[i]);

			push(&stack, &top, result);
		}
	}
	
	result = pop(&stack, &top);
	
	return result;
}

int eval2(int op1, int op2, char sinal) {
	int result;
	
	if(sinal == '+') result = op1 + op2;
	else if(sinal == '-') result = op1 - op2;
	else if(sinal == '*') result = op1 * op2;
	else if(sinal == '/') result = op1 / op2;
	else if(sinal == '$') result = pow(op1, op2);
	
	return result;
}

int pop(char *stack, int *top)
{
	if (*top < 0) return 0;
	
	int element = *(stack + *top);
	*top = *top - 1;
	
	return element;
}

int push (char *stack, int *top, int value)
{
	if (*top == MAX-1) return 0;
	
	*top = *top + 1;
	*(stack + *top) = value;

	return 1;
}

show (char *stack, int top)
{
	int i;
	
	printf("Listando a pilha...\n");
	
	for(i = 0; i <= top; ++i) printf("Posição %d ~> %c\n", i, *(stack + i));
	
	printf("Fim da listagem.\n\n");
}