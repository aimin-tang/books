"""
sq is a list of n * n numbers. It starts with all 0's. It will be
filled one by one.
"""
import math

def new_sq(n=3):
    return [0 for i in range(n * n)]

def legal_nums(sq):
    n = int(math.sqrt(len(sq)))
    nums = set([i+1 for i in range(n * n)])
    for num in sq:
        if num > 0:
            nums.remove(num)
    return nums

def add_num(sq, num):
    filled_count = 0
    for n in sq:
        if n > 0:
            filled_count += 1
    sq[filled_count] = num

def del_num(sq, num):
    filled_count = 0
    for n in sq:
        if n > 0:
            filled_count += 1
    sq[filled_count - 1] = 0

def find_rows(sq):
    n = int(math.sqrt(len(sq)))
    rows = []
    for r in range(n):
        rows.append([sq[i] for i in range(r * n, r * n + n)])
    return rows

def find_cols(sq):
    n = int(math.sqrt(len(sq)))
    cols = []
    for c in range(n):
        cols.append([sq[i * n + c] for i in range(n)])
    return cols

def find_diags(sq):
    n = int(math.sqrt(len(sq)))
    diags = []
    diags.append([sq[i * n + i] for i in range(n)])
    diags.append([sq[i * n + n - i - 1] for i in range(n)])
    return diags

def valid_upto(sq, expected_sum):
    n = int(math.sqrt(len(sq)))

    rows = find_rows(sq)
    for row in rows:
        if all(row) and sum(row) != expected_sum:
            return False

    cols = find_cols(sq)
    for col in cols:
        if all(col) and sum(col) != expected_sum:
            return False

    diags = find_diags(sq)
    for diag in diags:
        if all(diag) and sum(diag) != expected_sum:
            return False

    return True

def solve(sq):
    n = int(math.sqrt(len(sq)))
    expected_sum = sum([i for i in range(1, n * n + 1)]) / n

    if len(legal_nums(sq)) == 0:
        if all([sum(row) == expected_sum for row in find_rows(sq)]) and \
                all([sum(col) == expected_sum for col in find_cols(sq)]) and \
                all([sum(diag) == expected_sum for diag in find_diags(sq)]):
            return True
        else:
            return False

    for num in legal_nums(sq):
        add_num(sq, num)
        if valid_upto(sq, expected_sum) and solve(sq):
            return True
        del_num(sq, num)

    return False

if __name__ == "__main__":
    # test functions
    # N = 4
    # sq = new_sq(N)
    # print(sq)
    # # print(legal_nums(sq))
    # print("add: 1")
    # add_num(sq, 1)
    # print(sq)
    # print(legal_nums(sq))
    # print("add: 9")
    # add_num(sq, 9)
    # print(sq)
    # print(legal_nums(sq))
    # print("del: 9")
    # del_num(sq, 9)
    # print(sq)
    # print(legal_nums(sq))

    # run real task
    N = 4
    sq = new_sq(N)
    r = solve(sq)
    print(r)
    print(sq)
