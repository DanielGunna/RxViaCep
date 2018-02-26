/**
 MIT License

 Copyright (c) 2018 Daniel Gunna

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.

 */


package br.gunna.rxviacep;

/**
 * Created by Daniel on 23/02/18.
 */

public class Constants {
    public static final String CEP_NOT_FOUND_ERROR_MSG = "Cep não encontrado ou inválido!";
    public static final String UNEXPECTED_ERROR_MSG = "Ocorreu algo inesperado!";
    public static final String NETWORK_ERROR_MSG = "Parece que você está com problemas de conexão";
    public static final int CEP_LENGTH = 8;
    public static final String CEP_INVALID_FORMAT_ERROR = "Formato de CEP inválido! Exemplo de formato válido (XXXXX-XXX)";
}
