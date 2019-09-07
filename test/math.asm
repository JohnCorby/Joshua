extern printf
format db '%u', 0
global main
main:
enter 0, 0
mov eax, 1
mov edx, 1
imul eax, edx
mov edx, 1
mov ecx, 1
imul edx, ecx
add eax, edx
mov edx, 1
mov ecx, 1
imul edx, ecx
mov ecx, 1
mov ebx, 1
imul ecx, ebx
mov ebx, 1
add ecx, ebx
mov ebx, 1
imul ecx, ebx
add edx, ecx
add eax, edx
mov edx, 1
mov ecx, 1
imul edx, ecx
add eax, edx
mov edx, 1
add eax, edx
mov dword [ebp - 4], eax
push dword [ebp - 4]
push format
call printf
add esp, 12

mov eax, 0
leave
ret