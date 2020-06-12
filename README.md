# Motivation
I've always been fascinated with compiled languages because their closeness to raw machine code.
Therefore, I wanted to create my own.

# The Problem
Creating a language is obviously challenging,
and I don't want to reinvent the wheel here,
so I've decided to make something that transforms to C.
This should make it very expansive,
since C has been around so long
that there are many many compilers for it
targetting different architectures.

# But there are already a ton of great compiled languages, even ones that expand upon C!
There have been a good number of extensions to C, like C++ or D.
However, I come from a Java background and therefore am used to Java syntax.
The problem I have with these extensions is that they introduce a good number of what I see as oddities in their syntax.
Also, sometimes the languages can be a bit annoying to use when doing bare-metal programming,
since they might require some runtime or an system to support it.

# Also
This language is not only meant to stick to (hopefully) easier to read syntax,
but also to give the programmer more freedom of choice.
For example, maybe you want a simple lightweight object that is compiled down to just a struct and functions,
but maybe you want an object that is more reflection-aware, at the cost of memory for that information.
Like Rust, I believe that a programmer should be protected from silly mistakes,
but still be given the opportunity to do something potentially dangerous if it's easier for them.
