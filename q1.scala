import scala.io.StdIn.readLine

object q1 extends App {

  def encrypt(shift: Int, str: String): String = {
    var cipher = ""

    for (letter <- str) {
      val base = if (letter.isUpper) 'A' else 'a'
      val newLetter = (letter.toInt - base.toInt + shift) % 26
      cipher += (newLetter + base.toInt).toChar
    }

    cipher
  }

  def decrypt(shift: Int, str: String): String = {
    var cipher = ""

    for (letter <- str) {
      val base = if (letter.isUpper) 'A' else 'a'
      val newLetter = (letter.toInt - base.toInt - shift + 26) % 26
      cipher += (newLetter + base.toInt).toChar
    }

    cipher
  }

  def cipher(
      function: (Int, String) => String,
      str: String,
      shift: Int
  ): String = {
    function(shift, str)
  }

  val string = readLine("Enter the string: ")
  val shift = readLine("Enter the shift : ")
  val shiftInt = shift.toInt

  val action = readLine("Do you want to encrypt or decrypt(e/d) ? ")

  action match {
    case "e" => println(cipher(encrypt, string, shiftInt))
    case "d" => println(cipher(decrypt, string, shiftInt))
    case _   => println("Enter e or d")
  }

}
