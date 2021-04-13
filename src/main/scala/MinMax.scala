class MinMax {
  var knoten = 0

  def negamax(board: Board, player:Int):Int={
    knoten = 0;
    val action = board.possibleActions.minBy(negamax(board, _, player, Int.MinValue, Int.MaxValue))
    println("Erstellte Knoten: "+knoten)
    action
  }

  def negamax(board:Board,action:Int,player:Int,alpha:Int,beta:Int): Int ={
    if(board.full || board.checkWin(1) || board.checkWin(-1)) {
      return board.evaluation(player)
    }
    var v = Int.MinValue
    var nalpha = alpha
    val nboard = board.set(player,action)
    nboard.possibleActions.foreach(a=>{
      knoten = knoten+1
      v = math.max(v,-negamax(nboard.set(-player,a),a,-player,-beta,-nalpha))
      nalpha = math.max(nalpha,v)
      if(nalpha >= beta)
        return v
    })
    return v
  }
}
