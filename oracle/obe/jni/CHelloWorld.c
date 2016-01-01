#include <jni.h>
#include <stdio.h>
#include "CHelloWorld.h"

JNIEXPORT void JNICALL Java_CHelloWorld_printHelloWorld (JNIEnv *env,
                                                         jobject obj) {
    printf("Hello World\n");
}

JNIEXPORT void JNICALL Java_CHelloWorld_printNative (JNIEnv *env,
                                                     jclass jcl,
                                                     jstring javaString) {
    jboolean isCopy;
    const char *nativeString = (*env)->GetStringUTFChars(env, javaString, &isCopy);
    printf(isCopy == 1 ? "1" : "0");
    printf("/");
    printf("%s", nativeString);
    printf("\n");
    if (isCopy) {
        (*env)->ReleaseStringUTFChars(env, javaString, nativeString);
    }
}
