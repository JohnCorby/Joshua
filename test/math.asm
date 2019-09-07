extern printf
format db '%u', 0
global main
main:
enter 0, 0
mov eax, 1
mov edx, 1
imul eax, edx
mov ecx, 1
mov ebx, 1
imul ecx, ebx
add eax, ecx
mov ecx, 1
mov esi, 1
imul ecx, esi
mov edi, 1
mov ebp, 1
imul edi, ebp
mov esp, 1
add edi, esp
mov esp, 1
imul edi, esp
add ecx, edi
add eax, ecx
mov ecx, 1
mov edi, 1
imul ecx, edi
add eax, ecx
mov ecx, 1
add eax, ecx
mov dword [ebp - 4], eax
push dword [ebp - 4]
push format
call printf
add esp, 12

mov eax, 0
leave
ret