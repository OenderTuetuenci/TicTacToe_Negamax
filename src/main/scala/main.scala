object main {
  var player = 1
  var board: Board = Board()
  var ki:MinMax = new MinMax()

  def main(args: Array[String]): Unit = {
  var input = ""
    do {
      board = board.set(player,ki.negamax(board,player))
      changePlayer()
      println(board.toString)
      input = scala.io.StdIn.readLine()
      if (input == "n") initBoard()
      else if (input == "q") System.exit(69)
      else{
        board = board.set(player,input.toInt)
        println(board.toString)
        changePlayer()
      }
    } while (true)
  }
  def initBoard(): Unit = board = Board()
  def changePlayer(): Unit = player = -player
}
