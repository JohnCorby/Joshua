extern printf
extern puts
format db 'addr of msg is %p', 10, 0
msg db 'hello world', 0
global main
main:
enter 0, 0
mov dword [ebp - 4], format
mov dword [ebp - 8], msg

push dword [ebp - 8]
push dword [ebp - 4]
call printf
add esp, 8

push dword [ebp - 8]
call puts
add esp, 4
leave
ret