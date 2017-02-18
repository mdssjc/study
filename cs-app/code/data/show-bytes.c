/* $begin show-bytes */
#include <stdio.h>
/* $end show-bytes */
#include <stdlib.h>
#include <string.h>
/* $begin show-bytes */

typedef unsigned char *byte_pointer;

void show_bytes(byte_pointer start, size_t len) {
  size_t i;
  for (i = 0; i < len; i++)
    printf(" %.2x", start[i]);    //line:data:show_bytes_printf
  printf("\n");
}

void show_short(short x) {
  show_bytes((byte_pointer) &x, sizeof(short));
}

void show_long(long x) {
  show_bytes((byte_pointer) &x, sizeof(long));
}

void show_double(double x) {
  show_bytes((byte_pointer) &x, sizeof(double));
}

void show_int(int x) {
  show_bytes((byte_pointer) &x, sizeof(int)); //line:data:show_bytes_amp1
}

void show_float(float x) {
  show_bytes((byte_pointer) &x, sizeof(float)); //line:data:show_bytes_amp2
}

void show_pointer(void *x) {
  show_bytes((byte_pointer) &x, sizeof(void *)); //line:data:show_bytes_amp3
}
/* $end show-bytes */

/* $begin test-show-bytes */
void test_show_bytes(int val) {
  int ival = val;
  float fval = (float) ival;
  int *pval = &ival;
  show_int(ival);
  show_float(fval);
  show_pointer(pval);
}
/* $end test-show-bytes */

void simple_show_a() {
/* $begin simple-show-a */
  int val = 0x87654321;
  byte_pointer valp = (byte_pointer) &val;
  show_bytes(valp, 1); /* A. */
  show_bytes(valp, 2); /* B. */
  show_bytes(valp, 3); /* C. */
/* $end simple-show-a */
}

void simple_show_b() {
/* $begin simple-show-b */
  int val = 0x12345678;
  byte_pointer valp = (byte_pointer) &val;
  show_bytes(valp, 1); /* A. */
  show_bytes(valp, 2); /* B. */
  show_bytes(valp, 3); /* C. */
/* $end simple-show-b */
}

void float_eg() {
  int x = 3490593;
  float f = (float) x;
  printf("For x = %d\n", x);
  show_int(x);
  show_float(f);

  x = 3510593;
  f = (float) x;
  printf("For x = %d\n", x);
  show_int(x);
  show_float(f);

}

void string_ueg() {
/* $begin show-ustring */
  const char *s = "ABCDEF";
  show_bytes((byte_pointer) s, strlen(s));
/* $end show-ustring */
}

void string_leg() {
/* $begin show-lstring */
  const char *s = "abcdef";
  show_bytes((byte_pointer) s, strlen(s));
/* $end show-lstring */
}

void show_twocomp() {
/* $begin show-twocomp */
  short x = 12345;
  short mx = -x;

  show_bytes((byte_pointer) &x, sizeof(short));
  show_bytes((byte_pointer) &mx, sizeof(short));
/* $end show-twocomp */
}

int is_little_endian() {
  int x = 1;
  byte_pointer bytes = (byte_pointer) &x;
  return bytes[0] == 1;
}

int main(int argc, char *argv[]) {
  int val = 12345;

  if (argc > 1) {
    if (argc > 1) {
	    val = strtol(argv[1], NULL, 0);
    }
    printf("calling test_show_bytes\n");
    test_show_bytes(val);
  } else {
    printf("calling show_twocomp\n");
    show_twocomp();
    printf("Calling simple_show_a\n");
    simple_show_a();
    printf("Calling simple_show_b\n");
    simple_show_b();
    printf("Calling float_eg\n");
    float_eg();
    printf("Calling string_ueg\n");
    string_ueg();
    printf("Calling string_leg\n");
    string_leg();
  }

  /* Practice Problem 2.5 */
  printf("Practice Problem 2.5\n");
  /* int val = 0x87654321; */
  val = 0x87654321;
  byte_pointer valp = (byte_pointer) &val;
  show_bytes(valp, 1); /* A. */
  show_bytes(valp, 2); /* B. */
  show_bytes(valp, 3); /* C. */

  /* Practice Problem 2.7 */
  printf("Practice Problem 2.7\n");
  const char *s = "abcdef";
  show_bytes((byte_pointer) s, strlen(s));

  /* Homework 2.57 */
  printf("Homework 2.57\n");
  show_short(5);
  show_long(5);
  show_double(5.0);

  /* Homework 2.58 */
  printf("Homework 2.58\n");
  printf("Is little endian? %d\n", is_little_endian());

  /* Homework 2.59 */
  printf("Homework 2.59\n");
  printf("x=0x89ABCDEF and y=0x76543210 -> 0x765432EF\n");
  printf("%X\n", (0x89ABCDEF & 0xFF) | (0x76543210 & 0xFFFFFF00));

  return 0;
}
