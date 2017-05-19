#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *gets(char *s) {
  int c;
  char *dest = s;
  while ((c = getchar()) != '\n' &&  c != EOF) {
    *dest++ = c;
  }
  if (c == EOF && dest == s) {
    return NULL;
  }
  *dest++ = '\0';
  return s;
}

char *get_line() {
  char buf[4];
  char *result;
  gets(buf);
  result = malloc(strlen(buf));
  strcpy(result, buf);
  return result;
}

int main() {
  char *res = get_line();
  printf("%s\n", res);

  return 0;
}
