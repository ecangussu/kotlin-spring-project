package com.ehcanza.book_market.enums

enum class Errors(val code: String, val message: String) {

    BM0001("BM-0001", "Dados de requisição inválidos"),
    BM1001("BM-1001", "Livro [%s] não existe"),
    BM1002("BM-1002", "Não é possível atualizar livros de status [%s]"),
    BM2001("BM-2001", "Cliente [%s] não existe")

}