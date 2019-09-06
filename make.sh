export IN=${1%.*}

nasm -f elf32 -g -F dwarf $IN.asm -o $IN.o &&
  #  rm $IN.asm &&
  gcc -m32 $IN.o -o $IN &&
  rm $IN.o &&
  ./$IN &&
  rm $IN
