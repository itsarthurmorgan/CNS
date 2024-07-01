#include <stdio.h>

int main() {
    char str[] = "Hello world";
    int i;

    printf("Original String: %s\n", str);

    // AND operation with 127
    printf("AND with 127: ");
    for (i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] & 127);
    }
    printf("\n");

    // OR operation with 127
    printf("OR with 127: ");
    for (i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] | 127);
    }
    printf("\n");

    // XOR operation with 127
    printf("XOR with 127: ");
    for (i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] ^ 127);
    }
    printf("\n");

    return 0;
}
