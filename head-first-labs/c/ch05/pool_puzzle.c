#include <stdio.h>

struct fish {
  const char *name;
  const char *species;
  int teeth;
  int age;
};

/* Print out the catalog entry */
void catalog(struct fish f) {
  printf("%s is a %s with %i teeth. He is %i\n", f.name, f.species, f.teeth, f.age);
}

/* Print the label for the tank */
void label(struct fish f) {
  printf("Name:%s\n", f.name);
  printf("Species:%s\n", f.species);
  printf("%d years old, %d teeth\n", f.age, f.teeth);
}

int main() {
  struct fish snappy = {"Snappy", "Piranha", 69, 4};
  catalog(snappy);
  label(snappy);
  return 0;
}
