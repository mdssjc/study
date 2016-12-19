#include <string.h>
#include <stdio.h>
#include <errno.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
  char *my_env[] = {"FOOD=coffee", NULL};
  /* char *my_env[] = {"FOOD=donuts", NULL}; */

  /* char *my_env[] = {"FOOD=donuts", NULL}; */

  if(execle("./coffee", "./coffee", "donuts", NULL, my_env) == -1) {
  /* if(execle("./coffee", "./coffee", "cream", NULL, my_env) == -1) { */
  /* if(execl("./coffee", "coffee", NULL) == -1) { */
  /* if(execle("./coffee", "coffee", NULL, my_env) == -1) { */
    fprintf(stderr, "Can't create order: %s\n", strerror(errno));
    return 1;
  }
  return 0;
}
