extern printf
extern puts
format db 'addr of msg is %p', 10, 0
msg db 'hello world', 0
global main
main:
enter 0, 0
push msg
push format
call printf
add esp, 8

push msg
call puts
add esp, 4
leave
ret