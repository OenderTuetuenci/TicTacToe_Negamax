import org.scalatest.wordspec.AnyWordSpec

class BoardSpec extends AnyWordSpec {

  "A board" when {

    var board = Board(Vector(), 0)

    "new" should {
      "have a filled Vector" in {
        assert(!board.board.contains(1) === true)
      }
      "have a counter with 0" in {
        assert(board.counter === 0)
      }
    }

    "in idle" should {
      "set field correctly player1" in {
        board = board.set(0, 0)
        assert(board.board(0) == 1)
      }
      "set field correctly player2" in {
        board = board.set(1, 1)
        assert(board.board(0) == 2)
      }
      "win when one player has won" in {

      }
      "pass when no one won and board is full" in {

      }
      "possible actions retrun all possibilitys" in {

      }
    }
  }
}
