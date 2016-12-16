# HF Security
encrypt.o: encrypt.c
	gcc -c encrypt.c -o encrypt.o

checksum.o: checksum.c
	gcc -c checksum.c -o checksum.o

libhfsecurity.a: encrypt.o checksum.o
	ar -rcs libhfsecurity.a encrypt.o checksum.o

bank_vault: bank_vault.c libhfsecurity.a
	gcc bank_vault.c -I. -L. -lhfsecurity -o bank_vault

# HF Cal
hfcal.o: hfcal.c
	gcc -I. -c hfcal.c -o hfcal.o

libhfcal.a: hfcal.o
	ar -rcs libhfcal.a hfcal.o

elliptical.o: elliptical.c libhfcal.a
	gcc elliptical.c -I. -L. -lhfcal -o elliptical
