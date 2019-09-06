dword printf();
dword puts();

asm "
    format db 'addr of msg is %p', 10, 0
    msg db 'hello world', 0
";

dword main() {
    dword format;
    dword msg;
    asm "
        mov .format, format
        mov .msg, msg

        push .msg
        push .format
        call printf
        add esp, 8

        push .msg
        call puts
        add esp, 4
    ";
}
