case class Board(board:Vector[Int] = Vector.fill(9)(0),counter:Int = 0){

  def set(player:Int,i:Int): Board = {
    if(board(i) != 0)
      this
    else
      this.copy(board = board.updated(i,player),counter = counter+1)
  }

  def checkWin(player:Int): Boolean ={
    board(0) == player && board(1) == player && board(2) == player ||
        board(3) == player && board(4) == player && board(5) == player ||
        board(6) == player && board(7) == player && board(8) == player ||
        board(0) == player && board(3) == player && board(6) == player ||
        board(1) == player && board(4) == player && board(7) == player ||
        board(2) == player && board(5) == player && board(8) == player ||
        board(0) == player && board(4) == player && board(8) == player ||
        board(2) == player && board(4) == player && board(6) == player
  }
  def possibleActions:Vector[Int] = {
    var actions = Vector[Int]()
    for(i<-board.indices){
      if(board(i)==0){
        actions = actions :+ i
      }
    }
    actions
  }
  def full :Boolean = counter == 9

  def evaluation(player:Int):Int ={
    if(checkWin(-player))
      1
    else if (checkWin(player))
      -1
    else
      0
  }
  override def toString: String = {
    var tmp = ""
    for (i <- board.indices){
      if(board(i) == 0)
        tmp = tmp + "_ "
      else if(board(i) == 1)
        tmp = tmp + "X "
      else
        tmp = tmp + "O "
      if(i == 2 || i == 5)
        tmp = tmp + "\n"
    }
    tmp
  }
}
