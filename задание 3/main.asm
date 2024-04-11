format PE Console
entry start

include 'includes\win32a.inc'

section '.data' data readable writeable
    prime_data dd 2, 3, 4, 5
    result dd 0
    print_temp db 'Result: %d', 0

section '.code' code readable writeable executable
start:
    mov esi, prime_data
    mov ecx, 10
    xor eax, eax
    mov ebx, 2
loop_start:
    cmp dword [esi], 1
    jbe skip
    mov edi, 2
    mov edx, dword [esi]
    check_div:
        cmp edi, edx
        jg prime
        mov eax, edx
        cdq
        idiv edi
        cmp edx, 0
        je not_prime
        inc edi
        jmp check_div
prime:
    inc dword [result]
not_prime:
    add esi, 4
    loop loop_start
skip:
    push dword [result]
    push print_temp
    call [printf]
    add esp, 8
    invoke ExitProcess, 0

section '.idata' data import readable
    library kernel, 'kernel32.dll',\
            msvcrt, 'msvcrt.dll'
    
    import kernel,\
            ExitProcess, 'ExitProcess'
          
    import msvcrt,\
            printf, 'printf'