#!/usr/bin/python

# UDACITY - Software Testing (CS258)
# Lesson 4 Problem Set - Fuzzer
# Python: 3.3.2

# 5-line fuzzer below is from Charlie Miller's
# "Babysitting an Army of Monkeys":
# Part 1 - http://www.youtube.com/watch?v=Xnwodi2CBws
# Part 2 - http://www.youtube.com/watch?v=lK5fgCvS2N4

# List of files to use as initial seed
file_list=[
    "myfile.rtf",
    "doc_text.rtf",
    "doc_img.rtf",
    "doc_formatted.rtf",
    "doc_empty.rtf"
    ]

# List of applications to test
apps = ["c:\Program Files (x86)\Windows NT\Accessories\wordpad.exe"]

fuzz_output = "file.rtf"

FuzzFactor = 250
num_tests = 10000
num_crashes = 0

########### end configuration ##########

import math
import random
import string
import subprocess
import time

for i in range(num_tests):
    file_choice = random.choice(file_list)
    app = random.choice(apps)

    buf = bytearray(open(file_choice, 'rb').read())

    # start Charlie Miller code
    numwrites=random.randrange(math.ceil((float(len(buf)) / FuzzFactor)))+1

    for j in range(numwrites):
        rbyte = random.randrange(256)
        rn = random.randrange(len(buf))
        buf[rn] = rbyte
    #end Charlie Miller code

    open(fuzz_output, 'wb').write(buf)

    process = subprocess.Popen([app, fuzz_output])

    time.sleep(0.1)
    crashed = process.poll()
    if not crashed:
        process.terminate()
    else:
        num_crashes += 1
        print('Crash:(', num_crashes, '): ', crashed)
    time.sleep(0)
