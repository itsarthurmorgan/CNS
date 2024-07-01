#include <stdio.h>

int main() {
    char str[] = "Hello world";
    int i;

    for (i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] ^ 0);
    }
    printf("\n");

    return 0;
}
