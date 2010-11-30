#include <stdio.h>
#include <stdlib.h>

typedef struct node *node;
struct node {
  int data;
  struct node *left;
  struct node *right;
} ;

node make_node ( int data )
{
  node rn = malloc ( sizeof *rn );

  if ( rn != NULL ) {
    rn->data = data;
    rn->left = rn->right = NULL;
  }

  return rn;
}

node insert ( node tree, int data )
{
  if ( tree == NULL )
    tree = make_node ( data );
  else if ( data < tree->data )
    tree->left = insert ( tree->left, data );
  else
    tree->right = insert ( tree->right, data );

  return tree;
}

node rotR(node h)
{
   node x = h->left;
   h->left = x->right;
   x->right = h;
   return x;
}

node rotL(node h)
{
   node x = h->right;
   h->right = x->left;
   x->left = h;
   return x;
}

int count(node h) {
  if (h == NULL) return 0;
  return count(h->left) + count(h->right) + 1;
}

node searchR(node h, int v) {
    int t;
    if (h == NULL) return NULL;
    t = h->data;
    if (v == t) return h;
    if (v < t)
       return searchR(h->left, v);
    else
       return searchR(h->right, v);
}

void printnode(char c[], int b) {
    int i;
    for (i = 0; i < b; i++) printf("   ");
    printf("%s\n", c);
}

void show(node x, int b) {
    char cc[] = "bizarro!";

    if (x == NULL) {
        printnode(" ", b);
        return;
    }

    sprintf(cc, "%i", x->data);

    show(x->right, b+1);
    printnode(cc, b);
    show(x->left, b+1);
}

int main() {
  node h = NULL;

  h = insert(h, 10);
  h = insert(h, 11);
  h = insert(h, 9);
  h = insert(h, 2);
  h = insert(h, 1);
  h = insert(h, 12);
  h = insert(h, 3);
  h = insert(h, 4);

  show(h, 2);
  printf("Qtd de nós: %d\n", count(h));
}
