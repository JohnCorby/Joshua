package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarParser
import com.johncorby.joshua.symbol.*
import org.antlr.v4.runtime.CharStreams

fun parse() = parse<Ast.Program>(CharStreams.fromFileName(IN_PATH), GrammarParser::program)

/**
 * defines higher level ast
 * constructed by antlr ast
 */
sealed class Ast {
    abstract fun eval(): Any

    data class Program(val statements: List<Statement>) : Ast() {
        override fun eval() = statements.forEach(Statement::eval)
    }

    sealed class Statement : Ast() {
        abstract override fun eval()

        data class VarDeclare(val type: String, val name: String, val value: Expr?) : Statement() {
            override fun eval() {
                if (InternFunc.current == null)
                    GlobalVar(type.toType(), name, value?.eval())
                else
                    FrameVar(type.toType(), name, value?.eval())
                // todo param vars
            }
        }

        data class VarAssign(val name: String, val value: Expr) : Statement() {
            override fun eval() = symbols.get<Var>(name).assign(value.eval())
        }

        data class FuncDeclare(
            val type: String,
            val name: String,
            val args: List<VarDeclare>,
            var block: List<Statement>?
        ) : Statement() {
            override fun eval() {
                if (block != null)
                    InternFunc(type.toType(), name, args, block as List<Statement>)
                else
                    ExternFunc(type.toType(), name, args)
            }
        }

        data class FuncCall(val name: String, val args: List<Expr>) : Statement() {
            override fun eval() {
                symbols.get<Func>(name).call(args.map(Expr::eval))
            }
        }

        data class Asm(val code: String) : Statement() {
            override fun eval() =
                AsmString.add(code.replace("""\{(.+?)}""".toRegex()) { (symbols.get<Symbol>(it.groupValues[1]) as Resolvable).resolve() })
        }
    }

    sealed class Expr : Ast() {
        abstract override fun eval(): Reg

        data class Binary(val left: Expr, val right: Expr, val op: kotlin.String) : Expr() {
            override fun eval() = Reg.binaryOp(left.eval(), right.eval(), op)
        }

        data class Func(val name: kotlin.String, val args: List<Expr>) : Expr() {
            override fun eval() = symbols.get<com.johncorby.joshua.symbol.Func>(name).call(args.map(Expr::eval))
        }

        data class Var(val name: kotlin.String) : Expr() {
            override fun eval() = Reg.load(symbols.get<com.johncorby.joshua.symbol.Var>(name).resolve())
        }

        data class Int(val value: kotlin.Int) : Expr() {
            override fun eval() = Reg.load(value.toString())
        }

        data class Float(val value: kotlin.Float) : Expr() {
            override fun eval() = Reg.load(value.toString())
        }

        data class Char(val value: kotlin.Char) : Expr() {
            override fun eval() = Reg.load(value.toString())
        }

        data class String(val value: kotlin.String) : Expr() {
            override fun eval() = Reg.load(value)
        }
    }
}
