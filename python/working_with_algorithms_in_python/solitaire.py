"""
Game Solitaire

A game typically with 15 holes, 14 pegs. Goal is to reduce down to 1 peg.
A move is possible to jump over a neighbor peg into an empty hole. The
neighbor peg will be removed. Moves can be continued if possible.
"""

import logging
logger = logging.getLogger(__name__)

def new_game(n=5, init_empty=(2, 4)):
    board = {}

    for r in range(n):
        for c in range(r, 2 * n - 1 - r, 2):
            board[(r, c)] = True

    board[init_empty] = False
    logger.debug("New game:\n{}".format(draw_board(board, n)))

    return board

def _draw_row(board, n, r):
    row = " " * r
    for i in range(r, 2 * n - r, 2):
        if board[(r, i)]:
            row += "* "
        else:
            row += "o "
    return row

def draw_board(board, n):
    r = []
    for row in range(n - 1, -1, -1):
        r.append(_draw_row(board, n, row))

    return "\n".join(r)

def moves(board):
    """
    return legal moves as a list
    each move is a tuple: (hole, deltas)

    :param board:
    :return:
    """
    # delta in the format of (delta_row, delta_col)
    # deltas is list of delta
    deltas = [(0, 4), (0, -4), (2, 2), (2, -2), (-2, 2), (-2, -2)]
    legal_moves = []

    for hole in board:
        if board[hole]:
            for delta in deltas:
                mid = (hole[0] + delta[0] / 2, hole[1] + delta[1] / 2)
                end = (hole[0] + delta[0], hole[1] + delta[1])
                if mid in board and board[mid] and \
                                end in board and not board[end]:
                    legal_moves.append((hole, delta))

    logger.debug("board: {}".format(board))
    logger.debug("legal_moves: {}".format(legal_moves))
    return legal_moves

def move_peg(board_state, move):
    """
    update board after a move.

    :param board_state: tuple of (board, path)
    :param move: tuple of (peg, deltas), such as ((0, 2), (2, 2))
    :return: None
    """
    board, path = board_state
    peg, deltas = move
    logger.debug("before move: {}".format(board))

    mid = (peg[0] + deltas[0] / 2, peg[1] + deltas[1] / 2)
    end = (peg[0] + deltas[0], peg[1] + deltas[1])

    board[peg] = False
    board[mid] = False
    board[end] = True

    path.append(move)
    logger.debug("move: {}".format(move))
    logger.debug("after move: {}".format(board))

def unmove_peg(board_state, move):
    """
    update board after undoing a move.

    :param board_state: tuple of (board, path)
    :param move: tuple of (peg, deltas), such as ((0, 2), (2, 2))
    :return: None
    """
    board, path = board_state
    hole, deltas = move
    logger.debug("before unmove: {}".format(board))

    mid = (hole[0] + deltas[0] / 2, hole[1] + deltas[1] / 2)
    end = (hole[0] + deltas[0], hole[1] + deltas[1])

    board[hole] = True
    board[mid] = True
    board[end] = False

    del path[-1]
    logger.debug("unmove: {}".format(move))
    logger.debug("after unmove: {}".format(board))


def solve(board_state):
    board, path = board_state

    if len(path) == len(board) - 2:
        return True

    for move in moves(board):
        move_peg(board_state, move)
        if solve(board_state):
            return True
        unmove_peg(board_state, move)

    return False

if __name__ == "__main__":
    # # function test
    # N = 5
    # board = new_game(n=N, init_empty=(2, 4))
    # path = []
    #
    # draw_board(board, N)
    # print(moves(board))
    # move = moves(board)[0]
    #
    # move_peg((board, path), move)
    # draw_board(board, N)
    # print(moves(board))
    #
    # unmove_peg((board, path), move)
    # draw_board(board, N)
    # print(moves(board))

    import logging
    this_logger = logging.getLogger("__main__")
    this_logger.setLevel(logging.INFO)
    h1 = logging.StreamHandler()
    this_logger.addHandler(h1)

    # solve
    N = 5
    board = new_game(n=N, init_empty=(2, 4))
    path = []
    solve((board, path))
    this_logger.warning("Solved! path:\n{}".format(path))

    # step-by-step demo
    N = 5
    board = new_game(n=N, init_empty=(2, 4))
    second_path = []
    for move in path:
        board_state = (board, second_path)
        move_peg(board_state, move)
        this_logger.info(move)
        this_logger.info(draw_board(board, N))

